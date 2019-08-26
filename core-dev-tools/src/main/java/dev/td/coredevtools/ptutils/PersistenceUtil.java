package dev.td.coredevtools.ptutils;


import java.util.UUID;

/**
 * 持久层工具类
 */
public class PersistenceUtil {
    /**
     * 64位UUID
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
