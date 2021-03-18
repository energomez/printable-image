package co.nrgm.printableimage.util;

import co.nrgm.printableimage.bean.PrintableImage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DimensionFixerTest {

    @Test
    void getPrintable() {
        DimensionFixer paperA4 = new DimensionFixer(796, 1123);
        PrintableImage resizedImage;

        // Tamaño inferior al papel
        resizedImage = paperA4.getPrintable(795, 795);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.VERTICAL.name(), 795, 795), resizedImage);

        resizedImage = paperA4.getPrintable(795, 796);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.VERTICAL.name(), 795, 796), resizedImage);

        resizedImage = paperA4.getPrintable(796, 795);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.HORIZONTAL.name(), 796, 795), resizedImage);

        // Tamaño igual al papel
        resizedImage = paperA4.getPrintable(796, 1123);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.VERTICAL.name(), 796, 1123), resizedImage);

        // Impresión debe rotarse
        resizedImage = paperA4.getPrintable(797, 796);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.HORIZONTAL.name(), 797, 796), resizedImage);

        // Imagen debe redimenzionarse
        resizedImage = paperA4.getPrintable(797, 1123);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.VERTICAL.name(), 796, 1121), resizedImage);

        // Imagen debe redimenzionarse
        resizedImage = paperA4.getPrintable(796, 1124);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.VERTICAL.name(), 795, 1123), resizedImage);

        // Imagen debe rotarse y redimenzionarse
        resizedImage = paperA4.getPrintable(1123, 797);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.HORIZONTAL.name(), 1121, 796), resizedImage);

        resizedImage = paperA4.getPrintable(1124, 796);
        assertEquals(new PrintableImage(DimensionFixer.Orientation.HORIZONTAL.name(), 1123, 795), resizedImage);
    }

}