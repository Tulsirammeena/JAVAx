package com.stockExchange.daoImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockExchange.dto.OrderModel;
import com.stockExchange.entity.OrderEntity;
import com.stockExchange.repository.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

 //   @Autowired
//    private CompanyRepository companyRepository; // Assuming you have this to get company names

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderModel> getOrderHistory(String userName, LocalDateTime beginDate, LocalDateTime endDate) {
        List<OrderEntity> orders = orderRepository.findAll();

        if (userName != null) {
            orders = orders.stream()
                .filter(order -> order.getUser().getUserName().equals(userName))
                .collect(Collectors.toList());
        }

        if (beginDate != null && endDate != null) {
            orders = orders.stream()
                .filter(order -> !order.getCreatedAt().isBefore(beginDate) && !order.getCreatedAt().isAfter(endDate))
                .collect(Collectors.toList());
        }

        return orders.stream().map(order -> {
            OrderModel dto = new OrderModel();
            dto.setTransactionId(order.getOrderId());
            dto.setTransactionType(order.getOrderType().name());
//            dto.setCompanyName(getCompanyNameById(order.getCompanyId()));
            dto.setDate(order.getCreatedAt());
            dto.setCompanyName(order.getStockDetail().getName());
            dto.setSharePrice(order.getPrice());
            dto.setQuantity(order.getQuantity());
            dto.setTotalPrice(order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
            dto.setStatus(order.getStatus().name());
            return dto;
        }).collect(Collectors.toList());
    }

//    private String getCompanyNameById(Long companyId) {
//        // Fetch company name by companyId
//        Optional<Company> company = companyRepository.findById(companyId);
//        return company.map(Company::getName).orElse("Unknown");
//    }
}
