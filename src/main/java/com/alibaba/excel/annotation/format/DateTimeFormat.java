package com.alibaba.excel.annotation.format;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 转换日期格式。
 *
 *  读：可以加在java.util.Date类型的字段上
 * 写: 可以加在String类型的字段上
 *
 * @author Jiaju Zhuang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DateTimeFormat {

    /**
     *
     * 具体格式参考 {@link java.text.SimpleDateFormat}
     *
     * @return 格式模式
     */
    String value() default "";

    /**
     * 如果日期使用 1904 年窗口，则为 true，如果使用 1900 日期窗口，则为 false。
     *
     * @return 如果日期使用 1904 年窗口，则为 true，如果使用 1900 日期窗口，则为 false。
     */
    boolean use1904windowing() default false;
}
