package com.kcwebapply.api.springapi.controller.resource;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryEnum {

    JP("JP"),

    US("US"),

    @JsonEnumDefaultValue
    NULL(null);

    private String code;

}