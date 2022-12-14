import java.util.HashMap;
import java.util.Scanner;

public class Main{
    private static final Scanner sc = new Scanner(System.in);
    private static Member member = new Member("example", "example", "example"); // Calling Member class

    public static void main(String[] args) {

        boolean exitRequested = false;
        while (!exitRequested) {
            System.out.println(  // Creating case structure
                    "Press: " + "\n" + "\r" +
                            "1.Register" + "\n" + "\r" +
                            "2.Log in" + "\n" + "\r" +
                            "3.Admin login " + "\n" + "\r" +
                            "4.Exit.");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    adminLogin();
                    break;

                case 4:
                    exitRequested = true;
                    break;
                    // Giving all the options to choose from in the menu


                default:
                    System.out.println("?");
                    return;
            }
        }

    }

    public static void register() { // Regestration menu, with all required input credentials
        System.out.println("Enter your First name?");
        String firstName = sc.next();
        System.out.println("Please enter username");
        String username = sc.next();
        System.out.println("Please enter password");
        String password = sc.next();
        Member newMember = new Member(username, password, firstName);
        member.register(newMember);
        System.out.println("\n You have now successfully regestered! \n");
        login();
        return;//call login after registering

    }

    public static void login() { // Login process with all required credentials

        System.out.println("\n Proceed to Log in. Please enter your Login credentials. \n");
        System.out.println("Username:");
        String username = sc.next();
        System.out.println("Password:");
        String password = sc.next();

        Member x = new Member(); //call the member class
        HashMap<String, String> loginMember = x.getMemberMap(); //access the hashmap

        find(loginMember, username, password);

        if (username.equals("default") && (password.equals("default"))) {
            System.out.println("Welcome user");
        } else {
            System.out.println("Invalid user credentials");
            return;
        }

        if (username.equals(username) && password.equals(password)) {
            System.exit(0);  // Ends the program after successfull Log In
        }

    }

    public static void adminLogin() {  // This is just for a preset "Athority" login
        System.out.println("Username:");
        String username = sc.next();
        System.out.println("Password:");
        String password = sc.next();

        if (username.equals("Admin") && (password.equals("Admin"))) {
            System.out.println("Welcome Admin");
        } else {
            System.out.println("Invalid Admin credentials");
            return;
        }

            if (username.equals(username) && password.equals(password)) {
                System.exit(0);  // Ends the program after successfull Log In
        }
    }

    //This goes to the hashmap of the user credentials after regestration, when proceeding to the log in
    public static void find(HashMap<String, String> loginMember, String username, String password) {
        for (String i : loginMember.keySet()) {
            if (i.equals(username) && loginMember.get(i).equals(password)) {
                System.out.println("Login successfull!");
                System.exit(0);
                break;
            }
        }
    }
}
