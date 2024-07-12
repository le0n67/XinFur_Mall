package com.leon.xinfur.entity;

/**
 * Date：2024/7/9  16:49
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import java.math.BigDecimal;

public class CartItem {

    //定义属性->根据需求
    private Integer id; //家居id
    private String name;//家居名
    private BigDecimal price;
    private Integer count;//数量
    private BigDecimal totalPrice;
    private String imgPath;

    public CartItem(Integer id, String name, BigDecimal price, Integer count, BigDecimal totalPrice ,String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
        this.imgPath=imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
