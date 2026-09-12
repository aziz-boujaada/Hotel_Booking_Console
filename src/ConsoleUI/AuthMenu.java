package ConsoleUI;

import Services.AuthService;
import Utils.InputsUtil;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AuthMenu {

    private final AuthService authService;

    public AuthMenu(AuthService authService) {
        this.authService = authService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        InputsUtil inputs = new InputsUtil(authService);

        while (true) {
            try {
                System.out.println("========================== Auth Menu =========================");
                System.out.println("1- Login");
                System.out.println("2- Register");
                System.out.print("Enter Your Choice : ");

                int userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1:
                        inputs.loginForm();
                        break;
                    case 2:
                        inputs.registerForm();
                        break;
                    default:
                        System.out.println("Invalid Choice. Please choose 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Input is unavailable. Please restart the application.");
                return;
            }
        }
    }
}
