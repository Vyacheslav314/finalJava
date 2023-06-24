package Model;

import java.io.FileWriter;
import java.io.IOException;

public class SaveDrawToy {
    
    public static void writeDrawToy(Toy obj) {

         try(FileWriter writer = new FileWriter("issuedToys.txt", true))
        {
            String text = obj.getName();
            writer.write(text);
            // запись по символам
            writer.append('\n');
            
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    } 
    
}
