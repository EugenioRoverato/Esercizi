package ImageEffects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShadesOfGray
{
    public static void main(String[] args) throws IOException
    {
        BufferedImage outputImage = new BufferedImage(256, 256, BufferedImage.TYPE_3BYTE_BGR);

        int dominantColor;

        for (int col = 0; col < outputImage.getWidth(); col++)
            for (int row = 0; row < outputImage.getHeight(); row++)
            {
                dominantColor = Math.max(col, row);
                Color pixel = new Color(dominantColor,dominantColor,dominantColor);
                outputImage.setRGB(col , row, pixel.getRGB());
            }

        File outputfile = new File("greyShades.jpg");
        ImageIO.write(outputImage, "jpg", outputfile);
    }
}
