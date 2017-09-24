package test;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/12.
 */
public class Book implements Serializable {
    private String title;

    public Book() {
    }

    public Book(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private  float price;
}
