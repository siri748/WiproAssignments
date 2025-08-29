package java8Features;
import java.util.ArrayDeque;
import java.util.Scanner;
public class LastThreeSearches {
    public static void main(String[] args) {
        ArrayDeque<String> searche = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) { 
            System.out.print("Enter search : ");
            String search = scanner.nextLine();
            if (searche.size() == 3) {
                searche.removeFirst();
            }
            searche.addLast(search);
        }
        System.out.println("\nLast Three Searches:");
        for (String s : searche) {
            System.out.println(s);
        }
        scanner.close();
    }
}
