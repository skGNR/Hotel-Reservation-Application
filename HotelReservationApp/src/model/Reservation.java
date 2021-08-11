package model;

import java.util.Date;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/2 - 15:27
 */
public class Reservation {

    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Customer: " + customer + " Room Type: " + room + " Check in: "
                + checkInDate + " Check out: " + checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public boolean isRoomReserved(Date checkInDate, Date checkOutDate) {
        if (checkInDate.before(this.checkOutDate) && checkOutDate.after(this.checkInDate)) {
            return true;
        }
        return false;
    }
}
