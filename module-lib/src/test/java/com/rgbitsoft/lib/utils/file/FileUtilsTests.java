package com.rgbitsoft.lib.utils.file;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class FileUtilsTests {

    @Test
    void test(){
        DefaultResourceLoader loader =  new DefaultResourceLoader();
        Resource resource = loader.getResource("/data/test.txt");
        System.out.println(resource);

        System.out.println(resource.getFilename());

    }
}
