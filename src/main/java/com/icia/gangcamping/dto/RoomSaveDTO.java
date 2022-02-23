package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RoomSaveDTO {

    private Long campingId;
    private String roomName;
    private String roomPrice;
    private String roomInfo;
    private String roomFileName;
    private String roomCategory;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberUpdateDTO {

        private Long memberId;
        private String memberEmail;
        private String memberPw;
        private String memberName;
        private String memberAddr;
        private String memberPhone;

    }
}
