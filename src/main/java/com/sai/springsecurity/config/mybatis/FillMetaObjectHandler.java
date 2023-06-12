package com.sai.springsecurity.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author SAI
 * @create 2023-06-12
 */
@Component
public class FillMetaObjectHandler implements MetaObjectHandler {

    // 数据自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
//        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
//        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
//        final String userNmae = LoginUserHolder.getUserCode();
//        if (!Strings.isNullOrEmpty(userCode)) {
//            this.setFieldValByName("createUserCode", userCode, metaObject);
//            this.setFieldValByName("updateUserCode", userCode, metaObject);
//        }
//        final String userName = LoginUserHolder.getUserName();
//        if (!Strings.isNullOrEmpty(userName)) {
//            this.setFieldValByName("createName", userName, metaObject);
//            this.setFieldValByName("updateName", userName, metaObject);
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
//        final String userCode = LoginUserHolder.getUserCode();
//        if (!Strings.isNullOrEmpty(userCode)) {
//            this.setFieldValByName("updateUserCode", userCode, metaObject);
//        }
//        final String userName = LoginUserHolder.getUserName();
//        if (!Strings.isNullOrEmpty(userName)) {
//            this.setFieldValByName("updateName", userName, metaObject);
//        }
    }
}
