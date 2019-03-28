package com.kcwebapply.api.springapi.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleBody implements Serializable {

    private String id;

    private CountryEnum country;
}
