import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Variáveis globais
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static ArrayList<Integer> acertos = new ArrayList<>(); // Acertos da rodada atual
    static ArrayList<Integer> acertosProximos = new ArrayList<>(); // Acertos próximos da rodada atual
    static ArrayList<Integer> erros = new ArrayList<>(); // Erros da rodada atual
    static ArrayList<Integer> totalAcertos = new ArrayList<>(); // Todos os números acertados
    static ArrayList<Integer> totalAcertosProximos = new ArrayList<>(); // Todos os números próximos
    static ArrayList<Integer> totalErros = new ArrayList<>(); // Todos os números errados
    static ArrayList<Integer> totalnumeroSorteado = new ArrayList<>();
    static int pontuacaoRodada = 0; // Pontuação da rodada atual
    static int pontuacaoTotal = 0; // Pontuação acumulada em todas as rodadas
    static int limite;
    static int numeroSorteado;

    public static void main(String[] args) {
        boolean continuarJogando = true;

        while (continuarJogando) {
            resetarDados(); // Reseta os dados para a nova rodada
            exibirMenu();

            if (limite == -1) {
                System.out.println("ERRO: Esse nível não existe. Reinicie o jogo e escolha um nível válido.");
                break; // Encerra o jogo se o nível for inválido
            }

            sortearNumero();
            continuarJogando = iniciarJogo();

            // Adiciona a pontuação da rodada à pontuação total
            pontuacaoTotal += pontuacaoRodada;

            // Acumula os dados da rodada nos totais
            totalAcertos.addAll(acertos);
            totalAcertosProximos.addAll(acertosProximos);
            totalErros.addAll(erros);
            totalnumeroSorteado.add(numeroSorteado);
        }

        exibirResumoFinal();
        System.out.println("Obrigado por jogar! Até a próxima.");
        scanner.close();
    }

    public static void resetarDados() {
        // Limpa as listas para a nova rodada
        acertos.clear();
        acertosProximos.clear();
        erros.clear();
        pontuacaoRodada = 0; // Reseta a pontuação da rodada
    }

    public static void exibirMenu() {
        System.out.println("=========================== JOGO DO ADVINHA ===============================");
        System.out.println("A cada numero acertado o jogador ganha 10 pontos e cada acerto proximo o jogador ganha 5 pontos,");
        System.out.println("acerto proximo (um numero antes ou depois do numero correto).");
        System.out.println("==================== Níveis de dificuldade do jogo ========================");
        System.out.println("1 - Nivel Fácil (Nesse nivel você tem que acertar um numero entre 1 e 10)");
        System.out.println("2 - Nivel Médio (Nesse nivel você tem que acertar um numero entre 1 e 50)");
        System.out.println("3 - Nivel Dificil (Nesse nivel você tem que acertar um numero entre 1 e 100)");
        System.out.println("Digite o número correspondente ao nível desejado ou qualquer outro numero para encerrar o jogo:");
        int nivel = scanner.nextInt();

        // Finaliza o jogo se a entrada for -1
        if (nivel == -1) {
            finalizarJogo();
        }

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

    public static boolean iniciarJogo() {
        boolean acertou = false;
        while (!acertou) {
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();

            if (palpite == -1) {
                finalizarJogo(); // Finaliza o jogo imediatamente
            }

            if (palpite < 1 || palpite > limite) {
                System.out.println("Erro: O número deve estar entre 1 e " + limite + ". Tente novamente.");
                continue;
            }
            if (palpite == numeroSorteado) {
                System.out.println("Parabéns! Você acertou!");
                pontuacaoRodada += 10;
                acertos.add(palpite);
                acertou = true;
            } else {
                // Dica e pontuação
                if (Math.abs(palpite - numeroSorteado) == 1) {
                    System.out.println("Dica: Você está muito próximo!");
                    pontuacaoRodada += 5;
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

        System.out.println("======= RESULTADOS DA RODADA ========");
        System.out.println("Número sorteado: " + numeroSorteado);
        System.out.println("Pontuação da rodada: " + pontuacaoRodada);
        System.out.println("Acertos nesta rodada: " + acertos);
        System.out.println("Acertos próximos nesta rodada: " + acertosProximos);
        System.out.println("Erros nesta rodada: " + erros);
        System.out.println("========= FIM DESSA RODADA ============");

        return true; // Retorna ao loop principal para perguntar por outra rodada
    }

    public static void finalizarJogo() {
        exibirResumoFinal();
        System.out.println("Jogo encerrado pelo jogador. Obrigado por jogar!");
        System.exit(0); // Finaliza o programa
    }

    public static void exibirResumoFinal() {
        System.out.println("======= RESUMO FINAL DO JOGO ========");
        System.out.println("Pontuação total do jogo: " + pontuacaoTotal);
        System.out.println("Numeros sorteados: " + totalnumeroSorteado);
        System.out.println("Números acertados: " + totalAcertos);
        System.out.println("Acertos próximos: " + totalAcertosProximos);
        System.out.println("Números errados: " + totalErros);
        System.out.println("=========== FIM DE JOGO =============");
    }
}