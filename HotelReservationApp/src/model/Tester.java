package model;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/2 - 15:38
 */
public class Tester {
    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer("first", "second", "j@domain.com");
        System.out.println(customer);
    }
}
