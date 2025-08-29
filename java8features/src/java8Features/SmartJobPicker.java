package java8Features;
import java.util.PriorityQueue;
import java.util.Scanner;
class Job {
    String name;
    int urgency;
    public Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }
    @Override
    public String toString() {
        return name + " (Urgency: " + urgency + ")";
    }
}

public class SmartJobPicker {
    public static void main(String[] args) {
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(
            (job1, job2) -> {
                if (job1.urgency != job2.urgency) {
                    return job1.urgency - job2.urgency; 
                } else {
                    return job1.name.length() - job2.name.length(); 
                }
            }
        );
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter job name: ");
            String name = scanner.nextLine();

            System.out.print("Enter urgency (1 to 5): ");
            int urgency = scanner.nextInt();
            scanner.nextLine(); 

            jobQueue.add(new Job(name, urgency));
        }

        System.out.println("\nJobs picked in order of urgency:");
        while (!jobQueue.isEmpty()) {
            System.out.println(jobQueue.poll());
        }

        scanner.close();
    }
}
