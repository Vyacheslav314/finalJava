package Model;

import java.io.Serializable;
import java.util.Scanner;

public class Toy implements Serializable {

    static Scanner scanner = new Scanner(System.in);

    private String uid;
    private String name;
    private int quantity;
    private Double chance;

    public Toy(String uid, String name, int quantity, Double chance) {
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public Toy() {
        this.uid = CreateUid.newUid();
        System.out.println("Введите название игрушки");
        this.name = scanner.nextLine();
        System.out.println("Укажите сколько игрушек в наличии");
        this.quantity = scanner.nextInt();
        this.chance = 0.0;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getChance() {
        return chance;
    }

    public void setChance(Double chance) {
        this.chance = chance;
    }
    
    @Override
    public String toString() {
        return String.format("id: %s\nname: %s\nquantity: %d\nchance: %f", uid, name, quantity, chance);
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}