package View;
import java.util.List;
import java.util.Scanner;
import Controller.*;
import Controller.Logging;
import Model.*;

public class Menu {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void menu() {

        Toy softToy1 = new Toy(CreateUid.newUid(), "Bear", 20, 0.0);
        Toy softToy2 = new Toy(CreateUid.newUid(), "Bear", 70, 0.0);
        Logging.someMethod();
        WareHouse ware = new WareHouse();

        ware.addToy(softToy1);
        ware.addToy(softToy2);

        boolean isValid = true;
        while (isValid) {
            System.out.println("Введите команду:\n1.Показать список игрушек\n2.Добавить игрушку\n3.Удалить игрушку\n4.Забрать выйгрыш\n5.Завершить работу");
            int command = scanner.nextInt();
            switch(command) {
                case 1:
                ware.showToys();
                break;
                case 2:
                Toy newToy = new Toy();
                ware.addToy(newToy);
                break;
                case 3:
                List<String> a = CalculateChance.getNameToys(ware.getWareToys());
                List<Integer> b = CalculateChance.getQuantityToys(ware.getWareToys());
                List<Double> c = CalculateChance.calculatingСhance(a, b);
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                ChangeProperty.changeChance(ware.getWareToys(), c);

                break;
                case 4:
                break;
                case 5:
                break;
            }
                
            
        }
    }
}
