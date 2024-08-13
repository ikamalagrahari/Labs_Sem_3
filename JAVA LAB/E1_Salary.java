import java.util.Scanner;

public class Salary {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        double basicSalary, netSalary, pf, da, hra;
        System.out.println("Enter your basic Salary: ");
        basicSalary = input.nextDouble();

        hra = basicSalary * 0.3;
        da = basicSalary * 0.7;
        pf = basicSalary * 0.10;
        netSalary = basicSalary + hra + da - pf;

        System.out.println("Your HRA is: " + hra);
        System.out.println("Your DA is: " + da);
        System.out.println("Your PF is: " + pf);
        System.out.println("Your Net Salary is: " + netSalary);
        input.close();
    }
}
