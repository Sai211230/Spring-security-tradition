package com.sai.springsecurity.config.mybatis;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

import static com.baomidou.mybatisplus.generator.config.rules.DbColumnType.*;

/**
 * @author SAI
 * @create 2022-08-30
 */
public class ScisDbTypeConvert implements ITypeConvert {

    public static final ScisDbTypeConvert INSTANCE    = new ScisDbTypeConvert();
    public static final String            DATA_LEN_RE = "(?<=\\()[^\\)]+";

    @Override
    public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
        String fieldDataType = fieldType.toLowerCase();
        if (StrUtil.startWith(fieldDataType, "bigint")) {
//            return toNumberType(fieldDataType);
            return DbColumnType.LONG;

        }
        if (StrUtil.startWithIgnoreCase(fieldDataType, "tinyint")) {
//            return toNumberType(fieldDataType);
            return DbColumnType.INTEGER;
        }
        if (StrUtil.startWithIgnoreCase(fieldDataType, "int")) {
//            return toNumberType(fieldDataType);
            return DbColumnType.INTEGER;
        }
        if (StrUtil.startWith(fieldDataType, "smallint")) {
//            return toNumberType(fieldDataType);
            return DbColumnType.INTEGER;
        }
        if (StrUtil.startWith(fieldDataType, "decimal")) {
//            return toNumberType(fieldDataType);
            return DbColumnType.BIG_DECIMAL;
        }
        if (StrUtil.startWith(fieldDataType, "number")) {
//            return toNumberType(fieldDataType);
            return DbColumnType.BIG_DECIMAL;
        }
        if (StrUtil.startWithAny(fieldDataType, "char", "clob", "varchar", "text", "long text")) {
            return STRING;
        }
        if (StrUtil.startWithAny(fieldDataType, "date", "timestamp")) {
            return toDateType(config);
        }
        if (StrUtil.startWithAny(fieldDataType, "blob")) {
            return BLOB;
        }
        if (StrUtil.startWithAny(fieldDataType, "binary", "raw")) {
            return BYTE_ARRAY;
        }
        return STRING;
    }

    protected static IColumnType toDateType(GlobalConfig config) {
        switch (config.getDateType()) {
            case ONLY_DATE:
                return DbColumnType.DATE;
            case SQL_PACK:
                return DbColumnType.TIMESTAMP;
            case TIME_PACK:
                return DbColumnType.LOCAL_DATE_TIME;
            default:
                return STRING;
        }
    }
}
