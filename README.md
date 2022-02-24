# GangCamPing_FinalProject

## 실행전 확인 
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