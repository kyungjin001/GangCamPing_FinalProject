package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.entity.StockEntity;
import com.icia.gangcamping.repository.ProductRepositroy;
import com.icia.gangcamping.repository.StockRepository;
import com.icia.gangcamping.service.*;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shopping/*")
public class ShoppingController {


private final ShoppingService ss;
private final ShoppingLikeService sls;
private final OrderService os;
private final CommentService cs;
private final MemberService ms;
private final StockService ts;
private final HttpSession session;
    private final MemberRepository mr;
    private final StockRepository tr;
    private final ProductRepositroy pr;

//상품목록
@RequestMapping("shopping")
public String shopping(@ModelAttribute GoodsDetailDTO goodsDetailDTO, Model model) {
List<GoodsDetailDTO> goodsList = ss.findAll();
model.addAttribute("goodsList", goodsList);
//    Optional<MemberEntity> memberEntityOptional = ms.findById(goodsDetailDTO.getMemberId());
//    MemberEntity memberEntity = memberEntityOptional.get();
//    MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity);
//    model.addAttribute("memberDetailDTO", memberDetailDTO);
return "shopping/shopping";
}

//상품 상세조회
@GetMapping("{productId}")
public String findById(@PathVariable("productId") Long productId, Model model) throws ParseException {
GoodsDetailDTO goods = ss.findById(productId);
model.addAttribute("goods", goods);
List<CommentDetailDTO> commentList = cs.findAll(productId);
model.addAttribute("commentList", commentList);
List<AnswerDetailDTO> answer = cs.findAll2(productId);
    model.addAttribute("answer", answer);
MemberEntity memberEntity = ms.findByMemberEmail((String) session.getAttribute("loginEmail"));
MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity);
Long memberId = memberDetailDTO.getMemberId();
model.addAttribute("memberId", memberId);
Optional<ProductEntity> productEntity = pr.findById(productId);
StockEntity stockEntity = tr.findByProductEntity(productEntity.get());
StockDetailDTO stockDetailDTO = StockDetailDTO.toStockDetailDTO(stockEntity);
model.addAttribute("stock", stockDetailDTO);
return "shopping/shopdetail";
}




// 상품등록 링크요청
@GetMapping("goods")
public String goodsForm() {
return "shopping/goods";
}


//상품등록
@PostMapping("goods")
public String goods(@ModelAttribute GoodsSaveDTO goodsSaveDTO) throws IOException {
Long productId = ss.save(goodsSaveDTO);
StockSaveDTO stockSaveDTO = new StockSaveDTO();
stockSaveDTO.setStock(goodsSaveDTO.getProductStock());
stockSaveDTO.setProductId(productId);
ts.save(stockSaveDTO);
System.out.println("goodsSaveDTO = " + goodsSaveDTO);
return "redirect:/shopping/shopping";
}


// 장바구니 담기
@GetMapping("cart")
public String addCart(@ModelAttribute CartDetailDTO cartDetailDTO, Model model) {
    System.out.println(cartDetailDTO);
MemberEntity memberEntity = ms.findByMemberEmail((String) session.getAttribute("loginEmail"));
Optional<ProductEntity> productEntity = ss.findById1(cartDetailDTO.getProductId());
CartDetailDTO cart = ss.findByMemberEntityAndProductEntity(memberEntity, productEntity.get());
Long productId = cartDetailDTO.getProductId();
model.addAttribute("productId", productId);
    Long memberId = cartDetailDTO.getMemberId();
    System.out.println("아이디좀 찍혀라"+memberId);
    model.addAttribute("memberId", memberId);
if (cart == null) {
    System.out.println(cartDetailDTO.getCartAmount());
    CartDetailDTO cartDetailDTO0 = ss.addCart(cartDetailDTO, memberEntity, productEntity.get());
    System.out.println(cartDetailDTO0+"aaaa");
    List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity);
    model.addAttribute("cartList", cartDetailDTOList);
    int cartPriceSum = 0;
    int orderUnitNum = 0;
    for (CartDetailDTO c : cartDetailDTOList) {
        cartPriceSum += (c.getProductPrice() * c.getCartAmount());
        orderUnitNum += c.getCartAmount();

        System.out.println("c0 = " + c);
    }
    model.addAttribute("totalPrice", cartPriceSum);
    model.addAttribute("orderUnitNum", orderUnitNum);
    return "shopping/cart";
} else {
    List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity);
    model.addAttribute("cartList", cartDetailDTOList);
    int cartPriceSum = 0;
    int orderUnitNum = 0;
    for (CartDetailDTO c : cartDetailDTOList) {
        cartPriceSum += (c.getProductPrice() * c.getCartAmount());
        orderUnitNum += c.getCartAmount();
        System.out.println("c = " + c);
    }
    model.addAttribute("totalPrice", cartPriceSum);
    model.addAttribute("orderUnitNum", orderUnitNum);

    return "shopping/cart";
}
}

@GetMapping("cartview")
public String cartview(@ModelAttribute CartDetailDTO cartDetailDTO, Model model) {
MemberEntity memberEntity = ms.findByMemberEmail((String) session.getAttribute("loginEmail"));
List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity);
if (!cartDetailDTOList.isEmpty()) {
    int cartPriceSum = 0;
    for (CartDetailDTO c : cartDetailDTOList) {
        cartPriceSum += (c.getProductPrice() * c.getCartAmount());
        System.out.println("c = " + c);
    }
    Long memberId = cartDetailDTO.getMemberId();
    model.addAttribute("memberId", memberId);
    model.addAttribute("cartList", cartDetailDTOList);
    model.addAttribute("totalPrice", cartPriceSum);
}
return "shopping/cart";
}


//장바구니삭제
@DeleteMapping("{cartId}")
public ResponseEntity cartDelete(@PathVariable Long cartId) {
System.out.println("cartId = " + cartId);
ss.deleteById(cartId);
return new ResponseEntity(HttpStatus.OK);
}


//장바구니 수량카운트
@PutMapping("menu")
@ResponseBody
public String meunUpDown(@RequestParam("cartId") Long cartId, @RequestParam("type") String type) {
String result = ss.meunUpDown(cartId, type);
System.out.println("제발 넘어와" + cartId);
return result;
}


@GetMapping("order")
public String order(@ModelAttribute OrderDetailDTO orderDetailDTO,Model model) {
    System.out.println(orderDetailDTO);
Optional<MemberEntity> memberEntity = mr.findById(orderDetailDTO.getMemberId());
List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity.get());
model.addAttribute("cartList", cartDetailDTOList);
    MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity.get());
    model.addAttribute("memberDetailDTO", memberDetailDTO);
int orderUnitNum = 0;
int orderTotalFee = 0;
String orderPayType = "";
String menuList = "";
String GoodsName = "";
for (CartDetailDTO c : cartDetailDTOList) {
    orderTotalFee += (c.getProductPrice() * c.getCartAmount());
    System.out.println("c = " + c);
    menuList += c.getProductName();
    orderUnitNum += c.getCartAmount();
    GoodsName += c.getProductName();
}
model.addAttribute("menu", menuList);
model.addAttribute("orderTotalFee", orderTotalFee);
model.addAttribute("GoodsName", GoodsName);
model.addAttribute("orderDetailDTO", orderDetailDTO);


return "shopping/order";
}



// 카카오페이 구매
@PostMapping("pay")
public String pay(@ModelAttribute OrderSaveDTO orderSaveDTO, Model model) {
    Long result = os.save(orderSaveDTO);
OrderDetailDTO orderDetailDTO = os.findById(result);
    Optional<MemberEntity> memberEntityOptional = mr.findById(orderDetailDTO.getMemberId());
    MemberEntity memberEntity = memberEntityOptional.get();
    MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity);
    model.addAttribute("memberDetailDTO", memberDetailDTO);
model.addAttribute("orderDetailDTO", orderDetailDTO);
model.addAttribute("MemberDetailDTO", memberDetailDTO);
return "shopping/complete";
}



// 상품 재고
    @RequestMapping("stock")
    public String stock(Model model){
        List<StockDetailDTO> stock = ts.findAll();
        model.addAttribute("stock", stock);
        return "shopping/stock";
    }

// 재고 카운팅
    @PutMapping("stock")
    @ResponseBody
    public String stockUpDown(@RequestParam("stockId") Long stockId, @RequestParam("type") String type) {
        String result = ts.stockUpDown(stockId, type);
        System.out.println("제발 넘어와" + stockId);
        return result;
    }

    //재고수정
    @PutMapping("{stockId}") //에이작스는 @RequestBody로 받아줘야함
    public ResponseEntity stockUpdate(@RequestBody StockUpdateDTO stockUpdateDTO){
        ts.update(stockUpdateDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
//
//    //수정처리
    @GetMapping("/update/{productId}")
    public String updateForm(Model model, @PathVariable("productId") Long productId){
        GoodsDetailDTO goods = ss.findById(productId);

        model.addAttribute("goods",goods);

        return "shopping/update";
    }

    //수정(post)
    @PostMapping("update")
    public String update(@ModelAttribute ShoppingUpdateDTO shoppingUpdateDTO) throws IOException {

        StockUpdateDTO stockUpdateDTO = ts.findByProductEntity(pr.findById(shoppingUpdateDTO.getProductId()).get());
        stockUpdateDTO.setStock(shoppingUpdateDTO.getProductStock());
        stockUpdateDTO.setProductEntity(pr.findById(shoppingUpdateDTO.getProductId()).get());
        System.out.println(shoppingUpdateDTO);
        System.out.println(stockUpdateDTO);
        ss.update(shoppingUpdateDTO);
        ts.update(stockUpdateDTO);
        System.out.println("end update ts");
        //수정완료 후 해당글의 상세페이지 출력
        return "redirect:/admin/findAll";
    }


    @PostMapping("/shoppingLike")
    public @ResponseBody ShoppingLikeDetailDTO shoppingLike(HttpSession session,  ShoppingLikeSaveDTO shoppingLikeSaveDTO) {

        String memberEmail = (String) session.getAttribute("loginEmail");
        Long shoppingLike = sls.save(shoppingLikeSaveDTO, memberEmail);
        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        Optional<ProductEntity> product = pr.findById(shoppingLikeSaveDTO.getProductId());
        ShoppingLikeDetailDTO shoppingLikeDetailDTO = sls.findByMemberEntityAndProductEntity(memberEntity,product);
        return shoppingLikeDetailDTO;
    }


    @DeleteMapping("/delete/{shoppingLikeId}")
    public ResponseEntity shoppingLikeDelete(@PathVariable("shoppingLikeId") Long shoppingLikeId){
        sls.deleteById(shoppingLikeId);
        return new ResponseEntity(HttpStatus.OK);
    }


//    //장바구니 수량카운트
//    @PutMapping("menu1")
//    @ResponseBody
//    public String meunUpDown1(@RequestParam("productId") Long productId, @RequestParam("type") String type) {
//        String result = ss.meunUpDown1(productId, type);
//        System.out.println("제발 넘어와" + productId);
//        return result;
//    }




}
