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

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputsUtil {

    private final AuthService authService;
    private final RoomService roomService;
    private final ReservationService reservationService;
    private final Scanner scanner;

    public InputsUtil(AuthService authService) {
        this.authService = authService;
        this.roomService = new RoomService();
        this.reservationService = new ReservationService(authService);
        this.scanner = new Scanner(System.in);
    }

    private String readRequiredLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            if (value != null && !value.trim().isEmpty()) {
                return value.trim();
            }
            System.out.println("This field is required.");
        }
    }

    private int readIntWithRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            try {
                int choice = Integer.parseInt(value.trim());
                if (choice < min || choice > max) {
                    throw new IllegalArgumentException("Choice must be between " + min + " and " + max + ".");
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            try {
                return Double.parseDouble(value.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();
            try {
                int parsed = Integer.parseInt(value.trim());
                if (parsed <= 0) {
                    throw new IllegalArgumentException("Value must be greater than zero.");
                }
                return parsed;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void registerForm() {
        while (true) {
            try {
                System.out.println("======= Register ======");

                String fullname = readRequiredLine("Enter Your full name: ");
                String email = readRequiredLine("Enter Your email: ");
                String phone = readRequiredLine("Enter Your phone: ");
                String password = readRequiredLine("Enter Your password: ");

                UserRole role;
                System.out.println("---- choice Role ----");
                System.out.println("1- ADMIN");
                System.out.println("2- CLIENT");
                int choiceRole = readIntWithRange("Select role: ", 1, 2);

                switch (choiceRole) {
                    case 1 -> role = UserRole.ADMIN;
                    case 2 -> role = UserRole.CLIENT;
                    default -> throw new IllegalArgumentException("invalid role");
                }

                User user = authService.register(fullname, email, phone, password, role);
                System.out.println("\n===== User Registered =====");
                System.out.println(user.toString());
                loginForm();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    public void loginForm() {
        while (true) {
            try {
                System.out.println("======= Login ======");

                String email = readRequiredLine("Enter Your email: ");
                String password = readRequiredLine("Enter Your password: ");

                User user = authService.login(email, password);
                System.out.println("\n===== Login successfully =====");
                System.out.println(user.toString());

                MainMenu mainMenu = new MainMenu(user, authService);
                mainMenu.menu();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Login failed: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    public void changePasswordForm(User loggedUser) {
        while (true) {
            try {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                authService.changePassword(loggedUser, newPassword);
                System.out.println("Password updated successfully!");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Password update failed: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    public void updateProfileForm(User loggedUser) {
        while (true) {
            try {
                System.out.println("======= Update Profile ======");
                String fullName = readRequiredLine("Enter your full name: ");
                String email = readRequiredLine("Enter your email: ");
                String phone = readRequiredLine("Enter your phone: ");

                User updatedUser = authService.updateProfile(loggedUser, fullName, email, phone);
                System.out.println("Profile updated successfully");
                System.out.println(updatedUser);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Profile update failed: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    public void addRoomForm() {
        while (true) {
            try {
                System.out.println("======= Add New Room ======");

                RoomType roomType;
                RoomStatus roomStatus;

                System.out.println("---- choice Room Type  ----");
                System.out.println("1- Single");
                System.out.println("2- Double");
                System.out.println("3- Suite");
                int choiceRoomType = readIntWithRange("Select room type: ", 1, 3);

                switch (choiceRoomType) {
                    case 1 -> roomType = RoomType.SINGLE;
                    case 2 -> roomType = RoomType.DOUBLE;
                    case 3 -> roomType = RoomType.SUITE;
                    default -> throw new IllegalArgumentException("invalid room type");
                }

                int capacity = readPositiveInt("Enter capacity of room: ");
                double nightPrice = readDouble("Enter night price: ");

                System.out.println("---- choice Room Status  ----");
                System.out.println("1- Available");
                System.out.println("2- In Repair");
                int choiceRoomStatus = readIntWithRange("Select room status: ", 1, 2);

                switch (choiceRoomStatus) {
                    case 1 -> roomStatus = RoomStatus.AVAILABLE;
                    case 2 -> roomStatus = RoomStatus.IN_REPAIR;
                    default -> throw new IllegalArgumentException("invalid room status");
                }

                Room room = roomService.addRoom(roomType, nightPrice, capacity, roomStatus);
                System.out.println("Room created Successfully");
                System.out.println(room.toString());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Room creation failed: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    public void addReservationForm() {
        while (true) {
            try {
                System.out.println("====== Add New Reservation =====");

                String roomID = readRequiredLine("Enter Room ID: ");
                String checkIn = readRequiredLine("Enter Check-In Date: ");
                String checkOut = readRequiredLine("Enter Check-Out Date: ");
                int personsNumber = readPositiveInt("Enter number of persons: ");

                Reservation reservation = reservationService.addNewReservation(roomID, checkIn, checkOut, personsNumber);
                System.out.println("Reservation created Successfully");
                System.out.println(reservation.toString());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Reservation failed: " + e.getMessage());
                System.out.println("Please try again.\n");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }
}
