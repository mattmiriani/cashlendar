package com.matt.cashlendar.entrypoint.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestHttpModel {

    @JsonAlias({"name"})
    private String name;
    @JsonAlias({"email"})
    private String email;
    @JsonAlias({"password"})
    private String password;

}
