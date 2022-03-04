package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.*;
import com.icia.gangcamping.repository.CartRepository;
import com.icia.gangcamping.repository.OrderRepository;
import com.icia.gangcamping.repository.ProductRepositroy;
import com.icia.gangcamping.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor


public class ShoppingServiceImpl implements ShoppingService{

    private final ProductRepositroy pr;
    private final CartRepository cr;
    private final OrderRepository or;
    private  final StockRepository tr;
    private  final  MemberService ms;





    @Override
    public Long save(GoodsSaveDTO goodsSaveDTO) throws IOException {

        MultipartFile productImage = goodsSaveDTO.getProductImage();
        String productFileName = productImage.getOriginalFilename();
        productFileName = System.currentTimeMillis() + "-" + productFileName;
        String savePath = "C:\\devleopment\\source\\springboot\\GangCamPing_FinalProject\\src\\main\\resources\\static\\upload\\"+productFileName;
        if(!productImage.isEmpty()) {
            productImage.transferTo(new File(savePath));
        }
        goodsSaveDTO.setProductFileName(productFileName);


        ProductEntity productEntity = ProductEntity.toSaveEntity(goodsSaveDTO);
        Long result =  pr.save(productEntity).getProductId();

        return result;



    }



    @Override
    public List<GoodsDetailDTO> findAll() {
        List<ProductEntity> productEntityList = pr.findAll();
        List<GoodsDetailDTO> goodsList = new ArrayList<>();
        for (ProductEntity p : productEntityList)
        {
            goodsList.add(GoodsDetailDTO.toGoodsDetailDTO(p)); //한줄로 가능

        }
        System.out.println(goodsList);
        return goodsList;
    }




    @Override
    public GoodsDetailDTO findById(Long productId) {
        Optional<ProductEntity> productEntityOptional = pr.findById(productId);
        ProductEntity productEntity = productEntityOptional.get();
        StockEntity stockEntity = tr.findByProductEntity(productEntity);
        GoodsDetailDTO goodsDetailDTO = GoodsDetailDTO.toGoodsDetailDTO(productEntity); //변환 모습
        goodsDetailDTO.setProductStock(stockEntity.getStock());
        return goodsDetailDTO;
    }



    @Override
    public CartDetailDTO addCart(CartDetailDTO cartDetailDTO, MemberEntity memberEntity , ProductEntity productEntity) {
        CartEntity cartEntity = CartEntity.toSaveEntity(cartDetailDTO,memberEntity,productEntity);
        cartDetailDTO = CartDetailDTO.tpCartDetailDTO(cartEntity); //변환 모습

        cr.save(cartEntity);
        return cartDetailDTO;
    }

    @Override
    public Optional<ProductEntity> findById1(Long productId) {

        return pr.findById(productId);
    }

    @Override
    public List<CartDetailDTO> findByMemberEntity(MemberEntity memberEntity) {
        List<CartEntity> cartEntityList =  cr.findByMemberEntity(memberEntity);
        List<CartDetailDTO> cartDetailDTOList = new ArrayList<>();
        for (int i=0; i<cartEntityList.size(); i++ )
        {
            CartDetailDTO cartDetailDTO = new CartDetailDTO();
            cartDetailDTO = CartDetailDTO.toCartDetailDTO(cartEntityList.get(i));
            cartDetailDTOList.add(cartDetailDTO);
        }
        return cartDetailDTOList;
    }

    @Override
    public void deleteById(Long cartId) {
        cr.deleteById(cartId);
    }

    @Override
    public CartDetailDTO findByMemberEntityAndProductEntity(MemberEntity memberEntity, ProductEntity productEntity) {
        CartEntity cart= cr.findByMemberEntityAndProductEntity(memberEntity, productEntity);
        if(cart != null){
            CartDetailDTO cartDetailDTO = new CartDetailDTO();
            System.out.println(cart);
            cartDetailDTO = CartDetailDTO.toCartDetailDTO(cart);
            return cartDetailDTO;
        }else {
            return null;
        }

    }

    @Override
    public String meunUpDown(Long cartId, String type) {
        Optional<CartEntity> cartEntity = cr.findById(cartId);
        if (type.equals("up")){
            cartEntity.get().setCartAmount(cartEntity.get().getCartAmount() + 1);
            cr.save(cartEntity.get());
        }else{
            cartEntity.get().setCartAmount(cartEntity.get().getCartAmount() - 1);
            cr.save(cartEntity.get());
        }
        return "ok";
    }

    @Override
    public Long update(ShoppingUpdateDTO shoppingUpdateDTO) throws IOException {
        MultipartFile productImage = shoppingUpdateDTO.getProductImage();
        String productFileName = productImage.getOriginalFilename();
        productFileName = System.currentTimeMillis() + "-" + productFileName;
        String savePath = "C:\\development\\source\\springboot\\GangCamPing_FinalProjects\\src\\main\\resources\\static\\upload\\"+productFileName;
        if(!productImage.isEmpty()) {
            productImage.transferTo(new File(savePath));
        }
        shoppingUpdateDTO.setProductFileName(productFileName);
        ProductEntity productEntity = ProductEntity.toUpdateBoard(shoppingUpdateDTO);
        return pr.save(productEntity).getProductId();
    }

    @Override
    public List<OrderDetailDTO> findByMemberEntity1(MemberEntity memberEntity) {
        List<OrderDetailDTO> oList = new ArrayList<>();
        List<OrderEntity> order = or.findByMemberEntity(memberEntity);
        for(OrderEntity orders : order) {
            oList.add(OrderDetailDTO.toOrderDetailDTO1(orders));
        }
        return oList;
    }

    @Override
    public ProductEntity findById2(Long productId) {
        return pr.findById(productId).get();
    }


}
