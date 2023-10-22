/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.passeiocavalo;

/**
 *
 * @author Caio Veloso  &lt;caio.veloso at ifnmg.edu.br&gt;
 */
public class CAVALOS {
    private static final int TAMANHO_TABULEIRO = 8; // Tamanho do tabuleiro
    private static final int[][] MOVIMENTOS = { {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1} };
    private static int[][] tabuleiro;
    private static int numeroMovimentos = 1;

    public static void main(String[] args) {
        tabuleiro = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        int linhaInicial = 0; // Linha inicial
        int colunaInicial = 0; // Coluna inicial

        if (resolverPasseioCavalo(linhaInicial, colunaInicial)) {
            imprimirTabuleiro();
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }

        System.out.println("" + (numeroMovimentos - 1) + " movimentos.");
    }

    private static boolean resolverPasseioCavalo(int linha, int coluna) {
        tabuleiro[linha][coluna] = numeroMovimentos;

        if (numeroMovimentos == TAMANHO_TABULEIRO * TAMANHO_TABULEIRO) {
            return true; // Todos os quadrados foram visitados
        }

        for (int i = 0; i < 8; i++) {
            int proximaLinha = linha + MOVIMENTOS[i][0];
            int proximaColuna = coluna + MOVIMENTOS[i][1];

            if (movimentoValido(proximaLinha, proximaColuna) && tabuleiro[proximaLinha][proximaColuna] == 0) {
                numeroMovimentos++;
                if (resolverPasseioCavalo(proximaLinha, proximaColuna)) {
                    return true;
                }
                numeroMovimentos--;
                tabuleiro[proximaLinha][proximaColuna] = 0;
            }
        }

        return false;
    }

    private static boolean movimentoValido(int linha, int coluna) {
        return (linha >= 0 && linha < TAMANHO_TABULEIRO && coluna >= 0 && coluna < TAMANHO_TABULEIRO);
    }

    private static void imprimirTabuleiro() {
        for (int[] linha : tabuleiro) {
            for (int celula : linha) {
                System.out.printf("%2d ", celula);
            }
            System.out.println();
        }
    }
}
