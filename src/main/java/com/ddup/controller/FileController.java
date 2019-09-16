package com.ddup.controller;

import com.ddup.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO uoload(){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/test.png");
        return fileDTO;
    }
}
