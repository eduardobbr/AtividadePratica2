import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, insira um número inteiro: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. Por favor, insira um número: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
