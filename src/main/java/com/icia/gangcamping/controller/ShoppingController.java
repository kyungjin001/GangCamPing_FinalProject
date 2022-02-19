package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.CartDetailDTO;
import com.icia.gangcamping.dto.GoodsDetailDTO;
import com.icia.gangcamping.dto.GoodsSaveDTO;
import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.service.MemberService;
import com.icia.gangcamping.service.shoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shopping/*")
public class ShoppingController {


     private final shoppingService ss;
    private final MemberService ms;




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

    @RequestMapping("cart")
    public String cart() {
        return "shopping/cart";
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
        Optional<MemberEntity> memberEntity = ms.findById(cartDetailDTO.getMemberId());
        Optional<ProductEntity> productEntity = ss.findById1(cartDetailDTO.getProductId());
        CartDetailDTO cart = ss.findByMemberEntityAndProductEntity(memberEntity.get(),productEntity.get());
        if(cart == null){
            CartDetailDTO CartDetailDTO = ss.addCart(cartDetailDTO, memberEntity.get(), productEntity.get());
            List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity.get());
            model.addAttribute("cartList", cartDetailDTOList);
            GoodsDetailDTO goodsDetailDTO = GoodsDetailDTO.toGoodsDetailDTO(productEntity.get());
            List<GoodsDetailDTO> goodsDetailDTOList = new ArrayList<>();
           // int cartPriceSum = 0;
            for (int i = 0; i < cartDetailDTOList.size(); i++) {
//                cartPriceSum += (cartDetailDTO.getProductPrice() * cartDetailDTO.getCartAmount());
                GoodsDetailDTO goodsDetailDTO2 = new GoodsDetailDTO();
                goodsDetailDTO2 = ss.findById(cartDetailDTOList.get(i).getProductId());
                goodsDetailDTOList.add(goodsDetailDTO2);
            model.addAttribute("goodsList", goodsDetailDTOList);
            }
            return "shopping/cart";
        }else {
            List<CartDetailDTO> cartDetailDTOList = ss.findByMemberEntity(memberEntity.get());
            model.addAttribute("cartList", cartDetailDTOList);
            GoodsDetailDTO goodsDetailDTO = GoodsDetailDTO.toGoodsDetailDTO(productEntity.get());
            List<GoodsDetailDTO> goodsDetailDTOList = new ArrayList<>();
            for (int i = 0; i < cartDetailDTOList.size(); i++) {
                GoodsDetailDTO goodsDetailDTO2 = new GoodsDetailDTO();
                goodsDetailDTO2 = ss.findById(cartDetailDTOList.get(i).getProductId());
                goodsDetailDTOList.add(goodsDetailDTO2);
                model.addAttribute("goodsList", goodsDetailDTOList);
            }

            return "shopping/cart";
        }
    }


    //장바구니삭제
    @DeleteMapping("{cartId}")
    public ResponseEntity cartDelete(@PathVariable Long cartId) {
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


}
