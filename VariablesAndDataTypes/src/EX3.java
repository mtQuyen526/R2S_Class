package VariablesandDataTypes.src;
import java.text.DecimalFormat;

public class EX3 {
    /*
    * Viết chương trình để tính toán mức lương ròng của một nhân viên dựa trên các ràng buộc sau:
    * Basic salary : $ 12000
    DA : 12% of Basic salary
    HRA : $150
    TA : $120
    Others : $450
    * Tax cuts – a) PF :14% of Basic salary and b) IT: 15% of Basic salary
    Net Salary = Basic Salary + DA + HRA + TA + Others – (PF + IT)
    * */
    public static void main(String[] args) {


        System.out.println("Luong Nhan Vien: ");
        double basicSalary = 12000;
        double DA = 0.12 * basicSalary;
        double HRA = 150;
        double TA = 120;
        double othersSalary = 450;
        double PF = 0.14 * basicSalary;
        double IT = 0.15 * basicSalary;
        //c1
        // Decimalformart
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("BasicSalary: " + df.format(basicSalary) +
                "\nDA: " + df.format(DA) +
                "\nHRA:" + df.format(HRA) +
                "\nTA:" + df.format(TA) +
                "\nOthersSalary: " + df.format(othersSalary) +
                "\nPF:" + df.format(PF) +
                "\nIT:" + df.format(IT));
        System.out.println("------------------");
        //c2
        System.out.printf("BasicSalary: %.2f%n" +
                        "DA: %.2f%n" +
                        "HRA: %.2f%n" +
                        "TA: %.2f%n" +
                        "OthersSalary: %.2f%n" +
                        "PF: %.2f%n" +
                        "IT: %.2f%n",
                basicSalary, DA, HRA, TA, othersSalary, PF, IT);
        double netSalary = basicSalary + DA + HRA + TA + othersSalary - (PF + IT);
        //c1
        System.out.println("Net Salary = Basic Salary + DA + HRA + TA + Others – (PF + IT) = " + df.format(netSalary));
        //c2
        System.out.printf("Net Salary = Basic Salary + DA + HRA + TA + Others – (PF + IT) = %.2f%n", netSalary);

    }
}
