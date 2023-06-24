package Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Model.*;

public class Draw {
    
    public static List<Double> calculatingСhance(List<String> name, List<Integer> quantity) {
        List<Double> listChanceDraw = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < quantity.size(); i++){
            count += quantity.get(i);
        }

        for (int i = 0; i < quantity.size(); i++) {
            listChanceDraw.add(quantity.get(i)*100d/count);
        }
        return listChanceDraw;

    }

    public static Toy drawToy(List<Toy> ware, List<Integer> quantity) {
        int count = 0;
        for(int i = 0; i < quantity.size(); i++){
            count += quantity.get(i);
        }
        Random random = new Random();
        int index = random.nextInt(count); 
        int i = 0;
        for(Toy toy: ware) {
            index -= quantity.get(i);
            i++;
            if(index < 0) {
                return toy;
            }
        }
        return null;
    }
    

    public static List<String> getNameToys(List<Toy> ware) {
        List<String> listNameT = new LinkedList<>();
        for(Toy nameToy: ware) {
            listNameT.add(nameToy.getName());
        } 
        return listNameT;
    }
    
    public static List<Integer> getQuantityToys(List<Toy> ware) {
        List<Integer> listQuantityT = new LinkedList<>();
        for(Toy quantityToy: ware) {
            listQuantityT.add(quantityToy.getQuantity());
        }
        return listQuantityT;
    }


}
