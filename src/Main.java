import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long earnings = 0;
        long spendings = 0;
        while (true) {

            if ("end".equals(sc)) {
                break;
            }
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("4. Показать введеные суммы доходов и расходов");
            String input = sc.nextLine();
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyErnStr = sc.nextLine();
                    int moneyErn = 0;
                    moneyErn = Integer.parseInt(moneyErnStr);
                    earnings += moneyErn;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneySpendStr = sc.nextLine();
                    int moneySpend = 0;
                    moneySpend = Integer.parseInt(moneySpendStr);
                    spendings += moneySpend;
                    break;
                case 3:
                    long tax1 = taxEarnings(earnings,spendings);
                    long tax2 = taxEarningsMinusSpendings(earnings,spendings);
                    taxСalculation(tax1, tax2);
                    break;
                case 4: //Справка
                    System.out.println("Введенное количество доходов " + earnings +
                            ", введенное количество расходов " + spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }


        }
        System.out.println("Программа завершена!");
    }
    public static long taxEarnings(long earnings, long spendings) {
        long tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static long taxEarningsMinusSpendings(long earnings, long spendings) {
        long tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static void taxСalculation(double tax1, double tax2) {
        if (tax1<tax2) {
            double tax = tax2 - tax1;
            System.out.println("Мы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + tax1 + " рублей");
            System.out.println("Налог на другой системе: " + tax2 + " рублей");
            System.out.println("Экономия: "  + tax + " рублей");
        } else if (tax1>tax2) {
            double tax = tax1 - tax2;
            System.out.println("Мы советуем вам УСН доходы минус расходы:");
            System.out.println("Ваш налог составит: " + tax2 + " рублей");
            System.out.println("Налог на другой системе: " + tax1 + " рублей");
            System.out.println("Экономия: "  + tax + " рублей");
        } else {
            System.out.println("Обе налоговые системы равнозначны с вашими доходами и расходами. Выберете любую из них");
        }
    }
}

