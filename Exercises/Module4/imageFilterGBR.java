package ImageEffects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imageFilterGBR
{
    public static void main(String[] args) throws IOException
    {
        BufferedImage myImage = ImageIO.read(new File("myImage.png"));

        for (int col = 0; col < myImage.getWidth(); col++)
            for (int row = 0; row < myImage.getHeight(); row++)
            {
                Color myImageColor = new Color(myImage.getRGB(col, row));
                Color pixel = new Color(myImageColor.getGreen(),myImageColor.getBlue(),myImageColor.getRed());
                myImage.setRGB(col , row, pixel.getRGB());
            }

        File outputfile = new File("filter_GBR.png");
        ImageIO.write(myImage, "png", outputfile);
    }
}
