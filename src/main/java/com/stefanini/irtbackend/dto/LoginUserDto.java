package com.stefanini.irtbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"email", "password"})
public class LoginUserDto implements Serializable {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}
