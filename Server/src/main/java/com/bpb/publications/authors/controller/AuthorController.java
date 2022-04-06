package com.bpb.publications.authors.controller;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bpb.publications.authors.exception.ErrorMessage;
import com.bpb.publications.authors.exception.NoRecordsException;
import com.bpb.publications.authors.service.AuthorService;
import com.bpb.publications.authors.vo.AuthorVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "manage authors", description = "This controller contains all the endpoints that can manage author information", tags = "Author Info, Manage Author")
@Validated
@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@ApiOperation(value = "Get Author Details by Name and URL", response = ResponseEntity.class, notes = "This is the notes section to describe detailed information", tags = "Fetch details of author using Name and URL", nickname = "/author")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"),
			@ApiResponse(code = 401, message = "You are not authorized to access the API"),
			@ApiResponse(code = 403, message = "You don't have the proper roles to access the API"),
			@ApiResponse(code = 404, message = "No records")})
	@RequestMapping(method = RequestMethod.GET, name = "Get Author By Name and URL", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthor(@RequestParam(name = "name") String name, @RequestParam(name = "url") String url) {
		return new ResponseEntity<>(authorService.get(name, url), HttpStatus.OK);
		
	}
	
	@GetMapping(name = "Get Author By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthorbyId(@PathVariable @Positive(message = "Invalid ID") int id) {
		return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(name = "Add Author", value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAuthor(@RequestBody @Valid AuthorVO authorVO) {
		return new ResponseEntity<>(authorService.add(authorVO), HttpStatus.OK);
	}
	
	@GetMapping(name = "Get Authors", value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthors() {
		return new ResponseEntity<>(authorService.getALL(), HttpStatus.OK);
	}
}
