import api.AdminResource;
import api.HotelResource;
import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/6 - 14:25
 */
public class AdminMenu {

    public static void displayOptions() {
        System.out.println("Admin Menu");
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("1. See all customers");
        System.out.println("2. See all rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a room");
        System.out.println("5. Back to main menu");
        System.out.println("==========================================================");
        System.out.println("Please select a number for the menu option");
    }

    public static boolean executeOption(Scanner scanner, Integer selection) {
        boolean keepAdminRunning = true;
        switch (selection) {
            case 1:
                getAllCustomers();
                break;
            case 2:
                getAllRooms();
                break;
            case 3:
                displayAllReservations();
                break;
            case 4:
                addRooms(scanner);
                break;
            case 5:
                keepAdminRunning = false;
                break;
            default:
                System.out.println("Please enter a number between 1 and 6\n");
        }
        return keepAdminRunning;
    }
    public static void getAllCustomers() {
        Collection<Customer> allCustomers = AdminResource.getAllCustomers();
        if (allCustomers.isEmpty()) {
            System.out.println("There are no customers");
        } else {
            for (Customer customer : allCustomers) {
                System.out.println(customer.toString());
            }
        }
        System.out.println();
    }
    public static void addRooms(Scanner scanner) {
        boolean keepAddingRooms;
        do {
            addRoom(scanner);
            System.out.println("Would you like to add another room? Enter y/yes, or any other character for no: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                keepAddingRooms = true;
            } else {
                keepAddingRooms = false;
            }
        } while (keepAddingRooms);
    }

    public static void addRoom(Scanner scanner) {
        // get room number input
        String roomNumber = null;
        boolean validRoomNumber = false;
        while (!validRoomNumber) {
            System.out.println("Enter room number: ");
            roomNumber = scanner.nextLine();
            IRoom roomExists = HotelResource.getRoom(roomNumber);
            if (roomExists == null) {
                validRoomNumber = true;
            } else {
                System.out.println("That room already exists. Enter y/yes to update it, or any other character to enter another room number: ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                    validRoomNumber = true;
                }
            }
        }
        double price = 0.00;
        boolean validPrice = false;
        while (!validPrice) {
            try {
                System.out.println("Enter price per night: ");
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    System.out.println("The price must be greater or equal than 0.00");
                } else {
                    validPrice = true;
                }
            } catch (Exception ex) {
                System.out.println("Please enter a valid price");
            }
        }
        RoomType roomType = null;
        boolean validRoomType = false;
        while (!validRoomType) {
            try {
                System.out.println("Enter room type (single, double): ");
                String roomTypeString = scanner.nextLine();
                if (roomTypeString.equals("single") || roomTypeString.equals("double")) {
                    if (roomTypeString.equals("double")) {
                        roomType = RoomType.DOUBLE;
                    }
                    if (roomTypeString.equals("single")) {
                        roomType = RoomType.SINGLE;
                    }
                }
                if (roomTypeString == null) {
                    System.out.println("Please enter a valid room type");
                } else {
                    validRoomType = true;
                }
            } catch (Exception ex) {
                System.out.println("Please enter a valid room type");
            }
        }
        IRoom newRoom = new Room(roomNumber, price, roomType);
        List<IRoom> roomToAdd = new ArrayList<>();
        roomToAdd.add(newRoom);
        AdminResource.addRoom(roomToAdd);
    }
    public static void getAllRooms() {
        Collection<IRoom> allRooms = AdminResource.getAllRooms();
        if (allRooms.isEmpty()) {
            System.out.println("There are no rooms");
        } else {
            for (IRoom room : allRooms) {
                System.out.println(room.toString());
            }
        }
    }
    public static void displayAllReservations() {
        Collection<Reservation> allReservations = AdminResource.displayAllReservations();
        if (allReservations.isEmpty()) {
            System.out.println("There are no reservations");
        } else {
            for (Reservation reservation : allReservations) {
                System.out.println(reservation.toString());
            }
        }
        System.out.println();
    }
}
