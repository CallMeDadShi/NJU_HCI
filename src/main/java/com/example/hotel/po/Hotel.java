package com.example.hotel.po;

import com.example.hotel.enums.BizRegion;

import java.util.List;

public class Hotel {
    private Integer id;
    private String hotelName;
    private String address;
    /**
     * 商圈
     */
    private BizRegion bizRegion;
    private int hotelStar;
    private Double rate;
    private String description;
    private String phoneNum;
    /**
     * 酒店管理员id
     */
    private Integer managerId;
    private List<HistoryComment> historyComments;

    public void setHistoryComment(List<HistoryComment> historyComments) {
        this.historyComments = historyComments;
    }

    public List<HistoryComment> getHistoryComments() {
        return historyComments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BizRegion getBizRegion() {
        return bizRegion;
    }

    public void setBizRegion(BizRegion bizRegion) {
        this.bizRegion = bizRegion;
    }

    public int getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
