package com.sngular.nn.sandbox.service;

import ai.djl.inference.Predictor;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.mxnet.zoo.MxModelZoo;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import com.sngular.nn.sandbox.boot.SandboxProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
@Slf4j
public class ImageRecognitionService {

    private Predictor<Image, DetectedObjects> predictor;
    private ZooModel<Image, DetectedObjects> model;

    @Autowired
    private SandboxProperties properties;


    @SneakyThrows
    public ImageRecognitionService(){
        this.model = MxModelZoo.SSD.loadModel(new ProgressBar());
        this.predictor= model.newPredictor();
    }


    @SneakyThrows
    public void saveBoundedImage(Image image, String fileName){
        log.info("saving bounded image");
        DetectedObjects detection = predictor.predict(image);
        log.info("Detected:{}",detection);
        Image newImage = image.duplicate(Image.Type.TYPE_INT_ARGB);
        newImage.drawBoundingBoxes(detection);
        Path imagePath = Path.of(properties.getOutputDir(),fileName);
        newImage.save(Files.newOutputStream(imagePath), "png");
    }
}
