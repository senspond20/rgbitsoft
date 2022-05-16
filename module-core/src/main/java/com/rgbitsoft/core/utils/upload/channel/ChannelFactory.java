package com.rgbitsoft.core.utils.upload.channel;

import com.rgbitsoft.core.utils.SpringContextUtils;
import com.rgbitsoft.core.utils.upload.constans.UploadConstants;
import org.springframework.beans.factory.annotation.Autowired;

public class ChannelFactory {

    @Autowired
    private SpringContextUtils springContextUtils;

    public FileUploadChannel getChannel(String channelName) {
        if (UploadConstants.LOCAL.equalsIgnoreCase(channelName)) {
            return springContextUtils.getBean("localChannel", FileUploadChannel.class);
        } else if (UploadConstants.GITHUB.equalsIgnoreCase(channelName)) {
            return springContextUtils.getBean("githubChannel", FileUploadChannel.class);
        }
        throw new RuntimeException("Unsupported value in [application.properties]: [upload.channel]");
    }
}
