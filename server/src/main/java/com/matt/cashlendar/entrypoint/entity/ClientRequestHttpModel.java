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
public class ClientRequestHttpModel {

    @JsonAlias({"clientName"})
    private String name;
    @JsonAlias({"clientEmail"})
    private String email;
    @JsonAlias({"clientPassword"})
    private String password;

}
