import java.util.ArrayList;
import java.util.Scanner;

public class MyPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NotesApp notes = new NotesApp();
        BankApp bank = new BankApp(1000.0); // Баштапкы баланс
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("\nМенюнун түрлөрү:");
            System.out.println("1. Заметки");
            System.out.println("2. Банк");
            System.out.println("3. Калькулятор");
            System.out.println("0. Чыгуу");
            System.out.print("Тандаңыз: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    notes.menu(scanner);
                    break;
                case 2:
                    bank.menu(scanner);
                    break;
                case 3:
                    calculator.menu(scanner);
                    break;
                case 0:
                    System.out.println("Программа жабылууда...");
                    return;
                default:
                    System.out.println("Туура эмес тандоо!");
            }
        }
    }
}

class NotesApp {
    private ArrayList<String> notes = new ArrayList<>();

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nЗаметки:");
            System.out.println("1. Заметка кошуу");
            System.out.println("2. Заметкаларды көрүү");
            System.out.println("3. Заметканы өзгөртүү");
            System.out.println("4. Заметканы өчүрүү");
            System.out.println("0. Артка");
            System.out.print("Тандаңыз: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Буферди тазалоо

            switch (choice) {
                case 1:
                    System.out.print("Жаңы заметка: ");
                    String note = scanner.nextLine();
                    notes.add(note);
                    System.out.println("Заметка кошулду!");
                    break;
                case 2:
                    if (notes.isEmpty()) {
                        System.out.println("Заметкалар жок.");
                    } else {
                        for (int i = 0; i < notes.size(); i++) {
                            System.out.println((i + 1) + ". " + notes.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Кайсы заметканы өзгөртөсүз? (номер): ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Буферди тазалоо
                    if (editIndex >= 0 && editIndex < notes.size()) {
                        System.out.print("Жаңы текст: ");
                        notes.set(editIndex, scanner.nextLine());
                        System.out.println("Заметка өзгөртүлдү!");
                    } else {
                        System.out.println("Туура эмес номер.");
                    }
                    break;
                case 4:
                    System.out.print("Кайсы заметканы өчүрөсүз? (номер): ");
                    int deleteIndex = scanner.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < notes.size()) {
                        notes.remove(deleteIndex);
                        System.out.println("Заметка өчүрүлдү!");
                    } else {
                        System.out.println("Туура эмес номер.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Туура эмес тандоо!");
            }
        }
    }
}

class BankApp {
    private double balance;

    public BankApp(double initialBalance) {
        this.balance = initialBalance;
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nБанк менюсу:");
            System.out.println("1. Балансты текшерүү");
            System.out.println("2. Акча которуу");
            System.out.println("0. Артка");
            System.out.print("Тандаңыз: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Сиздин балансыңыз: " + balance + " сом");
                    break;
                case 2:
                    System.out.print("Которуу суммасын киргизиңиз: ");
                    double amount = scanner.nextDouble();
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        System.out.println(amount + " сом которулду. Калган баланс: " + balance);
                    } else {
                        System.out.println("Которуу мүмкүн эмес. Балансыңызды текшериңиз.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Туура эмес тандоо!");
            }
        }
    }
}

class Calculator {
    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nКалькулятор:");
            System.out.println("1. Кошуу");
            System.out.println("2. Алу");
            System.out.println("3. Көбөйтүү");
            System.out.println("4. Бөлүү");
            System.out.println("0. Артка");
            System.out.print("Тандаңыз: ");
            int choice = scanner.nextInt();

            if (choice == 0) return;

            System.out.print("Биринчи санды киргизиңиз: ");
            double num1 = scanner.nextDouble();
            System.out.print("Экинчи санды киргизиңиз: ");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Жыйынтык: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Жыйынтык: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Жыйынтык: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Жыйынтык: " + (num1 / num2));
                    } else {
                        System.out.println("Нөлгө бөлүүгө болбойт!");
                    }
                    break;
                default:
                    System.out.println("Туура эмес тандоо!");
            }
        }
    }
}

