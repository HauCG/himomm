package com.example.customerman.config;

import org.opencv.core.Core;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

@Configuration
public class OpenCVConfig {
    
    private static final Logger logger = LoggerFactory.getLogger(OpenCVConfig.class);
    private static boolean libraryLoaded = false;
    
    @PostConstruct
    public void init() {
        if (!libraryLoaded) {
            try {
                // Tìm đường dẫn thư mục lib trong project
                String projectDir = System.getProperty("user.dir");
                String libPath = projectDir + File.separator + "lib" + File.separator;
                File libDir = new File(libPath);
                
                if (!libDir.exists()) {
                    logger.info("Tạo thư mục lib tại: {}", libPath);
                    libDir.mkdirs();
                }
                
                String libraryPath = libPath + Core.NATIVE_LIBRARY_NAME + ".dll";
                File libraryFile = new File(libraryPath);
                
                if (!libraryFile.exists()) {
                    logger.error("Không tìm thấy file {} trong thư mục lib", Core.NATIVE_LIBRARY_NAME + ".dll");
                    logger.error("Vui lòng copy file opencv_java470.dll vào thư mục: {}", libPath);
                    throw new RuntimeException("File OpenCV DLL không tồn tại");
                }
                
                logger.info("Loading OpenCV library từ: {}", libraryPath);
                System.load(libraryPath);
                libraryLoaded = true;
                logger.info("OpenCV {} đã được load thành công", Core.VERSION);
            } catch (Exception e) {
                logger.error("Không thể load OpenCV: {}", e.getMessage());
                logger.debug("Chi tiết lỗi:", e);
                throw new RuntimeException("Không thể load OpenCV", e);
            }
        }
    }
}
