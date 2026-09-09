package ConsoleUI;

import Utils.InputsUtil;

import java.util.Scanner;

public class RoomManagmentMenu {

    private final InputsUtil inputsUtil;
    public RoomManagmentMenu(){
        this.inputsUtil = new InputsUtil();
    }
    Scanner scanner = new Scanner(System.in);
    public void roomMenu(){

        int userChoice ;

        do{
        System.out.println("========== Rooms Management ===========");
        System.out.println("1- Add new room ");
        System.out.println("2- Delete room ");
        System.out.println("3- Show room ");
        System.out.println("0- Exit ");

        System.out.println("Enter your choice :  ");
         userChoice = scanner.nextInt();

        switch (userChoice){
            case 1: inputsUtil.addRoomForm();
                break;
            case 2: // delete room method
                break;
            case 3: // show  room
                break;
            case 0:
                break;
            default: System.out.println("Invalid choice");
        }

        }while (userChoice != 0);
    }
}
