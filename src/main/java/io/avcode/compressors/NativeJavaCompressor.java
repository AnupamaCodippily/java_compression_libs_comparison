package io.avcode.compressors;

import io.avcode.Configuration;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class NativeJavaCompressor implements Compressor {

    @Override
    public void compress(File file) {


        try(FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream     = new ByteArrayOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)
        ) {
            byte[] data = fileInputStream.readAllBytes();
            gzipOutputStream.write(data);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void compressToFile(File file) {
        File outFile = new File(Compressor.makeCompressedFilePath(file));
        try(FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream outputStream     = new FileOutputStream(outFile);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)
        ) {
            byte[] data = fileInputStream.readAllBytes();
            gzipOutputStream.write(data);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
