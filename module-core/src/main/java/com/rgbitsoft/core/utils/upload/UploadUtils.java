package com.rgbitsoft.core.utils.upload;

import com.rgbitsoft.core.exception.BadRequestException;
import com.rgbitsoft.core.utils.upload.channel.ChannelFactory;
import com.rgbitsoft.core.utils.upload.channel.FileUploadChannel;
import com.rgbitsoft.core.utils.upload.constans.UploadConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@DependsOn("springContextUtils")
@RequiredArgsConstructor
public class UploadUtils {
    private final FileUploadChannel uploadChannel;

    @AllArgsConstructor
    @Getter
    public static class ImageResource {
        byte[] data;
        String type;
    }

    public String upload(ImageResource image) throws Exception {
        return uploadChannel.upload(image);
    }

    public ImageResource getImageByRequest(String url) {
        ResponseEntity<byte[]> responseEntity = new RestTemplate().getForEntity(url, byte[].class);
        if (UploadConstants.IMAGE.equals(responseEntity.getHeaders().getContentType().getType())) {
            return new ImageResource(responseEntity.getBody(), responseEntity.getHeaders().getContentType().getSubtype());
        }
        throw new BadRequestException("response contentType unlike image");
    }
}