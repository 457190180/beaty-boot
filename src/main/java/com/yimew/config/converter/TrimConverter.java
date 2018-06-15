package com.yimew.config.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 类型转换 将空字符串转为null
 */
@Slf4j
@Configuration
@Component
public class TrimConverter implements Converter<String, String> {
    @Override
    public String convert(String source) {
        try {
            if (null != source) {
                source = source.trim();
                if (!"".equals(source)) {
                    return source;
                }
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }

}

