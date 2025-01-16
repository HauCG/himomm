package com.example.customerman.opencv;

import org.opencv.core.Core;

public class OpenCv {
    public static void main(String[] args) {
        // Load the native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("OpenCV Version: " + Core.VERSION);
    }
}