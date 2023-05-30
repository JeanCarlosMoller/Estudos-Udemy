import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N < 0) {
            System.out.println("É NEGATIVO");
        }
        else {
            System.out.println("NÃO É NEGATIVO");
        }

        sc.close();
    }
}
