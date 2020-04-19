package io.seata.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.seata.sample.entity.OrdersEntity;
import io.seata.sample.service.BusinessService;

@RestController
@RequestMapping(value = "business")
public class BusinessController {
	
    @Autowired
	private BusinessService businessService;
//	@Autowired
//    private OrdersEntity ordersEntity;
    
   @GetMapping("createorder")
   public String create(@RequestParam("userId") Integer userid, 
   @RequestParam("productid") Integer productid, @RequestParam("countnum") Integer countnum,
   @RequestParam("money") Integer money, @RequestParam("status") String status){
	    OrdersEntity ordersEntity = new OrdersEntity();
		ordersEntity.setUserid(userid);
		ordersEntity.setProductid(productid);
		ordersEntity.setCountnum(countnum);
		ordersEntity.setMoney(money);
		businessService.createorder(ordersEntity, status);
        return "Create order success";
   }

}
