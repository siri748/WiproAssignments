package java8Features;
import java.util.LinkedList;
import java.util.Scanner;
public class RecentAppMemory {
    public static void main(String[] args) {
        LinkedList<String> recentApps = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Open app " + (i + 1) + ": ");
            String app = scanner.nextLine();
            if (recentApps.contains(app)) {
                recentApps.remove(app);
            }
            recentApps.addFirst(app);
        }
        System.out.println("\nrecent apps list:");
        for (String app : recentApps) {
            System.out.println(app);
        }
        scanner.close();
    }
}
