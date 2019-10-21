package com.antsdouble.bean;

import java.io.Serializable;

/**
 * @ClassName UserAddress
 * @Description address
 * @date 3/25/2019
 * @Author liyy
 * @Version 1.0
 */
public class UserAddress implements Serializable {

    private static final long serialVersionUID = -5851335916101908155L;
    private  Integer id;
    private  String userAddress;
    private  String userId;
    private  String consignee;
    private  String phoneNum;
    private  String defaultAddress;

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum, String defaultAddress) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.defaultAddress = defaultAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }


    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", defaultAddress='" + defaultAddress + '\'' +
                '}';
    }
}
