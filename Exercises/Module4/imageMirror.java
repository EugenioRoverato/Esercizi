package ImageEffects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imageMirror
{
    public static void main(String[] args) throws IOException
    {
        BufferedImage myImage = ImageIO.read(new File("myImage.png"));
        BufferedImage newImage = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        int reduceRow = newImage.getHeight();
        int reduceCol = newImage.getWidth();

        for (int col = 0; col < myImage.getWidth(); col++)
        {
            for (int row = 0; row < myImage.getHeight(); row++)
            {
                newImage.setRGB(reduceCol-1, reduceRow-1, myImage.getRGB(col, row));
                reduceRow--;

                if (row == myImage.getHeight()-1)
                {
                    reduceRow = myImage.getHeight();
                }
            }
            reduceCol--;
        }

        File outputfile = new File("filter_mirror.png");
        ImageIO.write(myImage, "png", outputfile);
    }
}
