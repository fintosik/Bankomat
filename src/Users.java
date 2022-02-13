import java.util.*;

public class Users {
    private static final List<User> userList = new LinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void addUser(User user) {
        userList.add(user);
    }

    public static User selectUser() {
        System.out.println("Выберите пользователя");
        System.out.println("Доступные:");
        showAllUsers();
        return userList.get(scanner.nextInt());
    }

    private static void showAllUsers() {
        System.out.print("[");
        for (User user: userList) {
            System.out.print(userList.indexOf(user) + " - " + user.getName() + "; ");
        }
        System.out.println("]");
    }

    public static boolean userExist(String userName) {
        boolean userExist = false;
        for (User user: userList) {
            if (userName.equals(user.getName())) {
                userExist = true;
                break;
            }
        }
        return userExist;
    }

    public static void addThreeUsers() {
        User user1 = new User("Павел", 1234, 1000);
        User user2 = new User("Татьяна", 4567, 2000);
        User user3 = new User("Василий", 7891, 3000);
        addUser(user1);
        addUser(user2);
        addUser(user3);
    }
}
