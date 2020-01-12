package com.dimples.monitor.admin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/12
 */
@Slf4j
@Component
public class StartedUpRunner implements ApplicationRunner {

    private ConfigurableApplicationContext context;

    @Autowired
    public StartedUpRunner(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Value("${spring.application.name:'Dimples-Monitor-Admin'}")
    private String applicationName;

    @Override
    public void run(ApplicationArguments args) {
        if (context.isActive()) {
            log.info("   ,--.,--.                 ,--.                                             ,--.  ,--.");
            log.info(" ,-|  |`--',--,--,--. ,---. |  | ,---.  ,---.,-----.,--,--,--. ,---. ,--,--, `--',-'  '-. ,---. ,--.--.");
            log.info("' .-. |,--.|        || .-. ||  || .-. :(  .-''-----'|        || .-. ||      \\,--.'-.  .-'| .-. ||  .--'");
            log.info("\\ `-' ||  ||  |  |  || '-' '|  |\\   --..-'  `)      |  |  |  |' '-' '|  ||  ||  |  |  |  ' '-' '|  |");
            log.info("`---' `--'`--`--`--'|  |-' `--' `----'`----'       `--`--`--' `---' `--''--'`--'  `--'   `---' `--'");
            log.info("                    `--'");
            log.info("{} 启动完毕，时间：{}", applicationName, LocalDateTime.now());
        }
    }
}
