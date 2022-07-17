package com.gql.gqladdressservice.resolver;

import com.gql.gqladdressservice.domain.Address;
import graphql.kickstart.tools.GraphQLQueryResolver;
import kong.unirest.JsonObjectMapper;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import static com.gql.gqladdressservice.util.Constants.USER_ENDPOINT;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    public Address address(Integer userId) {
        Address address = new JsonObjectMapper().readValue(Unirest.get(USER_ENDPOINT).routeParam("id", String.valueOf(userId)).asJson().getBody().getObject().getJSONObject("address").toString(), Address.class);
        address.setUserId(userId);
        return address;
    }
}
