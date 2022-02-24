package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.service.CampingService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private final CampingService cs;

     public List searchList(String keyword) throws IOException, ParseException {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/searchList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=5K22ERxYpx037uiwVJ9pScUhIGitPmhoLBa4gLyKG6dKQkPgt19o8hvQCF97fjdE0M%2FBrbX%2B559dIXy6dwXLCA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(윈도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(keyword, "UTF-8"));
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
        JSONArray item = new JSONArray();
        List list = new ArrayList<>();
        while ((result = br.readLine()) != null) {
            JSONParser jsonParser = new JSONParser();
            JSONObject object = (JSONObject)jsonParser.parse(result);

            JSONObject response = (JSONObject)object.get("response");

            JSONObject body = (JSONObject)response.get("body");

            JSONObject items = (JSONObject)body.get("items");

            item = (JSONArray) items.get("item");
            System.out.println("item : " + item);
            for(int i=0;i<item.size();i++) {
                JSONObject item1 = (JSONObject) item.get(i);
                CampingDetailDTO campingDetailDTO = new CampingDetailDTO();
                campingDetailDTO.setCampingAddr((String) item1.get("addr1"));
                campingDetailDTO.setCampingInfo((String) item1.get("lineIntro"));
                campingDetailDTO.setCampingName((String) item1.get("facltNm"));
                campingDetailDTO.setCampingFileName((String) item1.get("firstImageUrl"));
                list.add(campingDetailDTO);
            }
        }

        br.close();
        conn.disconnect();
        System.out.println(item.size()+"size");
        return list;

    }

    @GetMapping("/camping")
    public String indexSearch(Model model, HttpSession session, @RequestParam(value = "keyword",required = false)String keyword,
                              @RequestParam(value = "checkInDate",required = false)String checkInDate, @RequestParam(value = "checkOutDate",required = false)String checkOutDate) throws IOException, ParseException {
        System.out.println(checkInDate+"/"+checkOutDate);

         if(keyword==null){
             keyword = "캠핑";
             List<CampingDetailDTO> campingDetailDTOList = this.searchList(keyword);
             model.addAttribute("searchList",campingDetailDTOList);
         }else{
            List<CampingDetailDTO> campingDetailDTOList = this.searchList(keyword);
             model.addAttribute("searchList",campingDetailDTOList);
             session.setAttribute("checkInDate" ,checkInDate);
             session.setAttribute("checkOutDate" ,checkOutDate);

         }

        return "offers";
    }

    @GetMapping("/searchDetail/{campingName}")
    public String detail(@PathVariable String campingName,Model model,HttpSession session) throws java.text.ParseException {
        System.out.println("searchController");
        String name = campingName.replace(" ","");

        CampingDetailDTO campingDetailDTO = cs.findByCampingName(name);
        if(campingDetailDTO.getCampingFileName()==null){
            campingDetailDTO.setCampingFileName("/images/noImage.jpg");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate = format.parse((String) session.getAttribute("checkInDate"));
        Date checkOutDate = format.parse((String) session.getAttribute("checkOutDate"));
        long period = (checkOutDate.getTime()-checkInDate.getTime()) / 1000;
        long period1 = period/(24*60*60);
        long period2 = (period/(24*60*60))+1;



        campingDetailDTO.setCheckInDate(checkInDate);
        campingDetailDTO.setCheckOutDate(checkOutDate);

        model.addAttribute("campingDetail",campingDetailDTO);
        model.addAttribute("period1", period1);
        model.addAttribute("period2", period2);
        System.out.println(campingDetailDTO.toString());
         return "single_listing";
    }

    @GetMapping("/random")
    public @ResponseBody List<CampingDetailDTO> random(Model model){
        List campingDetailDTOList = new ArrayList();
        for(int i=0;i<3;i++) {
            CampingDetailDTO campingDetailDTO = CampingDetailDTO.toCampingDetailDTO(cs.findById((int) (Math.random() * 1000)).get());
            if(campingDetailDTO.getCampingFileName()==null){
                i= i-1;
            }else {
                campingDetailDTOList.add(i,campingDetailDTO);
            }
        }
        model.addAttribute("resultList",campingDetailDTOList);

         return campingDetailDTOList;
    }

}
