package io.seata.sample.entity;

public class OrdersEntity {

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getCountnum() {
		return countnum;
	}

	public void setCountnum(Integer countnum) {
		this.countnum = countnum;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	private Integer id;

    private Integer userid;

    private Integer productid;

    private Integer countnum;

	private Integer money;

}
