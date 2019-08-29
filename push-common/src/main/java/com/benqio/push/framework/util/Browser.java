package com.benqio.push.framework.util;

public class Browser {
    
    public static final String HttpAgent = "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36";
    
    public static String contentType(String extension) {
        switch (extension) {
        case "android":
            return "application/vnd.android.package-archive";
        case "ios":
            return "application/vnd.apple.pkpass";
        case "xlsx":
            return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        case "jpg":
        case "jpeg":
        case "gif":
        case "png":
        case "bmp":
            return "image/jpeg";
        default:
            return "text/html;charset=utf-8";
        }
    }
}