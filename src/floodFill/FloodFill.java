package floodFill;

import java.awt.Color;
import java.awt.image.BufferedImage;

import model.Pixel;
import structures.FilaEncadeada;
import structures.PilhaEncadeada;

public class FloodFill {

    public void floodFillWithQueue(BufferedImage image, int startX, int startY) {
        if (image == null) {
            return;
        }

        if (startX < 0 || startX >= image.getWidth() || startY < 0 || startY >= image.getHeight()) {
            return;
        }

        int originalColor = image.getRGB(startX, startY);
        int fillColor = new Color(167, 45, 161).getRGB();

        if (originalColor == fillColor) {
            return;
        }

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

            pixelQueue.enqueue(new Pixel(x + 1, y));
            pixelQueue.enqueue(new Pixel(x - 1, y));
            pixelQueue.enqueue(new Pixel(x, y + 1));
            pixelQueue.enqueue(new Pixel(x, y - 1));
        }
    }

    public void floodFillWithStack(BufferedImage image, int startX, int startY) {
        if (image == null) {
            return;
        }

        if (startX < 0 || startX >= image.getWidth() || startY < 0 || startY >= image.getHeight()) {
            return;
        }

        int originalColor = image.getRGB(startX, startY);
        int fillColor = new Color(0,143,57).getRGB();

        if (originalColor == fillColor) {
            return;
        }

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

            stack.push(new Pixel(x + 1, y));
            stack.push(new Pixel(x - 1, y));
            stack.push(new Pixel(x, y + 1));
            stack.push(new Pixel(x, y - 1));
        }
    }

    private boolean isValidPixel(BufferedImage image, int x, int y) {
        return x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight();
    }
}