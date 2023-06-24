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

        Logging.log.info("Старт программы!!!");

        boolean isValid = true;
        while (isValid) {

            List<String> a = Draw.getNameToys(ware.getWareToys());
            List<Integer> b = Draw.getQuantityToys(ware.getWareToys());
            List<Double> c = Draw.calculatingСhance(a, b);
            ChangeProperty.changeChance(ware.getWareToys(), c);

            System.out.println("Введите команду:\n1.Показать список игрушек\n2.Добавить игрушку\n3.Розыграть игрушку\n4.Показать игрушки ожидающие выдачи\n5.Забрать выйгрыш\n6.Завершить работу");
            int command = scanner.nextInt();
            switch(command) {
                case 1:
                
                ware.showToys();
                break;
                case 2:
                Toy newToy = new Toy();
                ware.addToy(newToy);
                Logging.log.info("Создана новая игрушка!!!");
                break;
                case 3:
                Logging.log.info("Запущен розыгрыш!!!");
                Toy newDrawToy = Draw.drawToy(ware.getWareToys(), b);
                draw.addQueueToys(newDrawToy);
                Logging.log.info("Игрушка\n" + newDrawToy + "\nРозыгранна и добавленна в очередь на выдачу");
                break;
                case 4:
                draw.showQueue();
                break;
                case 5:
                try {
                    Toy drawToy = draw.removeQueueToys();
                    SaveDrawToy.writeDrawToy(drawToy);
                    Logging.log.info("Игрушка " + drawToy.getName() + " выданна");
                } catch (Exception e) {
                    System.out.println("Очередь пуста!!");
                    Logging.log.warning("Ой что то пошло не так");
                }
                break;
                case 6:
                isValid = false;
                break;
            }
                
            
        }
    }
}
