package model;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/2 - 11:52
 */
public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();
}
