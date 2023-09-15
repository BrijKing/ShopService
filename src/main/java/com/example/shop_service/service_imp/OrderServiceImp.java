package com.example.shop_service.service_imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop_service.custom_exceptions.OrderNotFoundException;
import com.example.shop_service.custom_exceptions.ProductNotFoundException;
import com.example.shop_service.dto.OrderDto;
import com.example.shop_service.model.Order;
import com.example.shop_service.repository.OrderRepo;
import com.example.shop_service.repository.ProductRepo;
import com.example.shop_service.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ProductRepo productRepo;

    @Override
    public OrderDto createOrder(OrderDto orderDto) throws ProductNotFoundException {
        
        Order order = modelMapper.map(orderDto, Order.class);
        List<String> productsIds = orderDto.getProductsId();
        
        for (String productId : productsIds) {
			productRepo.findById(productId).orElseThrow(ProductNotFoundException::new);
		}
        
        Order savedOrder = orderRepo.save(order);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrders() {
     
        List<Order> findAll = orderRepo.findAll();
        return findAll.stream().map(order -> modelMapper.map(order, OrderDto.class)).toList();        
    }

    @Override
    public OrderDto getOrderById(String id) throws OrderNotFoundException {
        
        Order findById = orderRepo.findById(id).orElseThrow(OrderNotFoundException::new );
        return modelMapper.map(findById, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) throws OrderNotFoundException {
       
        Order existingOrder = orderRepo.findById(orderDto.getId()).orElseThrow(OrderNotFoundException::new);

        existingOrder.setAddress(orderDto.getAddress());
        existingOrder.setDeliveryDate(orderDto.getDeliveryDate());
        existingOrder.setOrderBy(orderDto.getOrderBy());
        existingOrder.setOrderDate(orderDto.getOrderDate());
        existingOrder.setProductsId(orderDto.getProductsId());
        existingOrder.setStatus(orderDto.getStatus());
        existingOrder.setTotalPrice(orderDto.getTotalPrice());

        Order savedOrder = orderRepo.save(existingOrder);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public void deleteOrder(String id) {
        
        orderRepo.deleteById(id);
    }
    
}
