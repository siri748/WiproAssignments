package java8Features;
import java.util.Scanner;
public class AverageConfusion {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (num[i] < 10) {
                num[i] = num[i] * 2;
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += num[i];
        }
        double average = sum / 5.0;
        System.out.println("Average: " + average);
    }
}



