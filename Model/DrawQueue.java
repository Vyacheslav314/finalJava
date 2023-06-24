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

    // public void removeQueueToys(String uid) {
    //     drawToys.remove(uid);
    // }


}
