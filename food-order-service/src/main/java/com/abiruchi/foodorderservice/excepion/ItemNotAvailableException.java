package com.abiruchi.foodorderservice.excepion;

import lombok.Getter;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Getter
public class ItemNotAvailableException extends Exception {
    private String errorCode;
    private String errorMsg;
    public ItemNotAvailableException(String errorCode, String errorMsg) {
        this.errorCode =errorCode;
        this.errorMsg = errorMsg;
    }
}
