package com.henri.apicomics.marvel.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicsDataResponse {

	private ComicsResultsResponse data;

	public ComicsDataResponse(@JsonProperty("data") ComicsResultsResponse data) {
		this.data = data;
	}
	public ComicsResultsResponse getData() {
		return data;
	}

}
