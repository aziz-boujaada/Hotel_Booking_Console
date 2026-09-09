package Utils;

import ConsoleUI.MainMenu;
import Enums.RoomStatus;
import Enums.RoomType;
import Enums.UserRole;
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


        UserRole role ;
        System.out.println("---- choice Role ----");
        System.out.println("1- ADMIN");
        System.out.println("2- CLIENT");
        int choiceRole =  scanner.nextInt();


        switch (choiceRole){
            case 1: role = UserRole.ADMIN;
               break;
            case 2: role = UserRole.CLIENT;
               break;
            default:
                throw new IllegalArgumentException("invalid  role");
        }

        // call auth service to pass the register information

        User user = authService.register(fullname, email, phone, password,role);


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

    // Add New Room Form

    public void addRoomForm(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Add New Room ======");

        RoomType roomType;
        RoomStatus roomStatus;

        System.out.println("---- choice Room Type  ----");
        System.out.println("1- Single");
        System.out.println("2- Double");
        System.out.println("2- Suite");
        int choiceRoomType =  scanner.nextInt();


        switch (choiceRoomType){
            case 1: roomType = RoomType.SINGLE;
                break;
            case 2: roomType = RoomType.DOUBLE;
                break;
            case 3: roomType = RoomType.SUITE;
                break;
            default:
                throw new IllegalArgumentException("invalid  room type ");
        }
        System.out.println("Enter capacity of room : ");
        int capacity = scanner.nextInt();

        System.out.println("Enter Your phone : ");
        double nightPrice = scanner.nextInt();

        System.out.println("---- choice Room Status  ----");
        System.out.println("1- Available");
        System.out.println("2- In Repair");

        int choiceRoomStatus =  scanner.nextInt();


        switch (choiceRoomStatus){
            case 1: roomStatus = RoomStatus.AVAILABLE;
                break;
            case 2: roomStatus = RoomStatus.IN_REPAIR;
                break;
            default:
                throw new IllegalArgumentException("invalid  room status ");
        }




    }
}
