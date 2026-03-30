package app;

import java.awt.image.BufferedImage;


import floodFill.FloodFill;
import image.GerenciadorImagem;

public class Main {
    public static void main(String[] args) {
        try {
            GerenciadorImagem gerenciadorImagem = new GerenciadorImagem();
            BufferedImage imagem = gerenciadorImagem.carregarImagem("C:\\programas\\projetoMarina\\FloodFill\\src\\app\\image.png");

            FloodFill floodFill = new FloodFill();

            int startX = 100;
            int startY = 100;

            floodFill.floodFillWithQueue(imagem, startX, startY, gerenciadorImagem);

            gerenciadorImagem.salvarImagem(imagem, "output.png");

            System.out.println("Flood Fill executado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao executar Flood Fill: " + e.getMessage());
        }
    }
}