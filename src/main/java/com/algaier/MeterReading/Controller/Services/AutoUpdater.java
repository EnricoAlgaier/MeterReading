package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Model.Update;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AutoUpdater {
    private static final String UPDATE_CHECK_URL = "https://example.com/software/latest-version";
    private static final String CURRENT_VERSION = "1.0.0";
    private final File jsonPath = new File("src/main/resources/update-config.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AutoUpdater(){
            readJsonFile();
    }

    private void readJsonFile() {
        try {

            Update updateInfo = objectMapper.readValue(jsonPath, Update.class);



            System.out.println(updateInfo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}