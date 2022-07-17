package com.gql.gqladdressservice;

import com.apollographql.federation.graphqljava.Federation;
import com.apollographql.federation.graphqljava._Entity;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLSchema customSchema(SchemaParser schemaParser){
        return Federation.transform(schemaParser.makeExecutableSchema())
                .fetchEntities(env -> env.<List<Map<String, Object>>>getArgument(_Entity.argumentName)
                        .stream()
                        .map(values -> null)
                        .collect(Collectors.toList()))
                .resolveEntityType(env -> null)
                .build();
    }

    @Bean
    public SchemaPrinter customSchemaPrinter(){
        return new SchemaPrinter(SchemaPrinter.Options.defaultOptions().includeDirectives(true).includeDirectiveDefinitions(true).includeSchemaDefinition(true).includeIntrospectionTypes(true));
    }
}