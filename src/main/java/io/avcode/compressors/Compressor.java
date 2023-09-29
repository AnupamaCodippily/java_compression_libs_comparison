package io.avcode.compressors;

import io.avcode.Configuration;

import java.io.File;
import java.io.IOException;

public interface Compressor {

    static String makeCompressedFilePath(File file) {
       return  Configuration.OUTPUT_PATH + "results" + File.separator + file.getName() + ".zip";
    }
    public void compress(File file) throws IOException;

}
