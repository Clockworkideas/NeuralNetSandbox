package com.sngular.nn.sandbox.http.v1;

import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import com.sngular.nn.sandbox.service.ImageRecognitionService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    private final ImageRecognitionService imageRecognitionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @SneakyThrows
    public void postImage(@RequestParam("file") MultipartFile file){
            Image image= ImageFactory.getInstance().fromInputStream(file.getInputStream());
            imageRecognitionService.saveBoundedImage(image,file.getName());

    }
}
