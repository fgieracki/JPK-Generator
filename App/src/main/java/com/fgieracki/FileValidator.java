package com.fgieracki;

import java.io.File;

public class FileValidator {

        public static boolean isFileValid(String filePath) {
            return checkSuffix(filePath) && checkIfFileExists(filePath);
        }

        private static boolean checkSuffix(String filePath) {
            return filePath.endsWith(".csv") || filePath.endsWith(".xlsx");
        }

        private static boolean checkIfFileExists(String filePath) {
            return new File(filePath).exists();
        }

        FileValidator() {}
}
