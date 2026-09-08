package ConsoleUI;

public class MainMenu {


    public Object menu;

    public static void menu() {
            System.out.println("Room Reservation System");
            System.out.println("=======================");

            searchAvailableRooms();
            viewAllRooms();
            createReservation();
            myReservations();
            reservationDetails();
            updateReservation();
            cancelReservation();
            updateProfile();
            changePassword();
            logout();
        }

        // 1. Search available rooms
        public static void searchAvailableRooms() {
            System.out.println("1. Search available rooms");
        }

        // 2. View all rooms
        public static void viewAllRooms() {
            System.out.println("2. View all rooms");
        }

        // 3. Create reservation
        public static void createReservation() {
            System.out.println("3. Create reservation");
        }

        // 4. My reservations
        public static void myReservations() {
            System.out.println("4. My reservations");
        }

        // 5. Reservation details
        public static void reservationDetails() {
            System.out.println("5. Reservation details");
        }

        // 6. Update reservation
        public static void updateReservation() {
            System.out.println("6. Update reservation");
        }

        // 7. Cancel reservation
        public static void cancelReservation() {
            System.out.println("7. Cancel reservation");
        }

        // 8. Update profile
        public static void updateProfile() {
            System.out.println("8. Update profile");
        }

        // 9. Change password
        public static void changePassword() {
            System.out.println("9. Change password");
        }

        // 10. Logout
        public static void logout() {
            System.out.println("10. Logout");
        }
    
}
