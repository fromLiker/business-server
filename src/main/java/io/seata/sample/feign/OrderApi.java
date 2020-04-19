package io.seata.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import io.seata.sample.entity.OrdersEntity;

/**
 * @author Liker
 */
@FeignClient(value = "order-server")
public interface OrderApi {

    /**
     * a创建订单
     */
    @RequestMapping("/orders/create")
    String create(@RequestBody OrdersEntity ordersEntity);
    
    /**
     * a正常创建订单
     * @return
     */
    @RequestMapping("/orders/createnormal")
    String createnormal(@RequestBody OrdersEntity ordersEntity);
    
}
