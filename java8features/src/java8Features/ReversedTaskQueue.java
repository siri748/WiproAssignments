package java8Features;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class ReversedTaskQueue {
    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            String task = scanner.nextLine();
            if (task.endsWith("!")) {
                tasks.addFirst(task);
            } else {
                tasks.addLast(task);
            }
        }
        ListIterator<String> iterator = tasks.listIterator(tasks.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        scanner.close();
    }
}
