package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileuploadController {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile,
                                   @RequestParam String singleFileDescription,
                                   Model model) throws IOException {

        System.out.println("singleFile = " + singleFile);
        System.out.println("singleFileDescription = " + singleFileDescription);

        /* 파일을 저장할 경로 설정 */
        Resource resource = resourceLoader.getResource("classpath:static/img/single");

        String filePath = null;

        if(!resource.exists()) {
            /* 만약 static 폴더에 파일이 없는 경우 만들어준다. */
            String root = "src/main/resources/static/img/single";
            File file = new File(root);

            file.mkdirs();

            filePath = file.getAbsolutePath();
        } else {
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
        }

        /* 파일명 변경 처리 */
        String originFileName = singleFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);

        /* 확장자 제거 */
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        System.out.println("ext = " + ext);

        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("savedName = " + savedName);

        /* 파일을 저장 */

            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 성공!!!!");
            model.addAttribute("img", "static/img/single/" + savedName);
        return "result";
    }

}
