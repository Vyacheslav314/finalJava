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
        Toy softToy2 = new Toy(CreateUid.newUid(), "rabbit", 70, 0.0);
        Logging.someMethod();
        WareHouse ware = new WareHouse();
        DrawQueue draw = new DrawQueue();


        ware.addToy(softToy1);
        ware.addToy(softToy2);

        boolean isValid = true;
        while (isValid) {
            Logging.log.info("Старт программы!!!");

            List<String> a = Draw.getNameToys(ware.getWareToys());
            List<Integer> b = Draw.getQuantityToys(ware.getWareToys());
            List<Double> c = Draw.calculatingСhance(a, b);
            ChangeProperty.changeChance(ware.getWareToys(), c);

            System.out.println("Введите команду:\n1.Показать список игрушек\n2.Добавить игрушку\n3.Розыграть игрушку\n4.Забрать выйгрыш\n5.Завершить работу");
            int command = scanner.nextInt();
            switch(command) {
                case 1:
                ware.showToys();
                Logging.log.info("Запрос: список игрушек!!!");
                break;
                case 2:
                Toy newToy = new Toy();
                ware.addToy(newToy);
                Logging.log.info("Создана новая игрушка!!!");
                break;
                case 3:
                System.out.println(Draw.drawToy(ware.getWareToys(), b));
                draw.addQueueToys(Draw.drawToy(ware.getWareToys(), b));
                Logging.log.info("Запущен розыгрыш!!!");
                Logging.log.info("Игрушка " + Draw.drawToy(ware.getWareToys(), b) + "Розыгранна и добавленна в очередь на выдачу");
                break;
                case 4:
                Toy drawToy = draw.removeQueueToys();
                SaveDrawToy.writeDrawToy(drawToy);
                draw.showQueue();
                Logging.log.info("Игрушка" + drawToy.getName() + "выданна");
                break;
                case 5:
                isValid = false;
                break;
            }
                
            
        }
    }
}
