package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.ChattingDetailDTO;
import com.icia.gangcamping.dto.ChattingSaveDTO;
import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;
import com.icia.gangcamping.service.ChattingService;
import com.icia.gangcamping.vo.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Controller
public class ChattingController {

    private final ChattingService hs;



    @PostMapping("/chatting/save")
    public void save(@ModelAttribute ChattingSaveDTO chattingSaveDTO){
        hs.save(chattingSaveDTO);
//        List<ChattingDetailDTO> chatList = hs.findAll(chattingSaveDTO.);
    }



    List<Room> roomList = new ArrayList<Room>();
    static int roomNumber = 0;

    @RequestMapping("/chat")
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chat");
        return mv;
    }

    /**
     * 방 페이지
     * @return
     */
    @RequestMapping("/room")
    public ModelAndView room() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("room");
        return mv;
    }

    /**
     * 방 생성하기
     * @param params
     * @return
     */
    @RequestMapping("/createRoom")
    public @ResponseBody
    List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
        String roomName = (String) params.get("roomName");
        if(roomName != null && !roomName.trim().equals("")) {
            Room room = new Room();
            room.setRoomNumber(++roomNumber);
            room.setRoomName(roomName);
            roomList.add(room);
        }
        return roomList;
    }

    /**
     * 방 정보가져오기
     * @param params
     * @return
     */
    @RequestMapping("/getRoom")
    public @ResponseBody
    List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
        return roomList;
    }

    /**
     * 채팅방
     * @return
     */
    @RequestMapping("/moveChating")
    public ModelAndView chating(@RequestParam HashMap<Object, Object> params, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

        List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
        if(new_list != null && new_list.size() > 0) {
            mv.addObject("roomName", params.get("roomName"));
            session.setAttribute("roomName",params.get("roomName"));
            mv.addObject("roomNumber", params.get("roomNumber"));
            mv.addObject("roomDate", params.get("roomDate"));
            mv.setViewName("chat");
        }else {
            mv.setViewName("room");
        }
        return mv;
    }
}
