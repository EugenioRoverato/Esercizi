package ImageEffects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Filters {
    final static float[] LUMA = new float[]{0.3f, 0.6f, 0.1f};

    public void blackWhiteImage(BufferedImage inputImage) throws IOException {
        for (int col = 0; col < inputImage.getWidth(); col++)
            for (int row = 0; row < inputImage.getHeight(); row++) {
                Color myImageColor = new Color(inputImage.getRGB(col, row));
                int newGrey =
                                (int) (myImageColor.getRed() * LUMA[0]) +
                                (int) (myImageColor.getGreen() * LUMA[1]) +
                                (int) (myImageColor.getBlue() * LUMA[2]);

                Color pixel = new Color(newGrey, newGrey, newGrey);
                inputImage.setRGB(col, row, pixel.getRGB());
            }

        File outputfile = new File("newImage.png");
        ImageIO.write(inputImage, "png", outputfile);
    }

    public void mirrorImage(BufferedImage inputImage, BufferedImage outputImage) throws IOException
    {
        int reduceCol = outputImage.getWidth();

        for (int col = 0; col < inputImage.getWidth(); col++) {
            for (int row = 0; row < inputImage.getHeight(); row++)
                outputImage.setRGB(reduceCol - 1, row, inputImage.getRGB(col, row));
            reduceCol--;
        }

        File outputfile = new File("newImage.png");
        ImageIO.write(outputImage, "png", outputfile);
    }

    public void gbrImage(BufferedImage inputImage) throws IOException {
        for (int col = 0; col < inputImage.getWidth(); col++)
            for (int row = 0; row < inputImage.getHeight(); row++)
            {
                Color myImageColor = new Color(inputImage.getRGB(col, row));
                Color pixel = new Color(myImageColor.getGreen(),myImageColor.getBlue(),myImageColor.getRed());
                inputImage.setRGB(col , row, pixel.getRGB());
            }

        File outputfile = new File("newImage.png");
        ImageIO.write(inputImage, "png", outputfile);
    }

    public void negativeImage(BufferedImage inputImage) throws IOException
    {
        for (int col = 0; col < inputImage.getWidth(); col++)
            for (int row = 0; row < inputImage.getHeight(); row++)
            {
                Color myImageColor = new Color(inputImage.getRGB(col, row));
                Color pixel = new Color(255-myImageColor.getRed(),255-myImageColor.getGreen(),255-myImageColor.getBlue());
                inputImage.setRGB(col , row, pixel.getRGB());
            }

        File outputfile = new File("newImage.png");
        ImageIO.write(inputImage, "png", outputfile);
    }
}

public class ImageFilters
{
    public static void main(String[] args) throws IOException
    {
        BufferedImage inputImage = ImageIO.read(new File("myImage.png"));
        BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        Filters myFilters = new Filters();

        myFilters.blackWhiteImage(inputImage);
        myFilters.mirrorImage(inputImage, outputImage);
        myFilters.gbrImage(inputImage);
        myFilters.negativeImage(inputImage);
    }
}