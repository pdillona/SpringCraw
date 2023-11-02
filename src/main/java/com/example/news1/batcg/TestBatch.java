package com.example.news1.batcg;


import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j2
@Component  //특정한 목적없이 개발자가 띄우고 싶은 파일을 컴포넌트로 띄운다.
public class TestBatch {
    
    int num = 10;
    
    
    @Scheduled(cron = "* * * * * *", zone = "Asia/Seoul")   
    public void testCount(){
        System.out.println("스케쥴러 증가"+ num);
        log.info("스케쥴러 증가"+ num);
        num++;

       
            // HttpUrlConnection (자바 기본 아무도 안씀,) OkHttp 자바에서 http 요청시 / RestTemplate / Retrofit2(제일 좋다함)
            //RestTemplate rt = new RestTemplate();    //스프링 통신 라이브러리

            try {

                Connection conn = Jsoup.connect("https://twitter.com/KARINA_mgall/status/1719736118047084631");
                

                //String html = rt.getForObject(url, String.class);

                //System.out.println(html); // jsoup로 id : articleTitle을 파싱해야함

                //1.jsoup 라이브러리 빌드
                //Document doc = Jsoup.connect(url).get();
                //Document doc = Jsoup.parse(html);

                Document karina = conn.get();

                Elements ks = karina.select(".css-9pa8cd src");

                
                System.out.println("==========!!  "+ ks.size());
                //System.out.println("==========@@"+ ks.get(1));
                System.out.println("==========##"+ ks.text() +"1========");
                for (int i = 0; i < 4; i++) {
                    Element imgElement = ks.get(i);
                        System.out.println("==========2"+ ks.text() +"========2");
                }

                //2.jsoup 기본 함수 학습
                //Element titleElement = doc.selectFirst("#title_area"); //값이아닌 element만 찾음

                //String title = titleElement.text();


                //3. 콘솔에 출력
                //System.out.println(title);
            }
    
  /*  @Test
    public void test2(){
        
        int num = 1;
        String strNum = "00000000000" + num;
        System.out.println(strNum);
        
    }*/ catch (Exception e) {

            }
        
        
        
        
    }
/*    @Scheduled(cron = "0*****", zone = "Asia/Seoul")   
    public void testCount2(){
        System.out.println("스케쥴러 증가"+ num);
        log.info("스케쥴러 증가"+ num);
        num++;
    }*/
}
