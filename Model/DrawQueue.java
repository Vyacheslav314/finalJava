package Model;

import java.util.ArrayDeque;
import java.util.Queue;

public class DrawQueue {
    
    Queue<Toy> drawToys;

    public DrawQueue() {
        this.drawToys = new ArrayDeque<>();
    }

    public void addQueueToys(Toy obj) {
        drawToys.add(obj);
    }

    public Toy removeQueueToys() {
        return drawToys.remove();
    }

    public void showQueue() {
        for (Toy toy : drawToys) {
            System.out.println(toy);
        }
    }

}
