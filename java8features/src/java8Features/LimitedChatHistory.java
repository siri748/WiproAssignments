package java8Features;
import java.util.ArrayDeque;
import java.util.Scanner;
public class LimitedChatHistory {
    public static void main(String[] args) {
        ArrayDeque<String> chatHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many messages will you send? ");
        int total = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 1; i <= total; i++) {
            System.out.print("Enter message " + i + ": ");
            String msg = scanner.nextLine();
            if (chatHistory.size() == 4) {
                chatHistory.removeFirst();
            }
            chatHistory.addLast(msg);
            System.out.println("Current chat view: " + chatHistory);
        }
        System.out.println("\nFinal chat history:");
        for (String m : chatHistory) {
            System.out.println(m);
        }
        scanner.close();
    }
}
