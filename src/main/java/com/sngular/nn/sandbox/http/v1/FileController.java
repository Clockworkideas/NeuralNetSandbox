package com.sngular.nn.sandbox.http.v1;


import com.sngular.nn.sandbox.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/files")
@Slf4j
public class FileController {

    private final FileUploadService fileUploadService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        log.info("Uploading file {}",file);
        return fileUploadService.putFile(file);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    List<FileInfo> getFileList(){
        return fileUploadService.listFiles();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @RequestMapping("/{fileName}")
    File fetchFile(@PathVariable String fileName){
        return fileUploadService.fetchFile(fileName);
    }


}
