package model;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/2 - 11:53
 */
public class Room implements IRoom{
    protected String roomNumber;
    protected Double price;
    protected RoomType roomType;
    protected boolean isFree;

    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;

    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString() {
        return  "Room Number: " + roomNumber + " Price: " + price + " Room Type: " + roomType;
    }
}
