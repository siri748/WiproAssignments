package java8Features;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Patient {
    String name;
    int severity;
    long timestamp; // for tracking order

    public Patient(String name, int severity, long timestamp) {
        this.name = name;
        this.severity = severity;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + "}";
    }
}

public class EmergencyPatientTracker {
    public static void main(String[] args) {
        // Custom comparator: lower severity first, then older timestamp
        Comparator<Patient> patientComparator = (p1, p2) -> {
            if (p1.severity != p2.severity)
                return Integer.compare(p1.severity, p2.severity);
            return Long.compare(p1.timestamp, p2.timestamp);
        };

        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(patientComparator);
        Scanner sc = new Scanner(System.in);

        int count = 0;
        long currentTime = System.currentTimeMillis();

        while (true) {
            System.out.print("Enter patient name (or type 'treat' to treat a patient): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("treat")) {
                if (!patientQueue.isEmpty()) {
                    Patient treated = patientQueue.poll();
                    System.out.println("Treating patient: " + treated);
                } else {
                    System.out.println("No patients in queue.");
                }
            } else {
                if (patientQueue.size() < 5) {
                    System.out.print("Enter severity (1 = highest priority): ");
                    int severity = Integer.parseInt(sc.nextLine());

                    Patient newPatient = new Patient(input, severity, currentTime++);
                    patientQueue.add(newPatient);
                    System.out.println("Added: " + newPatient);
                } else {
                    System.out.println("Queue is full! Cannot add more patients now.");
                }
            }

            System.out.println("Current Queue: " + patientQueue + "\n");
        }
    }
}
