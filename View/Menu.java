package View;
import java.util.List;
import java.util.Scanner;

import Controller.*;
import Controller.Logging;
import Model.*;

public class Menu {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void menu() {

        Toy softToy1 = new Toy(CreateUid.newUid(), "Bear", 20, 0.0);   // Зарание добавленные игрушки
        Toy softToy2 = new Toy(CreateUid.newUid(), "rabbit", 70, 0.0);
        Logging.someMethod(); // инициализация логера
        WareHouse ware = new WareHouse();
        DrawQueue draw = new DrawQueue();
        ware.addToy(softToy1);
        ware.addToy(softToy2);

        Logging.log.info("Старт программы!!!");

        boolean isValid = true;
        while (isValid) {

            List<String> a = Draw.getNameToys(ware.getWareToys());  // Получение списка игрушек
            List<Integer> b = Draw.getQuantityToys(ware.getWareToys()); // Получение списка количества игрушек
            List<Double> c = Draw.calculatingСhance(a, b);  // получение шанса основанный на типах игрушек и их количестве
            ChangeProperty.changeChance(ware.getWareToys(), c); // изменение шанса

            System.out.println("Введите команду:\n1.Показать список игрушек\n2.Добавить игрушку\n3.Розыграть игрушку\n4.Показать игрушки ожидающие выдачи\n5.Забрать выйгрыш\n6.Завершить работу");
            int command = scanner.nextInt(); 

            switch(command) {
                case 1:
                Logging.log.info("Запрос: список игрушек!!!");
                ware.showToys();
                break;
                case 2:
                Toy newToy = new Toy(); // создаем новую игрушку
                ware.addToy(newToy); //добавляем ее в список
                Logging.log.info("Создана новая игрушка!!!");
                break;
                case 3:
                Logging.log.info("Запущен розыгрыш!!!");
                Toy newDrawToy = Draw.drawToy(ware.getWareToys(), b); // получаем выйграную игрушку
                draw.addQueueToys(newDrawToy); // добавляем в очередь
                Logging.log.info("Игрушка\n" + newDrawToy + "\nРозыгранна и добавленна в очередь на выдачу");
                break;
                case 4:
                Logging.log.info("Запрос: очередь выдачи!!!");
                draw.showQueue();
                break;
                case 5:
                try {
                    Toy drawToy = draw.removeQueueToys(); // сохраняем удаленную игрушку
                    SaveDrawToy.writeDrawToy(drawToy); // сохраняем название игрушки в файл
                    ChangeProperty.changeQuantity(ware.getWareToys(), drawToy.getUid()); // находим игрушку по uid и уменьшаем количество на 1
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
