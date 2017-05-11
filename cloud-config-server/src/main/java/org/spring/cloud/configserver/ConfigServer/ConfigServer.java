package org.spring.cloud.configserver.ConfigServer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置管理服务
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-11
 * Time:  上午 10:43.
 * Description:
 * To change this template use File | Settings | File Templates.
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServer implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConfigServer.class);
        application.setRegisterShutdownHook(true);
        application.run(args);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("******************************ConfigServer shutdown******************************");
            }
        });
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("******************************ConfigServer startup******************************");
    }
}
