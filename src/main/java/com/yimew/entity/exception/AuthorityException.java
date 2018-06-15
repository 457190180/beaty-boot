package com.yimew.entity.exception;

/**
 * 自定义权限异常
 */
public class AuthorityException extends Exception {
    public AuthorityException(String msg) {
        super(msg);
    }

    public AuthorityException() {
        super();
    }
}