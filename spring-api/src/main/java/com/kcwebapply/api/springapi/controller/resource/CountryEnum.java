package com.kcwebapply.api.springapi.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryEnum {

    JP("JP"),

    US("US");

    private String code;

}