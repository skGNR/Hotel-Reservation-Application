package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/3 - 14:09
 */
public class HotelResource {

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void createCustomer(String email, String firstName, String lastName) throws IllegalAccessException {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomId) {
        return ReservationService.getRoom(roomId);
    }

    public static Reservation bookRoom(String email, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CustomerService.getCustomer(email);
        return ReservationService.reserveRoom(customer, room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomerReservations(String email) {
        Customer customer = CustomerService.getCustomer(email);
        return ReservationService.getCustomerReservations(customer);
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return ReservationService.findRooms(checkInDate, checkOutDate);
    }
}
