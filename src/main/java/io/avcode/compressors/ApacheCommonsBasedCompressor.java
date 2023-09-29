package io.avcode.compressors;

import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.*;

public class ApacheCommonsBasedCompressor implements Compressor{

    @Override
    public void compress(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream     = new ByteArrayOutputStream();
            GzipCompressorOutputStream gzipOutputStream = new GzipCompressorOutputStream (outputStream)
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
            GzipCompressorOutputStream gzipOutputStream = new GzipCompressorOutputStream (outputStream)
        ) {
            byte[] data = fileInputStream.readAllBytes();
            gzipOutputStream.write(data);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
