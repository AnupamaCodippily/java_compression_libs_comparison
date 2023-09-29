package io.avcode;

import io.avcode.compressors.NativeJavaCompressor;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JavaUtilPerformanceChecker implements PerformanceChecker{

    private final NativeJavaCompressor nativeJavaCompressor;

     public JavaUtilPerformanceChecker(NativeJavaCompressor nativeJavaCompressor) {
         this.nativeJavaCompressor = nativeJavaCompressor;
     }

    @Override
    public void compress1MB1MilTimes() throws IOException {

         ClassLoader classLoader = getClass().getClassLoader();
         URL url = classLoader.getResource("dummy_files/users_100k.json");

         if (url == null) {
             throw new NullPointerException("Invalid dummy file path");
         }

         File file = new File(url.getPath());
        long startTimeMS = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            nativeJavaCompressor.compress(file);
        }
        long endTimeMS = System.currentTimeMillis();
        float timeTaken = (endTimeMS - startTimeMS) / 1000f;
        System.out.printf("Time taken %f seconds", timeTaken);
    }
}
