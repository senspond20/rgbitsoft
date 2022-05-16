package com.rgbitsoft.core.utils.upload.channel;

import com.rgbitsoft.core.utils.upload.UploadUtils;
import com.rgbitsoft.core.properties.upload.WebUrlProperties;
import com.rgbitsoft.core.properties.upload.UploadProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Lazy
@Component
@RequiredArgsConstructor
public class LocalChannel implements FileUploadChannel {

    private final WebUrlProperties webUrlProperties;
    private final UploadProperties uploadProperties;

    @Override
    public String upload(UploadUtils.ImageResource image) throws Exception {
        File folder = new File(uploadProperties.getPath());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String fileName = UUID.randomUUID() + "." + image.getType();
        FileOutputStream fileOutputStream = new FileOutputStream(uploadProperties.getPath() + fileName);
        fileOutputStream.write(image.getData());
        fileOutputStream.close();
        return webUrlProperties.getApi() + "/image/" + fileName;
    }
}