package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static void saveResizedImage(File original, File destino, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(original);
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(resizedImage, 0, 0, null);
            g2d.dispose();

            ImageIO.write(outputImage, "jpg", destino);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}