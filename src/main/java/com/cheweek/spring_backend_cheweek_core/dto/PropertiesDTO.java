package com.cheweek.spring_backend_cheweek_core.dto;

import com.cheweek.spring_backend_cheweek_core.utility.CoreDto;
import lombok.*;
import lombok.experimental.FieldDefaults;


public class PropertiesDTO  {
   private String isActive ;
    private String propertyCode ;
    private String propertyKey ;
    private String propertyValue ;
    private String propertyValueEn ;
    private String propertyValueRu ;
    private String orderNo ;

    public PropertiesDTO() {
    }

    public PropertiesDTO(String isActive, String propertyCode, String propertyKey, String propertyValue, String propertyValueEn, String propertyValueRu, String orderNo) {
        this.isActive = isActive;
        this.propertyCode = propertyCode;
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
        this.propertyValueEn = propertyValueEn;
        this.propertyValueRu = propertyValueRu;
        this.orderNo = orderNo;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValueEn() {
        return propertyValueEn;
    }

    public void setPropertyValueEn(String propertyValueEn) {
        this.propertyValueEn = propertyValueEn;
    }

    public String getPropertyValueRu() {
        return propertyValueRu;
    }

    public void setPropertyValueRu(String propertyValueRu) {
        this.propertyValueRu = propertyValueRu;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
