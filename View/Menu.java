package View;
import java.io.IOException;
import java.util.Scanner;
import Controller.*;
import Controller.Logging;
import Model.*;

public class Menu {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void menu() {

        Toy softToy1 = new Toy(CreateUid.newUid(), "Bear", 20, 40);
        Logging.someMethod();


        boolean isValid = true;
        while (isValid) {
            System.out.println("Введите команду:\n1.Показать список игрушек\n2.Добавить игрушку\n3.Удалить игрушку\n4.Забрать выйгрыш\n5.Завершить работу");
            int command = scanner.nextInt();
            if(command == 1) {
                try {
                    WareHouse.deSerializable();
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }else if(command == 2) {
                try {
                    WareHouse.serializable(softToy1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(command == 3) {
                
            }else if(command == 4) {

            }else if(command == 5) {

            }else {
                
            }
                
            
        }
    }
}
