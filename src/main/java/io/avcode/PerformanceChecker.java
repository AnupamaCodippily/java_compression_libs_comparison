package io.avcode;

import java.io.IOException;

public interface PerformanceChecker {

    void compressFileNTimes(int numberOfCompressions, String fileName, boolean toZip) throws IOException;
}
