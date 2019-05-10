package com.cloudp.entity;

public class Book {
    private String id;
    private String book_name;
    private String book_author;
    private String book_type;
    private String book_published;
    private String published_time;
    private String book_price;
    private String img_src;
    private String url;
    private String book_status;
    private String book_seller;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_type='" + book_type + '\'' +
                ", book_published='" + book_published + '\'' +
                ", published_time='" + published_time + '\'' +
                ", book_price='" + book_price + '\'' +
                ", img_src='" + img_src + '\'' +
                ", url='" + url + '\'' +
                ", book_status='" + book_status + '\'' +
                ", book_seller='" + book_seller + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_published() {
        return book_published;
    }

    public void setBook_published(String book_published) {
        this.book_published = book_published;
    }

    public String getPublished_time() {
        return published_time;
    }

    public void setPublished_time(String published_time) {
        this.published_time = published_time;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBook_status() {
        return book_status;
    }

    public void setBook_status(String book_status) {
        this.book_status = book_status;
    }

    public String getBook_seller() {
        return book_seller;
    }

    public void setBook_seller(String book_seller) {
        this.book_seller = book_seller;
    }

    public Book(String id, String book_name, String book_author, String book_type, String book_published, String published_time, String book_price, String img_src, String url, String book_status, String book_seller) {
        this.id = id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_type = book_type;
        this.book_published = book_published;
        this.published_time = published_time;
        this.book_price = book_price;
        this.img_src = img_src;
        this.url = url;
        this.book_status = book_status;
        this.book_seller = book_seller;
    }
}
