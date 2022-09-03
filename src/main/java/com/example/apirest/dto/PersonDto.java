package com.example.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    @NotEmpty(message = "The name is required!")
    private String name;

    @NotEmpty(message = "The last name is required!")
    private String lastname;


}
