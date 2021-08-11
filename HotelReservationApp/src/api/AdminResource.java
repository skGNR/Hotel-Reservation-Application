package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/5 - 15:39
 */
public class AdminResource {

    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(List<IRoom> rooms){
        for (IRoom room : rooms) {
            ReservationService.addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms(){
        return ReservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }
    public static Collection<Reservation> displayAllReservations(){
        return ReservationService.printAllReservations();
    }
}
