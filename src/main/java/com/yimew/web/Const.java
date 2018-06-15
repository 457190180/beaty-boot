package com.yimew.web;

public class Const {

    /**
     * 私有构造无法创建对象
     */
    private Const() {
    }

    public  interface CODE {
        /**
         * 成功
         */
        Integer SUCCESS = 200;
        /**
         * 失败
         */
        Integer FAIL = 210;
        /**
         * 服务器内部错误
         */
        Integer SERVER_ERROR = 500;
        /**
         * 参数错误
         */
        Integer PARAM_ERROR = 150;
        /**
         * 数据已存在
         */
        Integer HAS_EXISTED = 160;

        /**
         * 数据不存在
         */
        Integer NOT_EXISTED = 170;

        /**
         * 登录验证错误
         */
        Integer LOGIN_FAIL = 180;
    }

    public static final String ILLEGAL_EXPENDNAME_LIST =".js.bat.exe.sh.html.css.htm.jsp.php.asp.net";

    /**
     * 数据库信息
     *
     * @author 45719
     */
    public static interface JDBC_INFO {
        String URL = "jdbc:oracle:thin:@192.168.0.116:1521:ORCL";
        String USERNAME = "BTIS";
        String PASSWORD = "btis";
    }


    /**
     * redis密码
     */
    public static final String REDIS_PASSWORD = "6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9";

    public static final String REIDS_APPLICAT_KEY = "stucard_";


    public interface ROLE {
        String ADMIN ="1";
        String STUDENT ="3";
        String TEACHER ="2";
    }
    /**
     * 分隔符
     */
    public final static String SPLIT_CODE = ",";

    /**
     * 用户类型
     *
     * @author 45719
     */
    public enum USER_TYPE {
        NORMALUSER(1), OPERATER(2), ADMIN(3);
        int code;

        private USER_TYPE(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }


    public enum HEADER_KEY {
        USERCODE("userCode"), TOKEN("token");
        String code;

        private HEADER_KEY(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * jedis中存储使用key
     */
    public enum JEDIS_KEY {
        ACCESS_TOKEN(APPID + "_ACCESSTOKEN");

        String key;

        private JEDIS_KEY(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }


    /**
     * 系统中所有状态使用
     */
    public interface STATE {
        Integer NORMAL = 1;
        Integer ABNORMAL = 2;

    }

    /**
     * 审核状态
     */
    public interface APPROVE_STATE {
        Integer APPROVING1 = 1;
        Integer APPROVED = 2;
        Integer NOAPPROVE = 3;

    }


    /**
     * 小程序appid
     */
    public static final String APPID = "wxc155b24aeb340c14";

    /**
     * 小程序secret
     */
    public static final String APP_SECRET = "0b921a8279ae56f591f0678fd6879808";


    public static interface WEICHAT {
        String PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

        Integer BUSINESS_STORE_CODE = 1492731772;

        String API_SECRET = "2b73f76bcbdc4339bc5cf03db32d055e";

        String TEMPLATE_ID = "joxV33aO2N3K9kEXuXHlZRr20DM2MbjE1c5FTuCX8AY";

        String PAGE = "/pages/index/index";
    }


}