package Controller;

import java.util.List;

import Model.*;

public class ChangeProperty {
    

    public static void changeChance(List<Toy> ware, List<Double> chance) {
        int index = 0;
        for(Toy toy: ware) {
            toy.setChance(chance.get(index));
            index++;
        }
    }

    public static void changeQuantity(List<Toy> ware, String uid) {
        for(Toy toy: ware) {
            if(toy.getUid() == uid) {
                toy.setQuantity(toy.getQuantity() - 1);
            }
        }
    }
    
}
