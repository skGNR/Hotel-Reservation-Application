package model;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/2 - 14:38
 */
public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + " Price: " + price + " Room Type: " + roomType;
    }
}
