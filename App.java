
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static List<User> users = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int idCounter = 0;

    public static void main(String[] args) {
        int decision = 0;
        while (decision !=5) {{
                try {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("Type 1 to create a user \nType 2 to view information "
                            + "\nType 3 to update information \nType 4 to delete user \nType 5 exit program" +"\n-----------------------------------------"+"\n");
                    decision = input.nextInt();

                    switch (decision) {
                        case 1:
                            createUser();
                            break;
                        case 2:
                            viewInformation();
                            break;
                        case 3:
                            updateInformation();
                            break;
                        case 4:
                            deleteUser();
                            break;
                        }
                } catch (Exception e) {
                    System.out.println("Value Invalid");
                    input.nextLine();
                }
            }
        }
    }

    public static void createUser() {
        try {
            //String email = "gmail.com ".formatted()
            User userObject = new User();
            input.nextLine();
            System.out.println("What name you want to add?");
            userObject.setName(input.nextLine());
            if (userObject.getName().equals("")) {
                System.out.println("VALUE INVALID");
                return;
            }
            System.out.println("What your age?");
            userObject.setAge(input.nextInt());
            input.nextLine();
            if (userObject.getAge() < 0) {
                System.out.println("VALUE INVALID");
                return;
            }
            System.out.println("What email you want to add?");
            userObject.setEmail(input.nextLine());
            System.out.println("What phone number you want to add?");
            userObject.setPhoneNumber(input.nextLine());
            idCounter++;
            userObject.setId(idCounter);
            users.add(userObject);
            System.out.println("\n-----------------------------------------");
        } catch (Exception e) {
            System.out.println("Value Invalid");
            System.out.println("\n-----------------------------------------");
            input.nextLine();
        }
    }

    public static void viewInformation() {
        for (User userObject : users) {
            System.out.println("Id: " + userObject.getId() + "\nName: " + userObject.getName() + "\nAge: "
                    + userObject.getAge() + "\nEmail: "
                    + userObject.getEmail() + "\nPhone: " + userObject.getPhoneNumber() + "\n-----------------------------------------");
        }
    }

    public static void updateInformation() {
        try {
            String update = "";
            System.out.println("Type the id you want to acess:");
            int id = input.nextInt();
            input.nextLine();
            boolean found = false;

            for (User userObject : users) {
                if (userObject.getId() == id) {
                    System.out.println("Name: " + userObject.getName() + "\nAge: " + userObject.getAge() + "\nEmail: "
                            + userObject.getEmail() + "\nPhone: " + userObject.getPhoneNumber());
                    System.out.println("What information you want update?");
                    update = input.nextLine().trim().toLowerCase();

                    switch (update) {
                        case "name":
                            System.out.println("What name you want to add?");
                            userObject.setName(input.nextLine());
                            break;
                        case "age":
                            System.out.println("What your age?");
                            userObject.setAge(input.nextInt());
                            input.nextLine();
                            break;
                        case "email":
                            System.out.println("What email you want to add?");
                            userObject.setEmail(input.nextLine());
                            break;
                        case "phone":
                            System.out.println("What phone number you want to add?");
                            userObject.setPhoneNumber(input.nextLine());
                            break;
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println("Invalid value");
            input.nextLine();
        }
    }

    public static void deleteUser() {
        try {
            System.out.println("Type the id you want to acess:");
            int id = input.nextInt();
            input.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == id) {
                    users.remove(i);
                    System.out.println("User delete successfuly");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Value Invalid");
            input.nextLine();
        }
    }
}
