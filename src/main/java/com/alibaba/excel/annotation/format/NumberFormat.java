package com.alibaba.excel.annotation.format;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;

/**
 * 转换数字格式。
 *
 * <p>
 * 写: 它可以用于继承的类 {@link Number}
 * <p>
 * 读: 可用于类{@link String}
 *
 * @author Jiaju Zhuang
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface NumberFormat {

    /**
     *
     * 具体格式参考{@link java.text.DecimalFormat}
     *
     * @return 格式模式
     */
    String value() default "";

    /**
     * 默认四舍五入
     *
     * @return 舍入模式
     */
    RoundingMode roundingMode() default RoundingMode.HALF_UP;
}
