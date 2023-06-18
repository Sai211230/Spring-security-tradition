package com.sai.springsecurity;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sai.springsecurity.base.model.BaseEntity;
import com.sai.springsecurity.config.mybatis.ScisDbTypeConvert;

import java.util.ArrayList;
import java.util.List;

public class GeneratorCodeApplication {

    public static void main(String[] args) {
        genCodeByTables(
                "sys_user", // 最外面的包名
                "sys",               // 模块名,以 “.” 分隔
                new String[]{"sys_login_user_role"}, // 表名称
                "",                     // 表前缀
                IdType.AUTO,           // 主键策略
                DbType.MYSQL);          // 数据库类型
    }

    private static void genCodeByTables(String packageName, String codePackage, String[] tables, String tablePrefix, IdType idType,DbType dbType) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //当前路径
        String projectPath = System.getProperty("user.dir");
        String rootPath = projectPath + "/" + packageName;
        //输出路径
        gc.setOutputDir(rootPath + "/src/main/java");
        gc.setAuthor("SAI");    //设置作者
        gc.setSwagger2(true);
        //生成代码后，是否打开文件夹
        gc.setOpen(false);
        gc.setActiveRecord(false);   // 实体类继承Model
        gc.setFileOverride(true);   //是否覆盖原来代码，个人建议设置为false,别覆盖，危险系数太高
        gc.setBaseResultMap(true);  // 生成resultMap
        gc.setBaseColumnList(true); // 在xml中生成基础列
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setEntityName("%s");
        gc.setXmlName("%sMapper");
        // 时间类型默认为localdatetime此处修改为Date类型
//        gc.setDateType(DateType.ONLY_DATE);
        // 主键策略 INPUT
        gc.setIdType(idType);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/springsecurity?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(dbType);
        dsc.setTypeConvert(ScisDbTypeConvert.INSTANCE);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sai.springsecurity");
//        pc.setModuleName(codePackage);
        pc.setMapper(String.format("%s.infra.dao", codePackage));
        pc.setService(String.format("%s.infra.service", codePackage));
        pc.setServiceImpl(String.format("%s.infra.service.impl", codePackage));
        pc.setEntity(String.format("%s.infra.model.entity", codePackage));

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
//        String moduleName = pc.getModuleName();
//        String modulePath = moduleName.replace(".", File.separator);
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        //配置dao.xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出mapper文件名
                String entityName = tableInfo.getEntityName();
                String entityFileName = StrUtil.replace(entityName, "Entity", StringPool.EMPTY);
                String xmlPath = StrUtil.replace(codePackage, ".", StringPool.SLASH);
                return rootPath + "/resources/mapper/" + xmlPath + "/" + entityFileName + "Mapper" + StringPool.DOT_XML;
            }
        });

//        // 下面这行自定义Service类，因为自带模板的是Service接口+实现类，这里只想要Service类，不想要接口，所以自定义Service模板
//        String serviceTemplatePath = "/templates/vm/myService.java.vm";
//        // 自定义Service类
//        focList.add(new FileOutConfig(serviceTemplatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                String xmlPath = StrUtil.replace(codePackage, ".", StringPool.SLASH);
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return rootPath + "/src/main/java/com/sai/springsecurity/"+ xmlPath + "/infra/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
//
//            }
//        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 不生成 Controller
        templateConfig.disable(TemplateType.CONTROLLER, TemplateType.XML);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 配置数据表与实体类名之间映射的策略 (下划线到驼峰的命名方式)
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 配置数据表的字段与实体类的属性名之间映射的策略 (表名字段名使用下划线)
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 全局大写命名
//        strategy.setCapitalMode(true);
        //【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 配置 rest 风格的控制器（@RestController）
        strategy.setRestControllerStyle(false);
        // 需要生成的表
        strategy.setInclude(tables);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 表的前缀
        strategy.setTablePrefix(tablePrefix);
        // 设置实体属性注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 自动填充
        TableFill tableFill1 = new TableFill("create_time", FieldFill.INSERT);
        TableFill tableFill2= new TableFill("update_time", FieldFill.INSERT_UPDATE);
        TableFill tableFill3= new TableFill("create_by", FieldFill.INSERT);
        TableFill tableFill4= new TableFill("update_by", FieldFill.INSERT_UPDATE);
        List<TableFill> tableFillList = new ArrayList();
        tableFillList.add(tableFill1);
        tableFillList.add(tableFill2);
        tableFillList.add(tableFill3);
        tableFillList.add(tableFill4);
        strategy.setTableFillList(tableFillList);

        // 逻辑删除字段名
        strategy.setLogicDeleteFieldName("del_flag");

        // 父service类
//        strategy.setSuperServiceClass("com.sai.springsecurity.service.BaseService");
        // 父serviceimpl类
//        strategy.setSuperServiceImplClass("com.sai.springsecurity.service.impl.BaseServiceImpl");
//        // 父实体类
//        strategy.setSuperEntityClass("com.sai.springsecurity.base.model.BaseEntity");
//
//        // 父实体类字段
//        strategy.setSuperEntityColumns("id", "del_flag", "create_time", "create_by", "update_time", "update_by"); // 配置后，遇到此类属性自动忽略
        // 父dao类
//        strategy.setSuperMapperClass("com.sai.springsecurity.dao.BaseDao");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
