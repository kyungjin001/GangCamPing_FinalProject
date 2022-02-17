package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.CampingSaveDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.service.campingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ApiController {

    private final campingService cs;


    private static String getTagValue(String tag, Element element) {
        NodeList list = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node value = list.item(0);
        if (value == null) {
            return null;
        }
        return value.getNodeValue();
    }
    @GetMapping("/test")
    public String ad(){ return "test";}

    @GetMapping("/apiTest")
    public @ResponseBody List apiTest() throws IOException, ParseException {
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/locationBasedList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=5K22ERxYpx037uiwVJ9pScUhIGitPmhoLBa4gLyKG6dKQkPgt19o8hvQCF97fjdE0M%2FBrbX%2B559dIXy6dwXLCA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(윈도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("mapX", "UTF-8") + "=" + URLEncoder.encode("128.6142847", "UTF-8")); /*GPS X좌표(WGS84 경도 좌표)*/
        urlBuilder.append("&" + URLEncoder.encode("mapY", "UTF-8") + "=" + URLEncoder.encode("36.0345423", "UTF-8")); /*GPS Y좌표(WGS84 위도 좌표)*/
        urlBuilder.append("&" + URLEncoder.encode("radius", "UTF-8") + "=" + URLEncoder.encode("2000000", "UTF-8")); /*거리 반경(단위:m) Max값 20000m=20km*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") +"=json");
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader br;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line="";
        String result = "";
//        Map jsonMap = new HashMap<String, Object>();
//        List list = new ArrayList<>();
        JSONArray item = new JSONArray();
        List list = new ArrayList<>();
        while ((result = br.readLine()) != null) {

            JSONParser jsonParser = new JSONParser();
            JSONObject object = (JSONObject)jsonParser.parse(result);
            System.out.println("result : "+object);
            JSONObject response = (JSONObject)object.get("response");
            System.out.println("response : "+response);
            JSONObject body = (JSONObject)response.get("body");
            System.out.println("body : "+body);
            JSONObject items = (JSONObject)body.get("items");
            System.out.println("items : "+items);
            item = (JSONArray) items.get("item");
            System.out.println("item : " + item);
            for(int i=0;i<item.size();i++) {
                JSONObject item1 = (JSONObject) item.get(i);
                System.out.println("items : " + item1);
                testDTO dto = new testDTO();
                dto.setAddr((String) item1.get("addr1"));
                dto.setTel((String) item1.get("tel"));
                dto.setName((String) item1.get("facltNm"));
                this.saveDB(item1);
                list.add(dto);
            }

//            System.out.println(item.toString());
//            System.out.println("주소"+item.get("addr1"));
//            System.out.println("주소"+item.get("homepage"));
//            System.out.println("주소"+item.get("tel"));


//            list.add(line);
        }

            br.close();
            conn.disconnect();
        System.out.println(item.size()+"size");
       return list;

        }

       public void saveDB(JSONObject item){
            CampingSaveDTO campingSaveDTO = new CampingSaveDTO();
            campingSaveDTO.setCampingAddr((String) item.get("addr1"));
           System.out.println((String) item.get("addr1")+item.get(("addr2")));
            campingSaveDTO.setCampingInfo((String) item.get("intro"));
            campingSaveDTO.setCampingName((String) item.get("facltNm"));
            campingSaveDTO.setCampingLikeCount(0);
            campingSaveDTO.setCampingFileName((String) item.get("firstImageUrl"));
            CampingEntity entity = new CampingEntity();
            entity.dtoToEntity(campingSaveDTO);
            cs.save(entity);

        }
    }



