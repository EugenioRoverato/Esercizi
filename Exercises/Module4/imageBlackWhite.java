package ImageEffects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imageBlackWhite
{
    final static float[] LUMA = new float[]{0.3f, 0.6f, 0.1f};

    public static void main(String[] args) throws IOException
    {
        BufferedImage myImage = ImageIO.read(new File("myImage.png"));

        for (int col = 0; col < myImage.getWidth(); col++)
            for (int row = 0; row < myImage.getHeight(); row++)
            {
                Color myImageColor = new Color(myImage.getRGB(col, row));
                int newGrey = (int) (myImageColor.getRed() * LUMA[0]) + (int) (myImageColor.getGreen() * LUMA[1]) + (int) (myImageColor.getBlue() * LUMA[2]);
                Color pixel = new Color(newGrey, newGrey, newGrey);
                myImage.setRGB(col , row, pixel.getRGB());
            }

        File outputfile = new File("filter_blackWhite.png");
        ImageIO.write(myImage, "png", outputfile);
    }
}
