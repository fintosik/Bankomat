public class User{
    private String name;
    private int pinCode;
    private int balance;

    public User() {
    }

    public User(String name, int pinCode, int balance) {
        this.name = name;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pinCode=" + pinCode +
                ", balance=" + balance +
                '}';
    }
}
