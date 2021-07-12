package com.henri.apicomics.marvel.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComicsResultsResponse {

	@JsonProperty("results")
	private List<ComicsResponse> results;

	public ComicsResultsResponse(@JsonProperty("results") List<ComicsResponse> results) {
		this.results = results;
	}
	@Deprecated
	public ComicsResultsResponse() {
	}

	public List<ComicsResponse> getResults() {
		return results;
	}
}
