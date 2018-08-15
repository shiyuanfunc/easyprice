package com.third.easyprice.bean;

import java.util.Date;

public class Shop {

    private long id ;
    private String productId ;
    private double productPrice ;
    private String productName ;
    private String pictureAdress ;
    private String productAmount  ;
    private Date crtTime ;
    private String source ;
    private String auctionRanking ;
    private String productUrl ;
    private String store ;
    private String productDesc ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPictureAdress() {
        return pictureAdress;
    }

    public void setPictureAdress(String pictureAdress) {
        this.pictureAdress = pictureAdress;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuctionRanking() {
        return auctionRanking;
    }

    public void setAuctionRanking(String auctionRanking) {
        this.auctionRanking = auctionRanking;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productName='" + productName + '\'' +
                ", pictureAdress='" + pictureAdress + '\'' +
                ", productAmount='" + productAmount + '\'' +
                ", crtTime=" + crtTime +
                ", source='" + source + '\'' +
                ", auctionRanking='" + auctionRanking + '\'' +
                ", productUrl='" + productUrl + '\'' +
                ", store='" + store + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
