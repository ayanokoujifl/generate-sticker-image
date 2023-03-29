package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StickerGenerator {

    public void generate() throws IOException {

        URL url = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg");
        BufferedImage originalImage = ImageIO.read(url);

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 150;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 56));
        graphics.setColor(new Color(195, 131, 251));
        graphics.setBackground(new Color(250, 0, 0));
        graphics.drawString("Teste Draw String", (width / 4) - (width / 6), newHeight - 75);

        ImageIO.write(newImage, "png", new File("saida/figurinha.png"));

    }
}
