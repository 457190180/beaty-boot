//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.filter;

import com.yimew.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpCacheFilter implements Filter {
    private static final Log logger = LogFactory.getLog(HttpCacheFilter.class);
    private long maxAge = 86400L;

    public HttpCacheFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        chain.doFilter(request, new AddExpiresHeaderResponse(response, this.maxAge));
    }

    public void init(FilterConfig config) throws ServletException {
        String maxAgeStr = config.getInitParameter("maxAge");
        if (StringUtils.isNotEmpty(maxAgeStr)) {
            this.maxAge = Long.valueOf(this.maxAge);
        }

    }
}
