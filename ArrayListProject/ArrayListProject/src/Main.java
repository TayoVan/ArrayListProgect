import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Лабораторна робота №8: Власна колекція (Варіант 20)");
        System.out.println("Тип структури: Linked ArrayList (Ланцюжок масивів)");
        System.out.println("Розмір одного блоку: 5 елементів");
        Scanner scanner = new Scanner(System.in);
        MyArrayList list = new MyArrayList();
        boolean run = true;
        while (run) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Додати елемент в кінець");
            System.out.println("2. Додати елемент за індексом");
            System.out.println("3. Отримати елемент за індексом");
            System.out.println("4. Видалити елемент за індексом");
            System.out.println("5. Показати метрики (Size & Capacity)");
            System.out.println("6. Вивести весь список");
            System.out.println("7. Очистити список");
            System.out.println("8. Вихід");
            System.out.print("Ваш вибір: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 9) {
                    switch (choice) {
                        case 1:
                            System.out.print("Введіть значення елемента: ");
                            int valEnd = scanner.nextInt();
                            list.add(valEnd);
                            System.out.println("Додано успішно.");
                            scanner.nextLine();
                            break;
                        case 2:
                            try {
                                System.out.print("Введіть індекс: ");
                                int idxAdd = scanner.nextInt();
                                System.out.print("Введіть значення: ");
                                Object valIdx = scanner.nextInt();
                                if (valIdx.equals("null")) {
                                    throw new NullElement();
                                }
                                list.addAt(idxAdd, valIdx);
                                System.out.println("Додано успішно.");
                                scanner.nextLine();
                                break;
                            } catch (InvalidIndex e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.print("Введіть індекс: ");
                            int idxGet = scanner.nextInt();
                            Object result = list.get(idxGet);
                            System.out.println("Значення за індексом " + idxGet + ": " + result);
                            break;
                        case 4:
                            System.out.print("Введіть індекс для видалення: ");
                            int idxRem = scanner.nextInt();
                            list.remove(idxRem);
                            System.out.println("Видалено успішно.");
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.println("Метрики структури:");
                            System.out.println("- Поточний розмір (Size): " + list.size());
                            System.out.println("- Загальна місткість (Capacity): " + list.capacity());
                            scanner.nextLine();
                            break;
                        case 6:
                            list.print();
                            break;
                        case 7:
                            list.clear();
                            System.out.println("Список очищено.");
                            scanner.nextLine();
                            break;
                        case 8:
                            run = false;
                    }
                } else {
                    System.out.println("Помилка: Введіть число від 0 до 8.");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Не вірно вказано значення");
                break;
        }
    }
}
}
