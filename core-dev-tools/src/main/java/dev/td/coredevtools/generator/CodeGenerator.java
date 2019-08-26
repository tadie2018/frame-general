package dev.td.coredevtools.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import dev.td.coredevtools.constant.DBConstant;

import java.util.HashMap;
import java.util.Objects;

public class CodeGenerator {
    public CodeGenerator() {
    }

    /**
     * 需要生成的表名
     *
     * @param tableNames
     */
    private String[] tableNames;

    public CodeGenerator(String...tableNames) {
        this.tableNames = tableNames;
    }

    public void execute() {
        //当前项目源码放置路径
        String currentProjectSourceDir = System.getProperty("user.dir") + "\\core-dev-tools\\src\\main\\java";
        //实例化代码生成
        AutoGenerator autoGenerator = new AutoGenerator();

        //配置代码生成器
        //1、全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //设置需要生成的代码的输出位置(自然是上边的项目源码所在路径)
        globalConfig.setOutputDir(currentProjectSourceDir);
        //设置作者信息
        globalConfig.setAuthor("zEidat");
        //设置是否打开输出目录（自动打开文件夹显示代码生成为位置）
        globalConfig.setOpen(false);
        //时间对应策略 java.util.Date()，默认是java.time
        globalConfig.setDateType(DateType.ONLY_DATE);
        //开启AR模式（自动继承Model类）
        globalConfig.setActiveRecord(true);
        //swagger2模式（接口自动添加生成文档注解）这个建议不要开启了因为目前只有entity上有 还要自己写swagger2Config
        globalConfig.setSwagger2(false);
        //是否覆盖已有的文件
        globalConfig.setFileOverride(false);
        //自定义各层文件命名方式
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setXmlName("%sMapper.map");
        //激活全局配置
        autoGenerator.setGlobalConfig(globalConfig);

        //2、配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //设置数据库信息
        dataSourceConfig.setDriverName(DBConstant.DRIVER_CLASS_NAME);
        dataSourceConfig.setUrl(DBConstant.JDBC_URL);
        dataSourceConfig.setUsername(DBConstant.USER_NAME);
        dataSourceConfig.setPassword(DBConstant.PASSWORD);
        //手动设置SQL SERVER数据类型 源码中没有对SQL SERVER数据库进行判断
        //如果SQL SERVER 数据库版本是2005 则使用DbType.SQL_SERVER2005枚举
        dataSourceConfig.setDbType(DBConstant.DB_TYPE);
        //激活数据源配置
        autoGenerator.setDataSource(dataSourceConfig);

        //3、包配置
        PackageConfig packageConfig = new PackageConfig();
        //模块名(每个模块下可以生成一套从实体到控制层的包)
        packageConfig.setModuleName("cdag4cut");
        //模块下面的包名 例如：想要生成的代码在com.dudouozb.excelopt下生成 就这么配置
        packageConfig.setParent("dev.td.coredevtools");
        //激活包配置
        autoGenerator.setPackageInfo(packageConfig);

        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置生成的文件名称 驼峰命名 数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //数据库表[字段]映射到实体的命名策略 未设置则和Naming一致
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //开启lombok模式（使用工具生成常用方法等）
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);
        //设置需要生成的表的表名。和exclude（排除表）只能选其一
        strategyConfig.setInclude(tableNames);
        //使用内置的freemarker模板引擎，也可以自定义，不配置默认使用velocity
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        //原来没事，新版本的不设置这个会抛出空指针异常
        autoGenerator.setCfg(new InjectionConfig() {
            @Override
            public void initMap() {
                this.setMap(new HashMap<String,Object>(){{}});
            }
        });
        //执行生成
        autoGenerator.execute();
    }
}
