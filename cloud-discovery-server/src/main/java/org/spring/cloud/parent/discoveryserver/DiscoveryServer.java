package org.spring.cloud.parent.discoveryserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.logging.Logger;

/**
 * 服务注册/发现，用于服务注册、服务发现、状态检查等
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-10
 * Time:  上午 10:44.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer implements CommandLineRunner{

    private static final Logger logger = Logger.getLogger(DiscoveryServer.class.getName());

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DiscoveryServer.class);

        application.setRegisterShutdownHook(true);

        application.run(args);

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                logger.warning("******************************DiscoveryServer shutdown******************************");
            }
        });
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.warning("******************************DiscoveryServer startup******************************");
    }
}
