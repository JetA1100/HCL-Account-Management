package com.bpb.publications.authors.vo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorVO implements Serializable {
	@ApiModelProperty(example = "www.example.com", notes = "This is the name of the author", value = "url", dataType = "string")
	@NotEmpty
	private String url;
	@ApiModelProperty(allowableValues = "john, name1", example = "Shagun", notes = "This is the name of the author", value = "name", required = true)
	@NotEmpty
	private String name;
	@NotEmpty
	private String bio;
}
