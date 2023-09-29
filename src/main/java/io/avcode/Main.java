package io.avcode;

import io.avcode.compressors.NativeJavaCompressor;

import java.io.IOException;


public class Main {
    public static void main(String[] args)  throws IOException {

        Configuration configuration = new Configuration();

        configuration.create();

        JavaUtilPerformanceChecker javaUtilPerformanceChecker = new JavaUtilPerformanceChecker(new NativeJavaCompressor());

        try {
            javaUtilPerformanceChecker.compress1MB1MilTimes();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}