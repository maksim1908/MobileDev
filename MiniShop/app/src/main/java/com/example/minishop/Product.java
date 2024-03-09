package com.example.minishop;

import java.util.Objects;
import java.io.Serializable;
public class Product implements Serializable {
    private int id;
    private String title;
    private double price;
    private int productImage;
    private boolean isActivated;

    public Product(){
        id=0;
        this.title = "DefaultTitle";
        this.price = 0;
        this.isActivated = false;
    }

    public Product(int id,String title,double price,int productImage){
        this.id=id;
        this.title = title;
        this.price = price;
        this.productImage = productImage;
        this.isActivated = false;
    }

    public  int getId() {
        return id;
    }

    public boolean isActivated(){
        return this.isActivated;
    }
    public void setActivated(boolean isActivated){
        this.isActivated = isActivated;
    }
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
    public int getProductImage() {
        return productImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    /*public void setProductImage(int productImage){this.productImage = productImage;}*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", productImage=" + productImage +
                ", isActivated=" + isActivated +
                '}';
    }
}
