package java8Features;
import java.util.concurrent.LinkedBlockingQueue;
class Task {
    int id;
    String name;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Task{id=" + id + ", name='" + name + "'}";
    }
}

public class StageBasedTaskRunner {
    public static void main(String[] args) {
        LinkedBlockingQueue<Task> stage1Queue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Task> stage2Queue = new LinkedBlockingQueue<>();

        // Producer Thread: Add tasks to Stage 1
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Task task = new Task(i, "Task" + i);
                try {
                    stage1Queue.put(task);
                    System.out.println("Added to Stage 1: " + task);
                    Thread.sleep(500); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread stageProcessor = new Thread(() -> {
            while (true) {
                try {
                    Task task = stage1Queue.take();
                    System.out.println("Processing: " + task);
                    if (task.id % 2 == 0) {
                        stage2Queue.put(task);
                        System.out.println("Moved to Stage 2: " + task);
                    } else {
                        System.out.println("Skipped for Stage 2 (odd ID): " + task);
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Task task = stage2Queue.take();
                    System.out.println("Final Stage Task: " + task);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        producer.start();
        stageProcessor.start();
        consumer.start();
    }
}
