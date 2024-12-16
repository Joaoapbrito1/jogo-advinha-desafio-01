# Jogo de Adivinhação de Números

Este é um jogo simples de adivinhação de números em Java. O jogador deve tentar adivinhar um número sorteado aleatoriamente dentro de um intervalo definido por um nível de dificuldade. O jogo oferece dicas sobre a proximidade do palpite e acumula pontos para acertos e tentativas próximas.

---
## Funcionalidades

### 1. *Níveis de Dificuldade*
O jogo oferece três níveis de dificuldade, cada um com um intervalo de números diferentes:
- *Fácil:* números entre 1 e 10.
- *Médio:* números entre 1 e 50.
- *Difícil:* números entre 1 e 100.

### 2. *Pontuação*
- *Acerto:* O jogador ganha 10 pontos por acertar o número.
- *Dica de proximidade:* O jogador ganha 5 pontos se estiver muito próximo do número sorteado (diferente por 1).

### 3. *Dicas*
O jogo oferece as seguintes dicas com base no palpite:
- *Muito próximo:* Se a diferença entre o palpite e o número sorteado for 1.
- *Relativamente perto:* Se a diferença entre o palpite e o número sorteado for 2.
- *Longe:* Se a diferença for maior que 2.

### 4. *Resumo Final*
Ao final do jogo, o jogador recebe um resumo com a pontuação total, os números sorteados, acertos, acertos próximos e erros.

---
## Estrutura do Código

O código é dividido nas seguintes partes principais:

### 1. *Variáveis Globais*
- acertos, acertosProximos, erros: Listas que armazenam os números acertados, próximos e errados da rodada.
- totalAcertos, totalNumeroSorteado totalAcertosProximos, totalErros: Listas que armazenam os números acertados, próximos e errados de todas as rodadas.
- pontuacaoRodada: Armazena a pontuação da rodada atual.
- pontuacaoTotal: Armazena a pontuação total acumulada no jogo.
- limite: Define o limite superior do intervalo com base no nível de dificuldade.
- numeroSorteado: Armazena o número sorteado na rodada.

### 2. *Métodos*
- *resetarDados*: Limpa os dados da rodada atual.
- *exibirMenu*: Exibe o menu de escolha de nível de dificuldade.
- *definirLimite*: Define o limite superior do intervalo com base no nível escolhido.
- *sortearNumero*: Sorteia um número aleatório dentro do intervalo definido.
- *iniciarJogo*: Inicia o jogo, pede palpites e verifica se o jogador acertou ou não.
- *finalizarJogo*: Encerra o jogo e exibe o resumo final.
- *exibirResumoFinal*: Exibe o resumo do jogo com a pontuação total e os números sorteados.

---
## Como Jogar

1. *Escolher um Nível de Dificuldade*: Escolha entre os níveis "Fácil", "Médio" ou "Difícil". O intervalo de números será ajustado de acordo com o nível escolhido.
2. *Tentar Adivinhar o Número*: O jogo sorteia um número aleatório dentro do intervalo do nível escolhido. O jogador deve tentar adivinhar o número, fornecendo um palpite a cada rodada.
3. *Receber Dicas*: O jogo fornece dicas sobre a proximidade do palpite em relação ao número sorteado.
4. *Pontuação*: O jogador ganha pontos com base na proximidade dos palpites e pelos acertos.
5. *Finalizar o Jogo*: O jogador pode finalizar o jogo a qualquer momento. O jogo exibirá um resumo final com as pontuações e números sorteados.

---
## Exemplo de Execução

```text
=========================== JOGO DO ADVINHA ===============================
Níveis de dificuldade do jogo:
1 - Nivel Fácil (Nesse nivel você tem que acertar um numero entre 1 e 10)
2 - Nivel Médio (Nesse nivel você tem que acertar um numero entre 1 e 50)
3 - Nivel Dificil (Nesse nivel você tem que acertar um numero entre 1 e 100)
Digite o número correspondente ao nível desejado ou '-1' para encerrar o jogo a qualquer momento: