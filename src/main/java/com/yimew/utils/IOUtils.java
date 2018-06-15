//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.utils;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils extends org.apache.commons.io.IOUtils {
    public IOUtils() {
    }

    public static byte[] readFully(InputStream is) throws IOException {
        byte[] bytes = new byte[is.available()];
        readFully(is, bytes);
        return bytes;
    }
}
