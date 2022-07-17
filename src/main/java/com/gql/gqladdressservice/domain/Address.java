package com.gql.gqladdressservice.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Address {
    Integer userId;
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
}
