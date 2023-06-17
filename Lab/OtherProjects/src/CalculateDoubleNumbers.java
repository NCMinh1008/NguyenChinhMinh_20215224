import java.util.Scanner;
public class CalculateDoubleNumbers {
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input 1st double: ");
        double firstDou = in.nextDouble();
        System.out.print("Input 2nd double: ");
        double secondDou = in.nextDouble();

        System.out.printf("Sum of two integers: %f\n", firstDou + secondDou);
        System.out.printf("Difference of two integers: %f\n", firstDou - secondDou);
        System.out.printf("Product of two integers: %f\n", firstDou * secondDou);
        System.out.printf("Quotient of two integers: %.2f\n", firstDou / secondDou);
    }

}
