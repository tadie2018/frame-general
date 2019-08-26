package dev.td.coredevtools.constant;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * 数据库常量类（mysql)
 * 常量类不可更改，无需注入
 * 禁止作为变量类添加属性使用get、set操作
 */
public class DBConstant {
    /**
     * 数据库类型
     */
    public static final DbType DB_TYPE = DbType.MYSQL;
    /**
     * 驱动包
     */
    public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    /**
     * 数据库地址
     */
    public static final String JDBC_URL = "jdbc:mysql://localhost/framework_base?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai";
    /**
     * 数据库登录名
     */
    public static final String USER_NAME = "root";
    /**
     * 数据库登录密码
     */
    public static final String PASSWORD = "tadie";
}
