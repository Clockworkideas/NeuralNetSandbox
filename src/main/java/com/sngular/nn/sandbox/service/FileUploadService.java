package com.sngular.nn.sandbox.service;

import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import com.sngular.nn.sandbox.boot.SandboxProperties;
import com.sngular.nn.sandbox.http.v1.FileInfo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FileUploadService {


    private final ImageRecognitionService imageRecognitionService;
    private final SandboxProperties sandboxProperties;

    @SneakyThrows
    public String putFile(MultipartFile file) {
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path target= Paths.get(sandboxProperties.getUploadDir(),originalFileName).toAbsolutePath().normalize();
        Files.copy(file.getInputStream(),target,StandardCopyOption.REPLACE_EXISTING);
        Image image= ImageFactory.getInstance().fromInputStream(file.getInputStream());
        imageRecognitionService.saveBoundedImage(image,file.getOriginalFilename());
        return originalFileName;
    }

    public List<FileInfo> listFiles(){
       File outputDir=new File(sandboxProperties.getOutputDir());

       List<FileInfo> files= Arrays.stream(outputDir.listFiles()).map(f->
               FileInfo.builder()
                       .fileName(f.getName())
                       .url(sandboxProperties.getHost()+"/output/"+f.getName())
                       .build()).collect(Collectors.toList());
       return files;
    }

    public File fetchFile(String fileName) {
        Path target= Paths.get(sandboxProperties.getUploadDir(),fileName).toAbsolutePath().normalize();
        return target.toFile();
    }

}
