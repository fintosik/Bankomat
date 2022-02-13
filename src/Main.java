import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Users.addThreeUsers();
        BankMachine.updateCurrencyList();

        BankMachine.addUser();

        BankMachine.selectUser();
        BankMachine.authorization();
        BankMachine.setCurrency();
        BankMachine.work();
    }
}
