package co.nrgm.printableimage.controller;

import co.nrgm.printableimage.bean.PrintableImage;
import co.nrgm.printableimage.service.PrintableImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PrintableImageController {

    @Autowired
    private PrintableImageService imageService;

    @PostMapping(path = "/printable")
    public PrintableImage getPrintable(@RequestBody String b64DataFile) throws IOException {
        return imageService.getPrintable(b64DataFile);
    }
}
