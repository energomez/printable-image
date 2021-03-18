package co.nrgm.printableimage.bean;

import java.util.Objects;

public class PrintableImage {

    String orientation;
    private int width;
    private int height;

    public PrintableImage(String orientation, int width, int height) {
        this.orientation = orientation;
        this.width = width;
        this.height = height;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintableImage that = (PrintableImage) o;
        return width == that.width && height == that.height && orientation.equals(that.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, width, height);
    }

    @Override
    public String toString() {
        return "PrintableImage{" +
                "orientation='" + orientation + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
