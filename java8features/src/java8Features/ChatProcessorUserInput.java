package java8Features;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
public class ChatProcessorUserInput {
	public static void main(String[] args) {
        LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
        Scanner scanner = new Scanner(System.in);
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    if (messageQueue.size() > 5) {
                        System.out.println("Queue full (more than 2 messages). Please wait...");
                        Thread.sleep(1000); 
                        continue;
                    }

                    System.out.print("Enter message: ");
                    String msg = scanner.nextLine();
                    messageQueue.put(msg); 
                    System.out.println("Message added.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    String msg = messageQueue.take(); 
                    System.out.println("Read: " + msg);
                    Thread.sleep(2000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }


}
