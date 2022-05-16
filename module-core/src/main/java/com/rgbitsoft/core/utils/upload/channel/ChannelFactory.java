package com.rgbitsoft.core.utils.upload.channel;

import com.rgbitsoft.core.utils.SpringContextUtils;
import com.rgbitsoft.core.utils.upload.constans.UploadConstants;

public class ChannelFactory {

    public static FileUploadChannel getChannel(String channelName) {
        if (UploadConstants.LOCAL.equalsIgnoreCase(channelName)) {
            return SpringContextUtils.getBean("localChannel", FileUploadChannel.class);
        } else if (UploadConstants.GITHUB.equalsIgnoreCase(channelName)) {
            return SpringContextUtils.getBean("githubChannel", FileUploadChannel.class);
        }
        throw new RuntimeException("Unsupported value in [application.properties]: [upload.channel]");
    }
}
