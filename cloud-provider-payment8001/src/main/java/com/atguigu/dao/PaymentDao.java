package com.atguigu.dao;

import com.atguigu.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
