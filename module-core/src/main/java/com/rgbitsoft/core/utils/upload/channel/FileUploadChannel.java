package com.rgbitsoft.core.utils.upload.channel;

import com.rgbitsoft.core.utils.upload.UploadUtils;

public interface FileUploadChannel {

    String upload(UploadUtils.ImageResource image) throws Exception;
}