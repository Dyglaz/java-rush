package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) {
        ImageReader imageReader = null;
        if(imageType == null) throw new IllegalArgumentException("Неизвестный тип картинки");
        switch (imageType) {
            case PNG:
                imageReader = new PngReader();
                break;
            case JPG:
                imageReader = new JpgReader();
                break;
            case BMP:
                imageReader = new BmpReader();
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return imageReader;
    }
}
