package com.icia.gangcamping.controller;

import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

@RestController
public class RestTestController {

    @RequestMapping(value="/apitest", method= {RequestMethod.GET, RequestMethod.POST})
    public String callapihttp(){

        StringBuffer result = new StringBuffer();
        try{
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?serviceKey=5K22ERxYpx037uiwVJ9pScUhIGitPmhoLBa4gLyKG6dKQkPgt19o8hvQCF97fjdE0M%2FBrbX%2B559dIXy6dwXLCA%3D%3D&pageNo=1&numOfRows=10&MobileOS=ETC&MobileApp=AppTest" +
                    "serviceKey=5K22ERxYpx037uiwVJ9pScUhIGitPmhoLBa4gLyKG6dKQkPgt19o8hvQCF97fjdE0M%2FBrbX%2B559dIXy6dwXLCA%3D%3D" +
                    "&type=xml" +
                    "&numOfRows=10" +
                    "&pageNo=1" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&flag=Y";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));

            String returnLine;

            while((returnLine = br.readLine()) != null) {
                result.append(returnLine);
                System.out.println(br.readLine());
            }
            urlconnection.disconnect();

        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}