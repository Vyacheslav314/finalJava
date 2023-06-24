package Model;

import java.io.Serializable;

public class Toy implements Serializable {

    private String uid;
    private String name;
    private int quantity;
    private int chance;

    public Toy(String uid, String name, int quantity, int chance) {
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public String getUid() {
        return uid;
    }
    public void setId(String uid) {
        this.uid = uid;
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

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    
    @Override
    public String toString() {
        return String.format("id: %s\nname: %s\nquantity: %d\nchance: %d", uid, name, quantity, chance);
    }


}