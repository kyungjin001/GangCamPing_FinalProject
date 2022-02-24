package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.OrderDetailDTO;
import com.icia.gangcamping.dto.OrderSaveDTO;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.OrderEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.repository.CartRepository;
import com.icia.gangcamping.repository.MemberRepository;
import com.icia.gangcamping.repository.OrderRepository;
import com.icia.gangcamping.repository.ProductRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class OrderServiceImpl implements OrderService{

    private final ProductRepositroy pr;
    private final CartRepository cr;
    private final OrderRepository or;
    private final MemberRepository mr;




    @Override
    public Long save(OrderSaveDTO orderSaveDTO) {
        System.out.println(orderSaveDTO);
        Optional<MemberEntity> memberEntity = mr.findById(orderSaveDTO.getMemberId());
        OrderEntity orderEntity = OrderEntity.toSaveEntity(orderSaveDTO,memberEntity.get());
        Long result =  or.save(orderEntity).getOrderId();
        return result;
    }

    @Override
    public OrderDetailDTO findById(Long result) {
        Optional<OrderEntity> orderEntity = or.findById(result);
        OrderDetailDTO orderDetailDTO = OrderDetailDTO.toOrderDetailDTO(orderEntity);
        return orderDetailDTO;
    }




}
