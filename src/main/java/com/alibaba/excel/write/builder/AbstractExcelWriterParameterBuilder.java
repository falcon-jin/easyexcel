package com.alibaba.excel.write.builder;

import java.util.ArrayList;
import java.util.Collection;

import com.alibaba.excel.metadata.AbstractParameterBuilder;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteBasicParameter;

/**
 * excel写构建器抽象父类
 *
 * @author Jiaju Zhuang
 */
public abstract class AbstractExcelWriterParameterBuilder<T extends AbstractExcelWriterParameterBuilder,
    C extends WriteBasicParameter> extends AbstractParameterBuilder<T, C> {
    /**
     * 相对于工作表的现有内容写入头部。索引从零开始。
     *
     * @param relativeHeadRowIndex
     * @return
     */
    public T relativeHeadRowIndex(Integer relativeHeadRowIndex) {
        parameter().setRelativeHeadRowIndex(relativeHeadRowIndex);
        return self();
    }

    /**
     * 需要头
     */
    public T needHead(Boolean needHead) {
        parameter().setNeedHead(needHead);
        return self();
    }

    /**
     * 自定义写入处理程序
     *
     * @param writeHandler
     * @return
     */
    public T registerWriteHandler(WriteHandler writeHandler) {
        if (parameter().getCustomWriteHandlerList() == null) {
            parameter().setCustomWriteHandlerList(new ArrayList<WriteHandler>());
        }
        parameter().getCustomWriteHandlerList().add(writeHandler);
        return self();
    }

    /**
     * 使用默认样式。默认为true。
     *
     * @param useDefaultStyle
     * @return
     */
    public T useDefaultStyle(Boolean useDefaultStyle) {
        parameter().setUseDefaultStyle(useDefaultStyle);
        return self();
    }

    /**
     * 是否自动合并headers。默认为true。
     *
     * @param automaticMergeHead
     * @return
     */
    public T automaticMergeHead(Boolean automaticMergeHead) {
        parameter().setAutomaticMergeHead(automaticMergeHead);
        return self();
    }

    /**
     * 忽略自定义列。
     */
    public T excludeColumnIndexes(Collection<Integer> excludeColumnIndexes) {
        parameter().setExcludeColumnIndexes(excludeColumnIndexes);
        return self();
    }

    /**
     * 忽略自定义列。
     */
    public T excludeColumnFiledNames(Collection<String> excludeColumnFiledNames) {
        parameter().setExcludeColumnFiledNames(excludeColumnFiledNames);
        return self();
    }

    /**
     * 只输出自定义列。
     */
    public T includeColumnIndexes(Collection<Integer> includeColumnIndexes) {
        parameter().setIncludeColumnIndexes(includeColumnIndexes);
        return self();
    }

    /**
     * 只输出自定义列。
     */
    public T includeColumnFiledNames(Collection<String> includeColumnFiledNames) {
        parameter().setIncludeColumnFiledNames(includeColumnFiledNames);
        return self();
    }

}
