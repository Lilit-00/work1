import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


import javax.imageio.ImageIO;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.util.Scanner;

public class Task {
}
class ImageReadWriteExample {
    static String note;

    public static void main(String[] args) {
        // Replace "path/to/your/image.jpg" with the actual path to your image file
        enterData();
        String inputImagePath = "2.jpg";
        String outputImagePath = "4.jpg";

        // Read the image from file
        BufferedImage originalImage = readImage(inputImagePath);
        System.out.println(originalImage.getWidth());


        BufferedImage imageNew =  addText(originalImage, note , originalImage.getHeight()-100, originalImage.getWidth()-100, Color.RED, new Font("Arial", Font.BOLD, 20));

        if (originalImage != null) {
            // Write the image to a new file
            writeImage(imageNew, outputImagePath);
            System.out.println("Image has been read and written successfully.");
        } else {
            System.err.println("Error reading the image.");
        }


    }
    private static BufferedImage addText(BufferedImage image, String text, int x, int y, Color color, Font font) {
        // Create a Graphics2D object to draw on the image
        Graphics2D g2d = image.createGraphics();

        // Set the font and color for the text
        g2d.setFont(font);
        g2d.setColor(color);

        // Draw the text on the image
        g2d.drawString(text, x, y);

        // Dispose of the Graphics2D object
        g2d.dispose();

        return image;
    }
    static void enterData(){
        Scanner sc = new Scanner(System.in);
        note = sc.nextLine();
    }

    private static BufferedImage readImage(String imagePath) {
        try {
            File file = new File(imagePath);
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void writeImage(BufferedImage image, String outputPath) {
        try {
            // PdfDocument.fromImage(paths).saveAs(Paths.get("example.pdf"));

            File outputFile = new File(outputPath);
            ImageIO.write(image, "jpg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* private static void writeImageToPdf(BufferedImage image, String outputPdfPath) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);
            PDResources resources = new PDResources();
            PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);
            resources.addXObject(pdImageXObject, "img");
            contentStream.drawImage(pdImageXObject, 100, 500, image.getWidth(), image.getHeight());
            contentStream.close();

            document.save(outputPdfPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}


