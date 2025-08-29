package java8Features;
import java.util.ArrayDeque;
import java.util.Scanner;
public class GroceryLineShuffle {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of customers: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            if (name.length() % 2 == 0) {
                queue.addFirst(name); 
            } else {
                queue.addLast(name); 
            }
        }
        System.out.println("\nServing order:");
        for (String customer : queue) {
            System.out.println(customer);
        }
        scanner.close();
    }
}
