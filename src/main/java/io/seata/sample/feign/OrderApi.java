package io.seata.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
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
    @RequestMapping(value = "/order/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // @RequestMapping("/order/create")不指定默认为get
    String create(@RequestBody OrdersEntity ordersEntity);
    
}
