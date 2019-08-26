package dev.td.coredevtools.main;

import dev.td.coredevtools.generator.CodeGenerator;
import dev.td.coredevtools.ptutils.PersistenceUtil;

// 还有必要注释嘛
public class Main {
    public static void main(String[] args) {
//        String[] tableNames = {"sys_account","sys_role","sys_permission","user_main","account_role","account_permission","account_user"};
//        CodeGenerator codeGenerator = new CodeGenerator(tableNames);
//        codeGenerator.execute();
        System.out.println(PersistenceUtil.uuid());
    }
}
