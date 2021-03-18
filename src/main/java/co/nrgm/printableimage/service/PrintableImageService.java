package co.nrgm.printableimage.service;

import co.nrgm.printableimage.bean.PrintableImage;

import java.io.IOException;

public interface PrintableImageService {

    PrintableImage getPrintable(String b64DataFile) throws IOException;
}
