package co.nrgm.printableimage.util;

import co.nrgm.printableimage.bean.PrintableImage;

import java.awt.*;

public class DimensionFixer {

    public enum Orientation {VERTICAL, HORIZONTAL}

    Orientation orientation;
    private float width;
    private float height;

    public DimensionFixer(int width, int height) {
        this.orientation = getOrientation(width, height);
        this.width = width;
        this.height = height;
    }

    private Orientation getOrientation(int width, int height) {
        return width <= height ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    public PrintableImage getPrintable(int width, int height) {
        // Establecer orientación según la imagen
        return getPrintable(getOrientation(width, height), width, height);
    }

    private PrintableImage getPrintable(Orientation orientation, int width, int height) {
        float paperWidth = this.width;
        float paperHeight = this.height;
        if (orientation != this.orientation) {
            paperWidth = this.height;
            paperHeight = this.width;
        }

        if (width <= paperWidth && height <= paperHeight) {
            return new PrintableImage(orientation.name(), width, height);
        }

        // Determinar la dimension más excede el tamaño del papel
        if (width / paperWidth >= height / paperHeight) {
            // El ancho delimita el tamaño
            return new PrintableImage(orientation.name(), (int) paperWidth, (int) (paperWidth / width * height));
        } else {
            // El alto delimita el tamaño
            return new PrintableImage(orientation.name(), (int) (paperHeight / height * width), (int) paperHeight);
        }
    }

}
