package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WareHouse {

    public static void serializable(Toy objecToy) throws IOException {

       FileOutputStream outputStream = new FileOutputStream("wareHouse.ser");
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

       objectOutputStream.writeObject(objecToy);

       objectOutputStream.close();
    }

    public static void deSerializable() throws IOException, ClassNotFoundException {

       FileInputStream fileInputStream = new FileInputStream("wareHouse.ser");
       ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
        Toy wToy = (Toy) objectInputStream.readObject();

           System.out.println(wToy);
    
    }

}
