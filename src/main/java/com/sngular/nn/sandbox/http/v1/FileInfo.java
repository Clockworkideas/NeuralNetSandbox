package com.sngular.nn.sandbox.http.v1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileInfo {

    private String fileName;
    private String url;
    private String predictionInfo;

}
