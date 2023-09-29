package io.avcode;

import io.avcode.compressors.NativeJavaCompressor;

import java.io.IOException;


public class Main {
    public static void main(String[] args)  throws IOException {

        Configuration configuration = new Configuration();

        configuration.create();

        PerformanceCheckerImpl vanillaCompressionChecker = new PerformanceCheckerImpl(new NativeJavaCompressor());
        PerformanceCheckerImpl apacheCompressionChecker = new PerformanceCheckerImpl(new NativeJavaCompressor());
        PerformanceCheckerImpl zip4JCompressionChecker = new PerformanceCheckerImpl(new NativeJavaCompressor());

        try {
//            javaUtilPerformanceChecker.compressFileNTimes(10, "users_10k.json", false);
            vanillaCompressionChecker.compressFileNTimes(1, "users_1m.json", true);



        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}