import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        int taxe = 0;
        int expenses = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String costStr = scanner.nextLine();
                    int cost = Integer.parseInt(costStr);
                    spendings += cost;
                    break;
                case 3:
                    taxe = taxEarningsMinusSpendings(earnings, spendings);
                    expenses = taxEarnings(earnings);
                    if (taxe > expenses) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + (expenses) + " руб.");
                        System.out.println("Налог на другой системе: " + (taxe) + " руб.");
                        System.out.println("Экономия: " + (taxe - expenses) + " руб.");
                    } else if (taxe == expenses) {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + (taxe) + " руб.");
                        System.out.println("Налог на другой системе: " + (expenses) + " руб.");
                        System.out.println("Экономия: " + (taxe - expenses) + " руб.");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }

        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }

    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }

    }
}