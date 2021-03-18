package co.nrgm.printableimage.service;

import co.nrgm.printableimage.bean.PrintableImage;
import co.nrgm.printableimage.util.DimensionFixer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class PrintableA4ImageService implements PrintableImageService {
    @Override
    public PrintableImage getPrintable(String b64DataFile) throws IOException {
        DimensionFixer dimensionFixer = new DimensionFixer(796, 1123);
        BufferedImage image;

        byte[] imageBytes = Base64.getDecoder().decode(b64DataFile);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes)) {
            image = ImageIO.read(bis);
        }

        return dimensionFixer.getPrintable(image.getWidth(), image.getHeight());
    }
}
