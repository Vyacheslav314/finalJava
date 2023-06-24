package Model;

import java.util.LinkedList;
import java.util.List;

public class WareHouse {
    
    public List<Toy> listToy;

    public WareHouse() {
        this.listToy = new LinkedList<>();
    }

    public void addToy(Toy obj) {
        listToy.add(obj);
    }

    // public void removeToy(String uid) {

    // }

    public void showToys() {
        int count = 0;
        for (Toy toy : listToy) {
            System.out.println(toy);
            count++;
        }
        System.out.printf("Результат поиска %d совпадений \n\n", count);
    }


    public List<Toy> getWareToys() {
        return listToy;
    }
}
