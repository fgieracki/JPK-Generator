package com.fgieracki;

import java.io.File;

public class FileValidator {

        public static boolean isFileValid(String filePath) {
            return checkSuffix(filePath) && checkIfFileExists(filePath);
        }

        protected static boolean checkSuffix(String filePath) {
            return filePath.endsWith(".csv") || filePath.endsWith(".xlsx");
        }

        protected static boolean checkIfFileExists(String filePath) {
            return new File(filePath).exists();
        }

        FileValidator() {}
}
