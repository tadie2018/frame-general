package dev.td.corepersistencemgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("dev.td.corepersistencemgr.mapper")
public class CorePersistenceMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorePersistenceMgrApplication.class, args);
    }

}
