package com.stockExchange.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockExchange.daoImpl.OrderService;
import com.stockExchange.dto.OrderModel;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/history")
    public List<OrderModel> getOrderHistory(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "begin_date", required = false) String beginDateStr,
            @RequestParam(value = "end_date", required = false) String endDateStr) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime beginDate = beginDateStr != null ? LocalDate.parse(beginDateStr, formatter).atStartOfDay() : null;
        LocalDateTime endDate = endDateStr != null ? LocalDate.parse(endDateStr, formatter).atTime(23, 59, 59) : null;

        return orderService.getOrderHistory(userId, beginDate, endDate);
    }
}
