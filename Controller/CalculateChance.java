package Controller;

import java.util.LinkedList;
import java.util.List;

import Model.*;

public class CalculateChance {
    
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
        // Random random = new Random();
        // for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {
            
        //     int index = random.nextInt(count); // Выбираем случайный индекс из воображаемого массива

        //     for (int i = 0; i < quantity.size(); i++) { // Ищем элемент, которому принадлежит этот индекс
        //         index -= quantity.get(i);
        //         if(index < 0) {
        //             System.out.println("Результат: " + name.get(i));
        //             break;
        //         }
        //     }

        // }
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
