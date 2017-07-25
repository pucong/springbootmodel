package com.pc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by PC on 2017/7/23.
 */
@SpringBootApplication
// mybatis mapper 接口类扫描包配置
@MapperScan("com.pc.dao")
public class Application {

}
