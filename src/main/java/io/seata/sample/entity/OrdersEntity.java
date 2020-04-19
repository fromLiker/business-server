package io.seata.sample.entity;

import lombok.Data;

@Data
public class OrdersEntity {

    private Integer id;

    private Integer userid;

    private Integer productid;

    private Integer countnum;

	private Integer money;

}
