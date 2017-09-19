package com.raj.spring.FirstSpringApp.model;

public class Order {
    Integer id;
    Integer ordernumber;
    Integer custid;
    Integer totalamt;

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    Customer cust;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public Integer getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Integer totalamt) {
        this.totalamt = totalamt;
    }


}
