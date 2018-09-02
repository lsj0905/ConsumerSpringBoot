package com.springboot.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    //单文件上传
    @RequestMapping(value = "/singleFile" ,method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)//@RequestParam(value = "key", required = true) String key,
    public String singleFileUpload(/*@RequestParam("orderCode") String orderCode,*/ @RequestParam(value = "fileName", required = true) String fileName, @RequestParam(value = "file", required = true) MultipartFile file){

        if(!file.isEmpty()){
            try {
                File rootDirectory=new File("D:\\xystofrage\\");
                if (!rootDirectory.exists()){
                    rootDirectory.mkdirs();
                }
                File outFile=new File(rootDirectory,fileName+file.getOriginalFilename());
                byte[] bytes=file.getBytes();
                BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(outFile));
                outputStream.write(bytes);
                outputStream.close();
                return "upload successful the path is "+outFile.getPath();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "failed because "+fileName+"file is empty";



    }

    //多文件上传(也包含单文件)
    @RequestMapping(value = "/multiFile",method = RequestMethod.POST)
    @ResponseBody
    public List<String>  multiFileUpload(MultipartRequest request, @RequestParam("orderCode") String orderCode) throws IllegalStateException,IOException {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        //建立根类的文件夹
        File rootDirectory = new File("rootFile\\" + orderCode);
        if (!rootDirectory.exists()) {
            rootDirectory.mkdirs();
        }

        List<String> listAddress = new ArrayList<>();
        for (int i = 0; i < files.size(); ++i) {
            MultipartFile file = files.get(i);
            String name = file.getOriginalFilename();

            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File outFile = new File(rootDirectory, name + i);
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(outFile));
                    listAddress.add(outFile.getPath());
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    return null;
                }
            } else {
                return null;
            }
        }
        return listAddress;
    }

    @RequestMapping(value = "/testupload" ,method = RequestMethod.POST)
    public String testupload(@RequestParam(value = "file" , required = true) MultipartFile file ) throws IOException {

        String rootdir="D:\\xystorage\\";

        File file1=new File(rootdir);
        if(!file1.exists()){
            file1.mkdirs();
        }

        if(file.isEmpty()){

            String filename=file.getOriginalFilename();

            File uploadfile=new File(rootdir,filename);

            byte[] bytes=file.getBytes();

            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(uploadfile));



            bufferedOutputStream.write(bytes);

            bufferedOutputStream.close();

            return uploadfile.getPath();
        }
        return "false";
    }



    }
