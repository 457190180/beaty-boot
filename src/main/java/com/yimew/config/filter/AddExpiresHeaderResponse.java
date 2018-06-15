//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.filter;

import java.util.Arrays;
import java.util.Calendar;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class AddExpiresHeaderResponse extends HttpServletResponseWrapper {
    private static final String[] CACHEABLE_CONTENT_TYPES = new String[]{"text/css", "text/javascript", "application/javascript", "image/png", "image/jpeg", "image/gif", "image/jpg"};
    private long maxAge = 0L;

    public AddExpiresHeaderResponse(HttpServletResponse response, long maxAge) {
        super(response);
        this.maxAge = maxAge;
    }

    public void setContentType(String contentType) {
        if (contentType != null && Arrays.binarySearch(CACHEABLE_CONTENT_TYPES, contentType) > -1) {
            Calendar inTwoMonths = Calendar.getInstance();
            inTwoMonths.add(2, 2);
            super.setDateHeader("Expires", inTwoMonths.getTimeInMillis());
            super.setHeader("Cache-Control", "max-age=" + this.maxAge);
        } else {
            super.setHeader("Expires", "-1");
            super.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        }

        super.setContentType(contentType);
    }

    static {
        Arrays.sort(CACHEABLE_CONTENT_TYPES);
    }
}
