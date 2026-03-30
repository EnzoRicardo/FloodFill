package floodFill;

import java.awt.Color;
import java.awt.image.BufferedImage;

import image.GerenciadorImagem;
import model.Pixel;
import structures.FilaEncadeada;
import structures.PilhaEncadeada;

public class FloodFill {

    public void floodFillWithQueue(BufferedImage image, int startX, int startY, GerenciadorImagem gerenciadorImagem) {
        if (image == null) {
            return;
        }

        if (startX < 0 || startX >= image.getWidth() || startY < 0 || startY >= image.getHeight()) {
            return;
        }

        int originalColor = image.getRGB(startX, startY);
        int fillColor = new Color(79, 111, 255).getRGB();

        if (originalColor == fillColor) {
            return;
        }

        int frameCounter = 0;
        int pixelCounter = 0;

        FilaEncadeada pixelQueue = new FilaEncadeada();
        pixelQueue.enqueue(new Pixel(startX, startY));

        while (!pixelQueue.isEmpty()) {
            Pixel currentPixel = pixelQueue.dequeue();

            if (currentPixel == null) {
                continue;
            }

            int x = currentPixel.getX();
            int y = currentPixel.getY();

            if (!isValidPixel(image, x, y)) {
                continue;
            }

            if (image.getRGB(x, y) != originalColor) {
                continue;
            }

            image.setRGB(x, y, fillColor);

            pixelCounter++;

            if (pixelCounter % 1000 == 0) {
                try {
                    gerenciadorImagem.salvarFrame(image, "frames_queue", frameCounter);
                    frameCounter++;
                } catch (Exception e) {
                    System.out.println("Erro ao salvar frame: " + e.getMessage());
                }
            }

            pixelQueue.enqueue(new Pixel(x + 1, y));
            pixelQueue.enqueue(new Pixel(x - 1, y));
            pixelQueue.enqueue(new Pixel(x, y + 1));
            pixelQueue.enqueue(new Pixel(x, y - 1));
        }

        // salva último frame
        try {
            gerenciadorImagem.salvarFrame(image, "frames_queue", frameCounter);
        } catch (Exception e) {
            System.out.println("Erro ao salvar frame final: " + e.getMessage());
        }
    }

    public void floodFillWithStack(BufferedImage image, int startX, int startY, GerenciadorImagem gerenciadorImagem) {
        if (image == null) {
            return;
        }

        if (startX < 0 || startX >= image.getWidth() || startY < 0 || startY >= image.getHeight()) {
            return;
        }

        int originalColor = image.getRGB(startX, startY);
        int fillColor = new Color(0, 143, 57).getRGB();

        if (originalColor == fillColor) {
            return;
        }

        int frameCounter = 0;
        int pixelCounter = 0;

        PilhaEncadeada stack = new PilhaEncadeada();
        stack.push(new Pixel(startX, startY));

        while (!stack.isEmpty()) {
            Pixel currentPixel = stack.pop();

            if (currentPixel == null) {
                continue;
            }

            int x = currentPixel.getX();
            int y = currentPixel.getY();

            if (!isValidPixel(image, x, y)) {
                continue;
            }

            if (image.getRGB(x, y) != originalColor) {
                continue;
            }

            image.setRGB(x, y, fillColor);

            pixelCounter++;

            if (pixelCounter % 1000 == 0) {
                try {
                    gerenciadorImagem.salvarFrame(image, "frames_stack", frameCounter);
                    frameCounter++;
                } catch (Exception e) {
                    System.out.println("Erro ao salvar frame: " + e.getMessage());
                }
            }

            stack.push(new Pixel(x + 1, y));
            stack.push(new Pixel(x - 1, y));
            stack.push(new Pixel(x, y + 1));
            stack.push(new Pixel(x, y - 1));
        }

        // salva último frame
        try {
            gerenciadorImagem.salvarFrame(image, "frames_stack", frameCounter);
        } catch (Exception e) {
            System.out.println("Erro ao salvar frame final: " + e.getMessage());
        }
    }

    private boolean isValidPixel(BufferedImage image, int x, int y) {
        return x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight();
    }
}