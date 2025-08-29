package java8Features;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
public class PrintManager {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> printQueue = new ArrayBlockingQueue<>(3);
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter print job " + i + ": ");
            String job = scanner.nextLine();
            if (printQueue.offer(job)) {
                System.out.println("Job added: " + job);
            } else {
                System.out.println("Queue full. Job skipped: " + job);
            }
        }
        System.out.println("\nPrinting jobs:");
        while (!printQueue.isEmpty()) {
            String jobToPrint = printQueue.poll();
            System.out.println("Printing: " + jobToPrint);
        }

        scanner.close();
    }
}

