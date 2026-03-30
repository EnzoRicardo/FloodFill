package app;

import java.awt.image.BufferedImage;

import floodFill.FloodFill;
import image.GerenciadorImagem;

public class Main {
    public static void main(String[] args) {
        try {
            GerenciadorImagem gerenciadorImagem = new GerenciadorImagem();
            BufferedImage imagem = gerenciadorImagem.carregarImagem(
                    "C:\\Users\\User\\Desktop\\PUC-BSI\\5°\\Java\\projetoMarina\\src\\app\\panda.png"
            );

            FloodFill floodFill = new FloodFill();

            int startX = 512;
            int startY = 512;

            floodFill.floodFillWithQueue(imagem, startX, startY, gerenciadorImagem);

            gerenciadorImagem.salvarImagem(imagem, "output3.png");

            System.out.println("Flood Fill executado com sucesso.");
            System.out.println("Imagem final salva como output2.png");
            System.out.println("Frames salvos na pasta frames_queue");
        } catch (Exception e) {
            System.out.println("Erro ao executar Flood Fill: " + e.getMessage());
        }
    }
}