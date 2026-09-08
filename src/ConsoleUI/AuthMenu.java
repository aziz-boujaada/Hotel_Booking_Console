package ConsoleUI;

import Utils.InputsUtil;

import java.util.Scanner;

public class AuthMenu {

    public  void showMenu(){
        System.out.println("========================== Auth Menu =========================");

        System.out.println("1- Login");
        System.out.println("2- Register");


        System.out.println("Enter Your Choice : ");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();


        // get Inputs Util
        InputsUtil inputs = new InputsUtil();


        switch (userChoice){
            case 1: inputs.loginForm();
                break;
            case 2: inputs.registerForm();
                break;
            default:System.out.println("Invalid Choice");
        }


    }
}
