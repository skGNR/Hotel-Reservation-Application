import java.util.Scanner;

/**
 * @autor LXYcodingshifu
 * @date 2021/8/9 - 8:48
 */
public class RunningApplication {


        public static void main(String[] args) {
            boolean keepRunning = true;
            try (Scanner scanner = new Scanner(System.in)) {
                while (keepRunning) {
                    try {
                        MainMenu.displayOptions();
                        int selection = Integer.parseInt(scanner.nextLine());
                        keepRunning = MainMenu.executeCode(scanner, selection);
                    } catch (Exception ex) {
                        System.out.println("Please en4ter a number between 1 and 5\n");
                    }
                }
            } catch (Exception ex) {
                System.out.println("\nError - Exiting program...\n");
            }
        }
}
