package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GerenciadorImagem {

    public BufferedImage carregarImagem(String caminho) throws IOException {
        File arquivo = new File(caminho);
        return ImageIO.read(arquivo);
    }

    public void salvarImagem(BufferedImage imagem, String caminho) throws IOException {
        File arquivo = new File(caminho);
        ImageIO.write(imagem, "png", arquivo);
    }

    public void salvarFrame(BufferedImage imagem, String pasta, int contador) throws IOException {
        File diretorio = new File(pasta);

        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        String nomeArquivo = String.format("%s/frame_%04d.png", pasta, contador);
        ImageIO.write(imagem, "png", new File(nomeArquivo));
    }

    public int getCorPixel(BufferedImage imagem, int x, int y) {
        return imagem.getRGB(x, y);
    }

    public void setCorPixel(BufferedImage imagem, int x, int y, int cor) {
        imagem.setRGB(x, y, cor);
    }

    public int getLargura(BufferedImage imagem) {
        return imagem.getWidth();
    }

    public int getAltura(BufferedImage imagem) {
        return imagem.getHeight();
    }
}