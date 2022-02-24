package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.service.MemberService;
import com.icia.gangcamping.service.OrderService;
import com.icia.gangcamping.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shopping/*")
public class ShoppingController {


     private final ShoppingService ss;
     private final OrderService os;
    private final MemberService ms;
    private final HttpSession session;



    //상품목록
    @RequestMapping("shopping")
    public String shopping(Model model) {
        List<GoodsDetailDTO> goodsList = ss.findAll();
        model.addAttribute("goodsList", goodsList);
        return "shopping/shopping";
    }

    //상품 상세조회
    @GetMapping("{productId}")
    public String findById(@PathVariable("productId") Long productId, Model model) {
        GoodsDetailDTO goods = ss.findById(productId);
        model.addAttribute("goods", goods);
        return "shopping/shopdetail";
    }


    @RequestMapping("shopdetail")
    public String shopDetail() {
        return "shopping/shopdetail";
    }



    @RequestMapping("order")
    public String order() {
        return "shopping/order";
    }

    @RequestMapping("complete")
    public String complete() {
        return "shopping/complete";
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
        System.out.println("goodsSaveDTO = " + goodsSaveDTO);
        return "redirect:/shopping/shopping";
    }




    // 장바구니 담기
    @GetMapping("cart")
    public String addCart(@ModelAttribute CartDetailDTO cartDetailDTO, Model model){
        Optional<MemberEntity> memberEntity = ms.findByMemberId(cartDetailDTO.getMemberId());
        Optional<ProductEntity> productEntity = ss.findById1(cartDetailDTO.getProductId());
        CartDetailDTO cart = ss.findByMemberEntityAndProductEntity(memberEntity.get(),productEntity.get());
        Long productId = cartDetailDTO.getProductId();
        model.addAttribute("productId",productId);
        if(cart == null){
            CartDetailDTO CartDetailDTO = ss.addCart(cartDetailDTO, memberEntity.get(), productEntity.get());
            List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity.get());
            model.addAttribute("cartList", cartDetailDTOList);
        int cartPriceSum = 0;
        int orderUnitNum = 0;
            for (CartDetailDTO c : cartDetailDTOList) {
                cartPriceSum += (c.getProductPrice() * c.getCartAmount());
                orderUnitNum += c.getCartAmount();

                System.out.println("c = " + c);
            }
            model.addAttribute("totalPrice",cartPriceSum);
            model.addAttribute("orderUnitNum",orderUnitNum);
            return "shopping/cart";
        }else {
            List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity.get());
            model.addAttribute("cartList", cartDetailDTOList);
            int cartPriceSum = 0;
            int orderUnitNum = 0;
            for (CartDetailDTO c : cartDetailDTOList) {
                cartPriceSum += (c.getProductPrice() * c.getCartAmount());
                orderUnitNum += c.getCartAmount();
                System.out.println("c = " + c);
            }
            model.addAttribute("totalPrice",cartPriceSum);
            model.addAttribute("orderUnitNum",orderUnitNum);

            return "shopping/cart";
        }
    }

    @GetMapping("cartview")
    public String cartview(Model model){
        MemberEntity memberEntity = ms.findByMemberEmail((String) session.getAttribute("memberEmail"));
        List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity);
        if (!cartDetailDTOList.isEmpty()) {
            model.addAttribute("cartList", cartDetailDTOList);
            int cartPriceSum = 0;
            for (CartDetailDTO c : cartDetailDTOList) {
                cartPriceSum += (c.getProductPrice() * c.getCartAmount());
                System.out.println("c = " + c);
            }
            model.addAttribute("totalPrice",cartPriceSum);
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
        public String meunUpDown(@RequestParam("cartId") Long cartId, @RequestParam("type") String type){
        String result = ss.meunUpDown(cartId, type);
        System.out.println("제발 넘어와" + cartId);
        return  result;
    }



//    @GetMapping("order")
//    public String order(Model model,OrderDetailDTO orderDetailDTO){
//        Optional<MemberEntity> memberEntity = ms.findById(orderDetailDTO.getMemberId());
//        List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity.get());
//        model.addAttribute("cartList", cartDetailDTOList);
//            int orderUnitNum = 0;
//            int orderTotalFee = 0;
//            String orderPayType = "";
//            String menuList = "";
//            for (CartDetailDTO c : cartDetailDTOList) {
//                orderTotalFee += (c.getProductPrice() * c.getCartAmount());
//                System.out.println("c = " + c);
//                menuList += c.getProductName();
//                orderUnitNum += c.getCartAmount();
//            }
//            model.addAttribute("menu",menuList);
//            model.addAttribute("orderTotalFee",orderTotalFee);
//            model.addAttribute("orderDetailDTO",orderDetailDTO);
//
//
//        return "shopping/order";
//    }


    // 카카오페이 구매
	@PostMapping("pay")
	public String pay(@ModelAttribute OrderSaveDTO orderSaveDTO, Model model) {
		Long result = os.save(orderSaveDTO);
        OrderDetailDTO orderDetailDTO = os.findById(result);
        model.addAttribute("order", orderDetailDTO);
		return "redirect:/shopping/complete";
	}


}
