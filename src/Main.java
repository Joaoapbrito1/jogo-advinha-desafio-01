import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Variáveis globais
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static ArrayList<Integer> acertos = new ArrayList<>();
    static ArrayList<Integer> acertosProximos = new ArrayList<>();
    static ArrayList<Integer> erros = new ArrayList<>();
    static int pontuacao = 0;
    static int limite;
    static int numeroSorteado;

    public static void main(String[] args) {
        exibirMenu();
        if (limite == -1) {
            System.out.println("ERRO ESSE NIVEL NÃO EXISTE - REINICIE O JOGO E ESCOLHA UM NIVEL EXISTENTE.");
            return;
        }

        sortearNumero();
        iniciarJogo();
    }

    public static void exibirMenu() {
        System.out.println("=========================== JOGO DO ADVINHA ===============================");
        System.out.println("Niveis de dificudade do jogo:");
        System.out.println("1 - Nivel Fácil (Nesse nivel você tem que acertar um numero entre 1 e 10)");
        System.out.println("2 - Nivel Médio (Nesse nivel você tem que acertar um numero entre 1 e 50)");
        System.out.println("3 - Nivel Dificil (Nesse nivel você tem que acertar um numero entre 1 e 100)");
        System.out.println("Digite o número correspondente ao nivel desejado ou digite qualquer outro numero para encerar a jogada::");
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

    public static void sortearNumero() {
        numeroSorteado = random.nextInt(limite) + 1;
        System.out.println("O número foi sorteado! Tente adivinhar.");
        System.out.println("Digite '-1' a qualquer momento para encerrar o jogo.");
    }

    public static void iniciarJogo() {
        boolean acertou = false;
        while (!acertou) {
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();

            if (palpite == -1) {
                System.out.println("Você escolheu encerrar o jogo.");
                break;
            }
            if (palpite < 1 || palpite > limite) {
                System.out.println("Erro: O número deve estar entre 1 e " + limite + ". Tente novamente.");
                continue;
            }
            if (palpite == numeroSorteado) {
                System.out.println("Parabéns! Você acertou!");
                pontuacao += 10;
                acertos.add(palpite);
                acertou = true;
            } else {
                // Dica e pontuação
                if (palpite - numeroSorteado == 1 || palpite - numeroSorteado == -1) {
                    System.out.println("Dica: Você está muito próximo!");
                    pontuacao += 5;
                    acertosProximos.add(palpite);
                } else if (palpite - numeroSorteado == 2 || palpite - numeroSorteado == -2) {
                    System.out.println("Dica: Está relativamente perto.");
                    erros.add(palpite);
                } else {
                    System.out.println("Dica: Você está longe.");
                    erros.add(palpite);
                }
            }
        }

        System.out.println("======= RESULSTADOS FINAIS ========");
        System.out.println("Número sorteado: " + numeroSorteado);
        System.out.println("Pontuação final: " + pontuacao);
        System.out.println("Acertos: " + acertos);
        System.out.println("Acertos próximos: " + acertosProximos);
        System.out.println("Erros: " + erros);
        System.out.println("======= FIM DESSA RODADA ==========");
        scanner.close();
    }
}