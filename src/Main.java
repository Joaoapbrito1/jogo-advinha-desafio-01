import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu de Niveis
        System.out.println("=========================== JOGO DO ADVINHA ===============================");
        System.out.println("Niveis de dificudade do jogo:");
        System.out.println("1 - Nivel Fácil (Nesse nivel você tem que acertar um numero entre 1 e 10)");
        System.out.println("2 - Nivel Médio (Nesse nivel você tem que acertar um numero entre 1 e 50)");
        System.out.println("3 - Nivel Dificil (Nesse nivel você tem que acertar um numero entre 1 e 100)");
        System.out.println("Digite o número correspondente ao nivel desejado:");
        int nivel = scanner.nextInt();
    }
    }