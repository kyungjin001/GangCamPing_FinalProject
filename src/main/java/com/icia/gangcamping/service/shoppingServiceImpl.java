package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CartDetailDTO;
import com.icia.gangcamping.dto.GoodsDetailDTO;
import com.icia.gangcamping.dto.GoodsSaveDTO;
import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.repository.CartRepository;
import com.icia.gangcamping.repository.ProductRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class shoppingServiceImpl implements shoppingService{

    private final ProductRepositroy pr;
    private final CartRepository cr;




    @Override
    public Long save(GoodsSaveDTO goodsSaveDTO) throws IOException {

        MultipartFile productImage = goodsSaveDTO.getProductImage();
        String productFileName = productImage.getOriginalFilename();
        productFileName = System.currentTimeMillis() + "-" + productFileName;
        String savePath = "C:\\development\\source\\springboot\\GangCamPing_FinalProjects\\src\\main\\resources\\static\\upload\\"+productFileName;
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
        GoodsDetailDTO goodsDetailDTO = GoodsDetailDTO.toGoodsDetailDTO(productEntity); //변환 모습
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


}
