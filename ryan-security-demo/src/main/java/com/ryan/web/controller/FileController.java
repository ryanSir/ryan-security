package com.ryan.web.controller;

import com.ryan.model.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @author ryan
 * @version Id: FileController, v 0.1 2022/4/7 8:54 PM ryan Exp $
 */
@RestController
@RequestMapping("/file")
public class FileController {

    String folder = "/Users/ryan/Downloads";

    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());


        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    /**
     *
     * @param id
     * @param request
     * @param response
     */
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){

        try(InputStream inputStream = new FileInputStream(new File(folder,id + ".txt"));
            OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }catch (Exception e){
        }

    }


}
