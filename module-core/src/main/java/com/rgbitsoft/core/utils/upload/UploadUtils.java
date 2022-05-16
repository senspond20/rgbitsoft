package com.rgbitsoft.core.utils.upload;

import com.rgbitsoft.core.exception.BadRequestException;
import com.rgbitsoft.core.utils.upload.channel.ChannelFactory;
import com.rgbitsoft.core.utils.upload.channel.FileUploadChannel;
import com.rgbitsoft.core.utils.upload.constans.UploadConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@DependsOn("springContextUtils")
public class UploadUtils {

    @Autowired
    private static RestTemplate restTemplate;

    private static FileUploadChannel uploadChannel;


    public void setRestTemplate(RestTemplate restTemplate) {
        UploadUtils.restTemplate = restTemplate;
    }

    @Value("local")
    public void setNotifyChannel(String channelName) {
        UploadUtils.uploadChannel = ChannelFactory.getChannel(channelName);
    }

    @AllArgsConstructor
    @Getter
    public static class ImageResource {
        byte[] data;
        String type;
    }

    public static String upload(ImageResource image) throws Exception {
        return uploadChannel.upload(image);
    }

    public static ImageResource getImageByRequest(String url) {
        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
        if (UploadConstants.IMAGE.equals(responseEntity.getHeaders().getContentType().getType())) {
            return new ImageResource(responseEntity.getBody(), responseEntity.getHeaders().getContentType().getSubtype());
        }
        throw new BadRequestException("response contentType unlike image");
    }
}