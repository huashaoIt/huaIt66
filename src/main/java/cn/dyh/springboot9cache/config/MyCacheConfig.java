package cn.dyh.springboot9cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义缓存生成主键配置类
 */
@Configuration
public class MyCacheConfig {

    /**
     * 注册到容器中
     * 指定名称 调用方可以通过名称来调用使用
     */
    @Bean("keyGener")
    public void keyGenerator(){
        new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //方法名+方法参数
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };
    }
}
