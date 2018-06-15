//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.filter.xss;

import com.yimew.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class XssFilter implements Filter {
    private static final Log logger = LogFactory.getLog(XssFilter.class);
    private List<String> excludeUrls = new ArrayList();
    private List<String> noticeUrls = new ArrayList();

    public XssFilter() {
    }

    public void init(FilterConfig filterconfig1) throws ServletException {
        String path = XssFilter.class.getResource("/").getFile();
        this.excludeUrls = FileUtil.readAsStringList(path + "white/xssWhite.txt");
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
        String url = req.getServletPath() + pathInfo;
        String uri = req.getRequestURI();
        boolean isNoticeUrl = false;
        Iterator i$ = this.excludeUrls.iterator();

        String paramN;
        while(i$.hasNext()) {
            paramN = (String)i$.next();
            if (uri.indexOf(paramN) >= 0) {
                logger.info("该URL不作校验：" + url);
                arg2.doFilter(req, response);
                return;
            }
        }

        i$ = this.noticeUrls.iterator();

        while(i$.hasNext()) {
            paramN = (String)i$.next();
            if (uri.indexOf(paramN) >= 0) {
                isNoticeUrl = true;
                break;
            }
        }

        Enumeration<?> params = req.getParameterNames();
        paramN = null;

        String paramVale;
        do {
            if (!params.hasMoreElements()) {
                arg2.doFilter(req, response);
                return;
            }

            paramN = (String)params.nextElement();
            paramVale = req.getParameter(paramN);
            if (!paramN.toLowerCase().contains("password")) {
                logger.info(paramN + "==" + paramVale);
            }

            if (isNoticeUrl) {
                paramVale = this.xssEncode(paramVale);
            }
        } while(!this.checkSQLInject(paramVale, url));

        this.errorResponse(response, paramN);
    }

    private void errorResponse(HttpServletResponse response, String paramNm) throws IOException {
        String warning = "输入项中不能包含非法字符。";
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("{\"code\":\"-9998\",\"msg\":\"" + warning + "\", \"fieldName\": \"" + paramNm + "\"}");
        out.flush();
        out.close();
    }

    public void destroy() {
    }

    private String xssEncode(String s) {
        if (s != null && !s.isEmpty()) {
            StringBuilder sb = new StringBuilder(s.length() + 16);

            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                switch(c) {
                case '"':
                    sb.append('“');
                    break;
                case '#':
                    sb.append('＃');
                    break;
                case '&':
                    sb.append('＆');
                    break;
                case '\'':
                    sb.append('‘');
                    break;
                case '(':
                    sb.append('（');
                    break;
                case ')':
                    sb.append('）');
                    break;
                case '<':
                    sb.append('＜');
                    break;
                case '>':
                    sb.append('＞');
                    break;
                case '\\':
                    sb.append('＼');
                    break;
                default:
                    sb.append(c);
                }
            }

            return sb.toString();
        } else {
            return s;
        }
    }

    private boolean checkSQLInject(String str, String url) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            String[] inj_stra = new String[]{"script", "mid", "master", "truncate", "insert", "select", "delete", "update", "declare", "iframe", "'", "onreadystatechange", "alert", "atestu", "xss", ";", "'", "\"", "<", ">", "(", ")", ",", "\\", "svg", "confirm", "prompt", "onload", "onmouseover", "onfocus", "onerror"};
            str = str.toLowerCase();

            for(int i = 0; i < inj_stra.length; ++i) {
                if (str.indexOf(inj_stra[i]) >= 0) {
                    logger.info("xss防攻击拦截url:" + url + "，原因：特殊字符，传入str=" + str + ",包含特殊字符：" + inj_stra[i]);
                    return true;
                }
            }

            return false;
        }
    }
}
