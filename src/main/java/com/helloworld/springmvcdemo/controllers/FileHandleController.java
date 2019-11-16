package com.helloworld.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/file-upload")
public class FileHandleController {

    private static final String UPLOAD_DIRECTORY ="/";

    @RequestMapping(value = "/upload-form", method = RequestMethod.GET)
    public ModelAndView getUploadForm(ModelAndView modelAndView) {
        modelAndView.setViewName("fileupload/upload-form");
        return modelAndView;
    }

    @RequestMapping(value = "/upload-form", method = RequestMethod.POST)
    public ModelAndView getUploadFormData(@RequestParam CommonsMultipartFile file, HttpSession httpSession, ModelAndView modelAndView) throws IOException {
        ServletContext context = httpSession.getServletContext();
        String path = context.getRealPath(UPLOAD_DIRECTORY);
        String filename = file.getOriginalFilename();
        System.out.println(path+" "+filename);
        byte[] bytes = file.getBytes();
        File uploadFile = new File(path + File.separator + filename);
        FileOutputStream fileOutputStream = new FileOutputStream(uploadFile);
        BufferedOutputStream stream =new BufferedOutputStream(fileOutputStream);
        stream.write(bytes);
        stream.flush();
        stream.close();
        modelAndView.setViewName("fileupload/upload-form");
        modelAndView.addObject("filesuccess","File successfully saved!");
        return modelAndView;
    }
}
