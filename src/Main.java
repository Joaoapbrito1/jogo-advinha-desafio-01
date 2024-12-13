import java.util.Scanner;

public class Main {

    // Variáveis globais
    static Scanner scanner = new Scanner(System.in);
    static int limite;
    // static int numeroSorteado;

    public static void main(String[] args) {
        exibirMenu();
        if (limite == -1) {
            System.out.println("ERRO: ESSE NIVEL NÃO EXISTE - REINICIE O JOGO E ESCOLHA UM NIVEL EXISTENTE.");
        }
    }

    public static void exibirMenu() {
        System.out.println("=========================== JOGO DO ADVINHA ===============================");
        System.out.println("Niveis de dificudade do jogo:");
        System.out.println("1 - Nivel Fácil (Nesse nivel você tem que acertar um numero entre 1 e 10)");
        System.out.println("2 - Nivel Médio (Nesse nivel você tem que acertar um numero entre 1 e 50)");
        System.out.println("3 - Nivel Dificil (Nesse nivel você tem que acertar um numero entre 1 e 100)");
        System.out.println("Digite o número correspondente ao nivel desejado:");
        int nivel = scanner.nextInt();
        limite = definirLimite(nivel);
    }

    public static int definirLimite(int nivel) {
        if (nivel == 1) {
            return 10;
        } else if (nivel == 2) {
            return 50;
        } else if (nivel == 3) {
            return 100;
        }
        return -1; // Nível inválido
    }
}