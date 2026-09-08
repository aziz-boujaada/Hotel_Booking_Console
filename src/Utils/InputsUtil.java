package Utils;

import Models.User;
import Services.AuthService;

import java.util.Scanner;

public class InputsUtil {
    // Register form
    public void registerForm() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Register ======");

        System.out.println("Enter Your full name : ");
        String fullname = scanner.nextLine();

        System.out.println("Enter Your email : ");
        String email = scanner.nextLine();

        System.out.println("Enter Your phone : ");
        String phone = scanner.nextLine();

        System.out.println("Enter Your password : ");
        String password = scanner.nextLine();

        // call auth service to pass the register information
        AuthService auth = new AuthService();
        User user = auth.register(fullname, email, phone, password);


        System.out.println("\n===== User Registered =====");
        System.out.println(user.toString());

        loginForm();

    }


    // update form
//    public void updateUserForm() {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("======= Update Profile  ======");
//
//        System.out.println("Enter Your full name : ");
//        String fullname = scanner.nextLine();
//
//        System.out.println("Enter Your email : ");
//        String email = scanner.nextLine();
//
//        System.out.println("Enter Your phone : ");
//        String phone = scanner.nextLine();
//
//        System.out.println("Enter Your password : ");
//        String password = scanner.nextLine();

        // call auth service to pass the register information
//        AuthService auth = new AuthService();
//        User user = auth.register(fullname, email, phone, password);
//        auth.updateProfile(user);
//
//
//        System.out.println("\n===== User Registered =====");
//        System.out.println(user.toString());
//
//    }

    // Login form
    public void loginForm() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Login ======");

        System.out.println("Enter Your email : ");
        String email = scanner.nextLine();

        System.out.println("Enter Your password : ");
        String password = scanner.nextLine();

        // call auth service to pass the login cerdinalities
        AuthService auth = new AuthService();
        User user = auth.login(email, password);


        System.out.println("\n===== Login successfully =====");
        System.out.println(user.toString());
    }
}
