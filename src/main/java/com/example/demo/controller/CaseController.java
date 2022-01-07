package com.example.demo.controller;


import com.example.demo.entity.Case;
import com.example.demo.repository.CaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/case")
public class CaseController {

	@Autowired
	private CaseRepository caseRepository;

	@Value("classpath:graphql/schema.graphqls")
	private Resource schemaResource;

	private GraphQL graphQL;
	
	@PostConstruct
	public void loadSchema() throws IOException {

		File schemaFile = schemaResource.getFile();
		TypeDefinitionRegistry reagistry = new graphql.schema.idl.SchemaParser().parse(schemaFile);
		RuntimeWiring wriring = buildWiring();
		GraphQLSchema schema = new  SchemaGenerator().makeExecutableSchema(reagistry, wriring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildWiring() {
    	DataFetcher<List<Case>> fetcher1 = data->{
    		return (List<Case>) caseRepository.findAll();
    	};
    	
    	DataFetcher<Case> fetcher2 = data->{
    		return caseRepository.getById(data.getArgument("id"));
    	};
    	
    	DataFetcher<Case> fetcher3 = data->{
//    		Case cases=Case.builder().build();
    		System.out.println(caseRepository.findAll());
    		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
    		Case cases = mapper.convertValue(data.getArguments(), Case.class);
//    		System.out.println(cases);
       		return caseRepository.save(cases);
    	};
    	
    	
		return RuntimeWiring.newRuntimeWiring().type("Query",
				typeWriting -> typeWriting.dataFetcher("getCaseById", fetcher2).dataFetcher("getAllCases", fetcher1)).type("Mutation",
						typeWriting -> typeWriting.dataFetcher("addCase", fetcher3)).build();		
	}
	
	
	@PostMapping
	public ResponseEntity<Object> getAllCases(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

//	@PostMapping("/addCase")
//	public ResponseEntity<Object> getPersonbyuserName(@RequestBody String query) {
//		ExecutionResult result = graphQL.execute(query);
//		return new ResponseEntity<Object>(result, HttpStatus.OK);
//	}
//	

}
