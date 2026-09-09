package ConsoleUI;

import java.util.Scanner;

public class RoomManagmentMenu {

    Scanner scanner = new Scanner(System.in);
    public void roomMenu(){
        System.out.println("========== Rooms Management ===========");
        System.out.println("1- Add new room ");
        System.out.println("2- Delete room ");
        System.out.println("3- Show room ");
        System.out.println("0- Exit ");

        System.out.println("Enter your choice :  ");
        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1: // add room form
                break;
            case 2: // delete room method
                break;
            case 3: // show  room
                break;
            case 0: // exit room management and go to main menu
                break;
            default: System.out.println("Invalid choice");
        }
    }
}
