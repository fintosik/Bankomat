import java.util.*;

public class BankMachine {
    private static User currentUser;
    static Map<Integer, String> currencyMap = new HashMap<>();
    private static String currency;
    private static final Scanner scanner = new Scanner(System.in);
    private static int sum;


    public static void selectUser() {
        currentUser = Users.selectUser();
    }

    public static void authorization() {
        int authorizationTries = 3;

        while (authorizationTries > 0) {
            System.out.println("Введите пин код:");
            int inputPinCode = scanner.nextInt();

            if (inputPinCode != currentUser.getPinCode()) {
                authorizationTries--;
                System.out.println("Введен неверный пин код");
                System.out.println("Осталось попыток: " + authorizationTries);
            } else break;
            if (authorizationTries == 0) System.exit(-1);
        }
    }

    public static void setCurrency() {
        System.out.println("Выберите валюту");
        showCurrencyList();
        currency = currencyMap.get(scanner.nextInt());
    }

    private static void showCurrencyList() {
        System.out.println(currencyMap);
    }

    public static void work() {
        int operationNumber = 0;
        while (operationNumber < 4) {
            System.out.println("");
            System.out.println("Выберите операцию: 1 - пополнить баланс, 2 - снять со счета, 3 - посмотреть счет");
            operationNumber = scanner.nextInt();
            switch (operationNumber) {
                case 1:
                    setSum();
                    deposit(sum);
                    showBalance();
                    break;
                case 2:
                    setSum();
                    withdraw(sum);
                    showBalance();
                    break;
                case 3:
                    showBalance();
                    break;
                default:
                    break;
            }
        }
    }

    private static void setSum() {
        System.out.println("Введите сумму:");
        sum = scanner.nextInt();
    }

    private static void deposit(int sum) {
        int newBalance = currentUser.getBalance() + sum;
        currentUser.setBalance(newBalance);
    }

    private static void withdraw(int sum) {
        int newBalance = currentUser.getBalance() - sum;
        if (newBalance >= 0) {
            currentUser.setBalance(newBalance);
        } else {
            System.out.println("Невозможно снять указанную сумму");
        }
    }

    private static void showBalance() {
        System.out.println("Ваш баланс: " + currentUser.getBalance() + " " + currency);
    }

    public static void updateCurrencyList() {
        currencyMap.put(1, "USD");
        currencyMap.put(2, "BYN");
    }

    public static void addUser() {
        User newUser = new User();
        System.out.println("Введите имя:");
        newUser.setName(scanner.next());
        if (Users.userExist(newUser.getName())) {
            System.out.println("Такой пользователь уже существует");
            addUser();
        } else {
            System.out.println("Введите пин код:");
            newUser.setPinCode(scanner.nextInt());
            System.out.println("Введите баланс:");
            newUser.setBalance(scanner.nextInt());
            Users.addUser(newUser);
        }

    }
}
