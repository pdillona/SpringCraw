package com.example.news1.batch;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class NaverCrawBatch {
    
    @Test
   public void test1() {
        // HttpUrlConnection (자바 기본 아무도 안씀,) OkHttp 자바에서 http 요청시 / RestTemplate / Retrofit2(제일 좋다함)
        //RestTemplate rt = new RestTemplate();    //스프링 통신 라이브러리

        try {


            String url = "https://twitter.com/KARINA_mgall/status/1719736118047084631";

            //String html = rt.getForObject(url, String.class);

            //System.out.println(html); // jsoup로 id : articleTitle을 파싱해야함

            //1.jsoup 라이브러리 빌드
            //Document doc = Jsoup.connect(url).get();
            //Document doc = Jsoup.parse(html);

            Document karina = Jsoup.connect(url).get();

            Elements ks = karina.select(".css-1dbjc4n img");

            for (int i = 0; i < ks.size(); i++) {
                Element imgElement = ks.get(i);
                String src = imgElement.attr("src");
                if (src.contains("small")) {
                    System.out.println(src);
                }
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
    
}
