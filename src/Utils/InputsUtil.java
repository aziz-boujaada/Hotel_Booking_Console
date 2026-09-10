package Utils;

import ConsoleUI.MainMenu;
import Enums.RoomStatus;
import Enums.RoomType;
import Enums.UserRole;
import Models.Reservation;
import Models.Room;
import Models.User;
import Services.AuthService;
import Services.ReservationService;
import Services.RoomService;

import java.util.Scanner;

public class InputsUtil {

    private final  AuthService authService;
    private final RoomService roomService;
    private final ReservationService reservationService;

    Scanner scanner = new Scanner(System.in);

    public InputsUtil(){
        this.authService = new AuthService();
        this.roomService = new RoomService();
        this.reservationService = new ReservationService();
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
        System.out.println("\n===== Login successfully =====");
        System.out.println(user.toString());

        MainMenu mainMenu = new MainMenu(user, authService);
        mainMenu.menu();

    }

    // change password menu
    public void changePasswordForm(User loggedUser){
        System.out.print("Enter new password: ");
        String newPassword = scanner.next();

        authService.changePassword(loggedUser, newPassword);

        System.out.println("Password updated successfully!");
    }

    public void updateProfileForm(User loggedUser){


        System.out.println("======= Update Profile ======");
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone: ");
        String phone = scanner.nextLine();

        User updatedUser = authService.updateProfile(loggedUser, fullName, email, phone);
        System.out.println("Profile updated successfully");
        System.out.println(updatedUser);
    }
    // Add New Room Form

    public void addRoomForm(){



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

        System.out.println("Enter night price : ");
        double nightPrice = scanner.nextDouble();

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

      // call the room service to pass room infos
        Room room = roomService.addRoom(roomType , nightPrice , capacity , roomStatus );
        System.out.println("Room created Successfully");
        System.out.println(room.toString());

    }

    // add New Reservation form

    public void addReservationForm(){
        System.out.println("====== Add New Reservation =====");

        System.out.println("Enter Room ID :");
        String roomID  = scanner.nextLine();

        System.out.println("Enter Check-In Date :");
        String checkIn  = scanner.nextLine();

        System.out.println("Enter Check-Out Date :");
        String checkOut  = scanner.nextLine();

        System.out.println("Enter number of nights :");
        int nights  = scanner.nextInt();

        Reservation reservation = reservationService.addNewReservation(roomID , checkIn , checkOut , nights);

    }
}
