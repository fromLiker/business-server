package io.seata.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.seata.sample.entity.OrdersEntity;
import io.seata.sample.feign.OrderApi;
import io.seata.spring.annotation.GlobalTransactional;

@Service
public class BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    @Autowired
    private OrderApi orderApi;
    
    // a不加注解则不会发生事务回滚
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
	public void create(OrdersEntity ordersEntity) {
        LOGGER.info("------->create order start to request orderApi");
        orderApi.create(ordersEntity);
    }
	  
}
