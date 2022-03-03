# GangCamPing_FinalProject

## 실행전 확인 

2022.02.26 추가
campingLikeEntity 테이블 명 board_table로 되어있어서 campingLikeEntity로 변경
sql에서 25일에 했던것 처럼 직접ㅈ drop table board_table 후 create 

엔티티에 변경사항이있어서 create로 변경한 이후 재실행하면 에러뜸

메인컨트롤러에서 


 @RequestMapping("/")
    public String cxczcof(Model model) {
       
       <--여기서부터-->
       List campingDetailDTOList = new ArrayList();
        for(int i=0;i<3;i++) {
            CampingDetailDTO campingDetailDTO = CampingDetailDTO.toCampingDetailDTO(cs.findById((int) (Math.random() * 1000)).get());
            if(campingDetailDTO.getCampingFileName()==null){
                i= i-1;
            }else {
                campingDetailDTOList.add(campingDetailDTO);
            }
        }

        List<CampingDetailDTO> recommendList = cs.findTop3AllOrderByCampingLikeCount();
        model.addAttribute("resultList",campingDetailDTOList);
        model.addAttribute("recommendList",recommendList);
      <--여기까지 주석처리-->
        return "index";
    }

이후 실행한다음 네비게이션바에서 APITEST -> 버튼 두개 클릭후 yml update로 변경 -> 주석처리부분 해제 -> 다시실행 


## 리턴관련 공지사항

repository에서 리턴하는것은 entity 입니다. 
service에서 리턴하는값은 DTO입니다.
controller에서 entity return 이 필요한경우 controller->service->repository 순서가아니라
                    controller -> repository로 바로 접근해주세요.
작업부분들 확인하시고 다른부분 수정해주세요, 실행중 오류가 나는부분은 임의로 수정하였습니다.












## 김경진, 김백준, 강율중, 김강모 강캠핑 파이널프로젝트 화이팅!!
## 푸시할때 커밋메세지에 일자,작업내용,이니셜추가할것</br> 
 Ex)20220210/entitiy작업/KYJ
## 머지 하기전에 모달실행해보고 실행안될시 모달부분 div 괄호 확인할것 </br> 

dddddddsdsdsdsd
## 프로젝트 환경설정
## port: 8098
## 데이터 베이스 관련 설정 
 DB_name : gangcamping </br>
 username : gangcamping</br>
 pw : 1234</br>

## workbench

create database gangcamping; </br>
drop user gangcamping@localhost;</br>
create user gangcamping@localhost identified by '1234';</br>
grant all privileges on gangcamping.* to gangcamping@localhost;</br>


### 02/23
