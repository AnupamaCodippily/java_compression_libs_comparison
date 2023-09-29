package io.avcode;

import io.avcode.compressors.Compressor;
import io.avcode.compressors.NativeJavaCompressor;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PerformanceCheckerImpl implements PerformanceChecker{

    private final Compressor nativeJavaCompressor;

     public PerformanceCheckerImpl(NativeJavaCompressor nativeJavaCompressor) {
         this.nativeJavaCompressor = nativeJavaCompressor;
     }

    @Override
    public void compressFileNTimes(int numberOfCompressions, String fileName, boolean toZip) throws IOException {

         numberOfCompressions = (numberOfCompressions == 0) ? 1_000_000 : numberOfCompressions;

         ClassLoader classLoader = getClass().getClassLoader();
         URL url = classLoader.getResource("dummy_files/"+fileName);

         if (url == null) {
             throw new NullPointerException("Invalid dummy file path");
         }

         File file = new File(url.getPath());
        long startTimeMS = System.currentTimeMillis();

        for (int i = 0; i < numberOfCompressions; i++) {
            if (toZip) {
                nativeJavaCompressor.compressToFile(file);
            }
            else {
                nativeJavaCompressor.compress(file);
            }
            if (i % 1_000 == 0) {
                System.out.println("Operation #" + i);
            }
        }
        long endTimeMS = System.currentTimeMillis();
        float timeTaken = (endTimeMS - startTimeMS) / 1000f;
        System.out.printf("Time taken for %d operations:: %f seconds\n", numberOfCompressions, timeTaken);
    }

}
