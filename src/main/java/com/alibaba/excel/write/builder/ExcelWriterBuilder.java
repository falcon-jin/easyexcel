package com.alibaba.excel.write.builder;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteWorkbook;

/**
 * excel写构建器
 *
 * @author Jiaju Zhuang
 */
public class ExcelWriterBuilder extends AbstractExcelWriterParameterBuilder<ExcelWriterBuilder, WriteWorkbook> {
    /**
     * Workbook
     */
    private WriteWorkbook writeWorkbook;

    public ExcelWriterBuilder() {
        this.writeWorkbook = new WriteWorkbook();
    }

    /**
     * 默认自动关闭流
     *
     * @param autoCloseStream
     * @return
     */
    public ExcelWriterBuilder autoCloseStream(Boolean autoCloseStream) {
        writeWorkbook.setAutoCloseStream(autoCloseStream);
        return this;
    }

    /**
     * 是否加密。
     *
     * 警告：加密是将整个文件读入内存，因此非常占用内存。
     *
     * @param password 密码
     * @return
     */
    public ExcelWriterBuilder password(String password) {
        writeWorkbook.setPassword(password);
        return this;
    }

    /**
     * 在内存中写excel。默认false，缓存文件被创建并最终写入excel。
     * <p>
     * Comment 和 RichTextString 仅在内存模式下受支持。
     */
    public ExcelWriterBuilder inMemory(Boolean inMemory) {
        writeWorkbook.setInMemory(inMemory);
        return this;
    }

    /**
     * Excel也会在抛出异常的情况下写入。默认为false。
     */
    public ExcelWriterBuilder writeExcelOnException(Boolean writeExcelOnException) {
        writeWorkbook.setWriteExcelOnException(writeExcelOnException);
        return this;
    }

    /**
     * 默认 true
     * true: 将传入的excel数据类对象所有字段(没有加{@link com.alibaba.excel.annotation.ExcelIgnore}注解的)都导出
     * false： 只导出加了 {@link com.alibaba.excel.annotation.ExcelProperty}注解的字段
     * @param convertAllFiled
     * @return
     * @deprecated 只是为了与历史数据兼容，默认总是要转换所有文件。
     */
    @Deprecated
    public ExcelWriterBuilder convertAllFiled(Boolean convertAllFiled) {
        writeWorkbook.setConvertAllFiled(convertAllFiled);
        return this;
    }

    public ExcelWriterBuilder excelType(ExcelTypeEnum excelType) {
        writeWorkbook.setExcelType(excelType);
        return this;
    }

    public ExcelWriterBuilder file(OutputStream outputStream) {
        writeWorkbook.setOutputStream(outputStream);
        return this;
    }

    public ExcelWriterBuilder file(File outputFile) {
        writeWorkbook.setFile(outputFile);
        return this;
    }

    public ExcelWriterBuilder file(String outputPathName) {
        return file(new File(outputPathName));
    }

    public ExcelWriterBuilder withTemplate(InputStream templateInputStream) {
        writeWorkbook.setTemplateInputStream(templateInputStream);
        return this;
    }

    public ExcelWriterBuilder withTemplate(File templateFile) {
        writeWorkbook.setTemplateFile(templateFile);
        return this;
    }

    public ExcelWriterBuilder withTemplate(String pathName) {
        return withTemplate(new File(pathName));
    }

    /**
     * 写处理程序
     *
     * @deprecated please use {@link WriteHandler}
     */
    @Deprecated
    public ExcelWriterBuilder registerWriteHandler(com.alibaba.excel.event.WriteHandler writeHandler) {
        writeWorkbook.setWriteHandler(writeHandler);
        return this;
    }

    public ExcelWriter build() {
        return new ExcelWriter(writeWorkbook);
    }

    public ExcelWriterSheetBuilder sheet() {
        return sheet(null, null);
    }

    public ExcelWriterSheetBuilder sheet(Integer sheetNo) {
        return sheet(sheetNo, null);
    }

    public ExcelWriterSheetBuilder sheet(String sheetName) {
        return sheet(null, sheetName);
    }

    public ExcelWriterSheetBuilder sheet(Integer sheetNo, String sheetName) {
        ExcelWriter excelWriter = build();
        ExcelWriterSheetBuilder excelWriterSheetBuilder = new ExcelWriterSheetBuilder(excelWriter);
        if (sheetNo != null) {
            excelWriterSheetBuilder.sheetNo(sheetNo);
        }
        if (sheetName != null) {
            excelWriterSheetBuilder.sheetName(sheetName);
        }
        return excelWriterSheetBuilder;
    }

    @Override
    protected WriteWorkbook parameter() {
        return writeWorkbook;
    }
}
