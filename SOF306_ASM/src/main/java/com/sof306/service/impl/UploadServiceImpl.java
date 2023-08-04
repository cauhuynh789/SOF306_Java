package com.sof306.service.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sof306.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public File save(MultipartFile file, String folder) {
	    try {
	        // Lấy đường dẫn tới thư mục static của dự án
	        String staticDir = ResourceUtils.getFile("classpath:static/assets/images/accounts").getAbsolutePath();

	        // Tạo đường dẫn đến thư mục cần lưu file
	        String directory = staticDir + File.separator;
	        File folderDir = new File(directory);

	        // Tạo thư mục nếu chưa tồn tại
	        if (!folderDir.exists() && !folderDir.mkdirs()) {
	            throw new RuntimeException("Failed to create directory: " + directory);
	        }

	        // Tạo tên file mới bằng cách kết hợp thời gian hiện tại và tên file gốc
	        String fileName = System.currentTimeMillis() + Objects.requireNonNull(file.getOriginalFilename());
	        File savedFile = new File(folderDir, fileName);

	        // Tạo ảnh mới với kích thước mong muốn
	        BufferedImage resizedImage = new BufferedImage(2800, 2800, BufferedImage.TYPE_INT_RGB);

	        // Đọc ảnh gốc từ MultipartFile
	        BufferedImage inputImage = ImageIO.read(file.getInputStream());

	        // Thực hiện resize bằng cách vẽ lại ảnh gốc trên ảnh mới
	        Graphics2D g2d = resizedImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, 2800, 2800, null);
	        g2d.dispose();

	        // Lưu ảnh đã resize vào thư mục
	        try (FileOutputStream fileOutputStream = new FileOutputStream(savedFile)) {
	            ImageIO.write(resizedImage, "jpg", fileOutputStream);
	        }

	        return savedFile;
	    } catch (IOException e) {
	        throw new RuntimeException(e.getMessage());
	    }
	}


}
