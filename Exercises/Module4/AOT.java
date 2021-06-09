package GreenScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AOT
{
    final static Color greenScreen = new Color(48,255,17);

    public static void main(String[] args) throws IOException
    {
        BufferedImage myBackground = ImageIO.read(new File("bg.png"));
        BufferedImage myTitans = ImageIO.read(new File("pic.png"));

        BufferedImage endImage = new BufferedImage(myBackground.getWidth(), myBackground.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        for (int col = 0; col < myBackground.getWidth(); col++)
        for (int row = 0; row < myBackground.getHeight(); row++)
        {
            Color myTitanColor = new Color(myTitans.getRGB(col, row));

            double distance = Math.sqrt(
                            Math.pow((myTitanColor.getRed() - greenScreen.getRed()), 2) +
                            Math.pow((myTitanColor.getGreen() - greenScreen.getGreen()), 2) +
                            Math.pow((myTitanColor.getBlue() - greenScreen.getBlue()), 2));

            if (distance > 185)
            {
                endImage.setRGB(col , row, myTitans.getRGB(col, row));
            }else
                endImage.setRGB(col , row, myBackground.getRGB(col, row));
        }

        File outputfile = new File("editedGS.png");
        ImageIO.write(endImage, "png", outputfile);
    }
}
