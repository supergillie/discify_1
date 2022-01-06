    package com.example.myapplication.controller;

    import javax.servlet.ServletContext;

    import org.apache.commons.io.FilenameUtils;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.io.File;
    import java.io.FileInputStream;
    import java.util.ArrayList;
    import java.util.Base64;
    import java.util.List;

    @RestController
    public class SpringAngularFileController {

        @Autowired ServletContext context;

        @RequestMapping(value="/getImages")
        @CrossOrigin
        public ResponseEntity<List<String>> getImages() {
            System.out.println("End Point hit");
            List<String> images = new ArrayList<String>();
            String filesPath = context.getRealPath("/images");
            File fileFolder = new File(filesPath);
            if(fileFolder!=null){
                for(final File file : fileFolder.listFiles()) {
                    if(!file.isDirectory()){
                        String encodeBase64 = null;
                        try {
                            String extension = FilenameUtils.getExtension(file.getName());
                            FileInputStream fileInputStream  = new FileInputStream(file);
                            byte bytes[] = new byte[(int)file.length()];
                            fileInputStream.read(bytes);
                            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                            images.add("data:image/"+extension+";base64," +encodeBase64);
                            fileInputStream.close();
                        }
                        catch (Exception e){
                        }
                    }
                }
            }
            return new ResponseEntity<List<String>>(images, HttpStatus.OK);
        }
    }
     


