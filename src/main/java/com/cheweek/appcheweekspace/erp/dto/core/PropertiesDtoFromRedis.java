package com.cheweek.appcheweekspace.erp.dto.core;

public class PropertiesDtoFromRedis {
    private String isActive ;
    private String propertyCode ;
    private String propertyKey ;
    private String propertyValue ;

    public PropertiesDtoFromRedis(String isActive, String propertyCode, String propertyKey, String propertyValue, String propertyValueEn, String propertyValueRu, String orderNo) {
        this.isActive = isActive;
        this.propertyCode = propertyCode;
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
        this.propertyValueEn = propertyValueEn;
        this.propertyValueRu = propertyValueRu;
        this.orderNo = orderNo;
    }

    private String propertyValueEn ;
    private String propertyValueRu ;
    private String orderNo ;

    public PropertiesDtoFromRedis() {
    }

    @Override
    public String toString() {
        return "PropertiesDtoFromRedis{" +
                "isActive='" + isActive + '\'' +
                ", propertyCode='" + propertyCode + '\'' +
                ", propertyKey='" + propertyKey + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                ", propertyValueEn='" + propertyValueEn + '\'' +
                ", propertyValueRu='" + propertyValueRu + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public void setPropertyValueEn(String propertyValueEn) {
        this.propertyValueEn = propertyValueEn;
    }

    public void setPropertyValueRu(String propertyValueRu) {
        this.propertyValueRu = propertyValueRu;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public String getPropertyValueEn() {
        return propertyValueEn;
    }

    public String getPropertyValueRu() {
        return propertyValueRu;
    }

    public String getOrderNo() {
        return orderNo;
    }
}
