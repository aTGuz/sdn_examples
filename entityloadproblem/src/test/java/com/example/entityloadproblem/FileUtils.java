package com.example.entityloadproblem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static ObjectMapper mapper = new ObjectMapper();

    public static InputStream loadFile(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        return resource.getInputStream();
    }

    public static Object loadObjFromJSONFile(String path, Class clazz) throws IOException {
        InputStream inputStream = loadFile(path);
        return mapper.readValue(IOUtils.toString(inputStream, "UTF8"), clazz);
    }

    public static String loadStringFromJSONFile(String path) throws IOException {
        InputStream inputStream = loadFile(path);
        return IOUtils.toString(inputStream, "UTF8");
    }

    public static String loadJsonStringFromObj(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }
}
