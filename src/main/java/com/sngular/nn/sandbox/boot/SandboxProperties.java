package com.sngular.nn.sandbox.boot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "com.sngular.sandbox")
public class SandboxProperties {
    private String uploadDir;
    private String modelDir;
    private String outputDir;
    private String host;
}
