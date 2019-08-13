package com.gl.website.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("uploadingUtil")
public class UploadingUtil {
    private final String[]  fileName={"jpeg","bmp","jpg","png","tif","gif","pcx","tga","exif","fpx","svg","psd","cdr","pcd","dxf","ufo","eps","ai","raw","WMF","webp"};

    //获取上传路径
    public static  String  pathConfirm(){
        String os = System.getProperty("os.name");
            if(os.toLowerCase().startsWith("win")){
                //是windown 系统
                File file=new File("c:"+File.separator+"image");
                if(!file.exists()) {
                    file.mkdirs();
                }
                return "c:"+File.separator+"image"+File.separator;
            }else {
                //是linux系统
                File  file=new File(File.separator+"home"+File.separator+"image");
                if(!file.exists()) {
                    file.mkdirs();
                }
                return File.separator+"home"+File.separator+"image"+File.separator;
            }
    }

    public String uploaDing(MultipartFile paper){
        String path = this.pathConfirm();
        String paperName = paper.getOriginalFilename();
         if(paper!=null && paperName.length()>0 && paperName.indexOf(".")!=-1 ){
             String substring = paperName.substring(paperName.lastIndexOf("."));
             for(String  s:fileName ){
                 if(substring.equalsIgnoreCase("."+s)){
                     //有相同的
                     String uuid=UUID.randomUUID().toString();
                     String newFileName = path+uuid+substring;
                     File newFile = new File(newFileName);
                     try {
                         paper.transferTo(newFile);
                         return "/local/"+uuid+substring;

                     } catch (IOException e) {
                         e.printStackTrace();
                     }finally {

                     }
                 }
             }
         }
         return null;
    }


}
