package com.cloudp.entity;

public class Cart {
    private  String carid;
    private  String goods_num;
    private  String goods_id;
    private  String username;

    @Override
    public String toString() {
        return "Cart{" +
                "carid='" + carid + '\'' +
                ", goods_num='" + goods_num + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(String goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cart(String carid, String goods_num, String goods_id, String username) {
        this.carid = carid;
        this.goods_num = goods_num;
        this.goods_id = goods_id;
        this.username = username;
    }

    public Cart() {
    }
}
