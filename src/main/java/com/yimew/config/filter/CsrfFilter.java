//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.filter;

import com.yimew.utils.FileUtil;
import com.yimew.utils.RequestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CsrfFilter implements Filter {
    private static final Log logger = LogFactory.getLog(CsrfFilter.class);
    private List<String> whiteUrls;
    private int _size = 0;

    public CsrfFilter() {
    }

    public void init(FilterConfig filterConfig) {
        String path = CsrfFilter.class.getResource("/").getFile();
        this.whiteUrls = FileUtil.readAsStringList(path + "white/csrfWhite.txt");
        this._size = null == this.whiteUrls ? 0 : this.whiteUrls.size();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse res = (HttpServletResponse)response;
            String url = req.getRequestURL().toString();
            String referurl = req.getHeader("Referer");
            if (!this.isWhiteReq(referurl)) {
                req.getRequestDispatcher("/").forward(req, res);
                String log = "";
                String date = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
                String clientIp = RequestUtils.getClientIp(req);
                log = "跨站请求---->>>" + clientIp + "||" + date + "||" + referurl + "||" + url;
                logger.warn(log);
                return;
            }

            chain.doFilter(request, response);
        } catch (Exception var11) {
            logger.error("doFilter", var11);
        }

    }

    private boolean isWhiteReq(String referUrl) {
        if (referUrl != null && !"".equals(referUrl) && this._size != 0) {
            String refHost = "";
            referUrl = referUrl.toLowerCase();
            if (referUrl.startsWith("http://")) {
                refHost = referUrl.substring(7);
            } else if (referUrl.startsWith("https://")) {
                refHost = referUrl.substring(8);
            }

            Iterator i$ = this.whiteUrls.iterator();

            String urlTemp;
            do {
                if (!i$.hasNext()) {
                    return false;
                }

                urlTemp = (String)i$.next();
            } while(refHost.indexOf(urlTemp.toLowerCase()) <= -1);

            return true;
        } else {
            return true;
        }
    }

    public void destroy() {
    }
}
