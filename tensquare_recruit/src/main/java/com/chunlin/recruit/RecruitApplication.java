package com.chunlin.recruit;

import com.chunlin.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by  HASEE on 2018-12-10
 */
@SpringBootApplication
public class RecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,2);
    }
}
