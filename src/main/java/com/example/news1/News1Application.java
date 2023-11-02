package com.example.news1;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 스프링 서버가 특정 시간에 어떤 함수를 간헐적으로 실행해 주는 어노테이션
// os가(모든 os가 갖고 있음) crontab을 갖는데 작업 스케줄러와 같다 
/*
    crontab 명령어: 순서대로 min > hour > day > month > weekday(요일) 을 한칸씩 띄워서 적어주면 된다.
*   ***** : 1분마다 실행
*   30**** : 매시 30분마다 실행
    0010** : 매월 1일 0시 0분에 실행
 메인은 스레드가 하나 뿐이라 돌고 있는데 다른 os에서 끌어온걸 실행 하려고 스레드를 새로 생성해야 하기 때문에 
 독립적 런 타겟을 생성해 배치가 돈다. 직접 스레드랑 스케쥴링 작업을 하지 않아도 된다.
 크론탭 으로 해커들이 바이러스를 심기도 한다. 내가 한번 막아도 크론탭 으로 다시 실행 시키는 게 가능 하다.
 서버가 꺼져도 마찬 가지 서버가 꺼져도 크론탭 으로 다시 실행 시키는 게 가능 하다.
* */ 
@Log4j2
@EnableScheduling
@SpringBootApplication
public class News1Application {

    public static void main(String[] args) {
        SpringApplication.run(News1Application.class, args);
        
    
    }

}
