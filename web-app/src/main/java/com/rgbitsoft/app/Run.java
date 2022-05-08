package com.rgbitsoft.app;

import com.rgbitsoft.lib.utils.file.FileUtils;
import org.aspectj.util.FileUtil;

public class Run {
    public static void main(String[] args) {
        FileUtils fu = FileUtils.getInstance();
        String name = fu.getResource("/static/index.html").getFilename();
        System.out.println(name);
    }
}
