package Utils;

import ConsoleUI.MainMenu;
import Models.User;
import Services.AuthService;

import java.util.Scanner;

public class InputsUtil {

    private final  AuthService authService;
    public  InputsUtil(){
        this.authService = new AuthService();
    }
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

        User user = authService.register(fullname, email, phone, password);


        System.out.println("\n===== User Registered =====");
        System.out.println(user.toString());

        loginForm();

    }



    // Login form
    public void loginForm() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Login ======");

        System.out.println("Enter Your email : ");
        String email = scanner.nextLine();

        System.out.println("Enter Your password : ");
        String password = scanner.nextLine();

        // call auth service to pass the login cerdinalities

        User user = authService.login(email, password);

        MainMenu mainMenu = new MainMenu(user, authService);
        mainMenu.menu();

        System.out.println("\n===== Login successfully =====");
        System.out.println(user.toString());
    }
}
