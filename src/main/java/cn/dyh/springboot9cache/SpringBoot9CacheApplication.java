package cn.dyh.springboot9cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("cn.dyh.springboot9cache.dao")   //扫描mapper类
@SpringBootApplication
@EnableCaching   //开启缓存
public class SpringBoot9CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot9CacheApplication.class, args);
    }

}
