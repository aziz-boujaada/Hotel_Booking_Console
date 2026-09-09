package ConsoleUI;

import Models.User;
import Services.AuthService;

import java.util.Scanner;

public class MainMenu {


    private final AuthService authService;

    private  final User loggedUser ;

     public MainMenu(User loggedUser){
         this(loggedUser, new AuthService());
     }

     public MainMenu(User loggedUser, AuthService authService){
         this.authService = authService;
         this.loggedUser = loggedUser;
     }
     
    public  void menu() {

        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println();
            System.out.println("===== Room Reservation System =====");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. View All Rooms");
            System.out.println("3. Create Reservation");
            System.out.println("4. My Reservations");
            System.out.println("5. Reservation Details");
            System.out.println("6. Update Reservation");
            System.out.println("7. Cancel Reservation");
            System.out.println("8. Update Profile");
            System.out.println("9. Change Password");
            System.out.println("10. Logout");
            System.out.println("===================================");
            System.out.print("Enter Your Choice : ");

            userChoice = scanner.nextInt();

            switch (userChoice) {

                case 1:
                    System.out.println("Search Available Rooms coming soon");
                    break;

                case 2:
                    System.out.println("view Rooms coming soon");
                    break;

                case 3:
                    System.out.println("create reservation  coming soon");
                    break;

                case 4:
                    System.out.println("my reservations coming soon");
                    break;

                case 5:
                    System.out.println("reservationDetails coming soon");
                    break;

                case 6:
                    System.out.println("updateReservation coming soon");
                    break;

                case 7:
                    System.out.println("cancelReservation coming soon");
                    break;

                case 8:
                    scanner.nextLine();

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
                    break;

                case 9:

                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();

                    authService.changePassword(loggedUser, newPassword);

                    System.out.println("Password updated successfully!");
                    break;

                case 10:
                    authService.logout(loggedUser);
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose between 1 and 10.");
            }

        } while (userChoice != 10);

        scanner.close();
    }
    
}
