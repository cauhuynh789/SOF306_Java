//package com.sof306.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.sof306.dao.UploadService;
//
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.ServletContext;
//
//@Service
//public class UploadServiceImpl implements UploadService {
//    @Autowired
//    ServletContext app;
//
//    @Override
//    public File save(MultipartFile file, String folder) {
//        File dir = new File(app.getRealPath("/assets/" + folder));
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
////        String s = System.currentTimeMillis() + file.getOriginalFilename();
//        String name = file.getOriginalFilename();
//        try {
//            File savedFile = new File(dir, name);
//            file.transferTo(savedFile);
//            return savedFile;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
