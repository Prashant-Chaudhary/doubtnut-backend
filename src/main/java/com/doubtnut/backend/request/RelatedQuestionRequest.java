package com.doubtnut.backend.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedQuestionRequest {

	@JsonProperty("data")
	private RelatedQuestionRequestData data;

	public RelatedQuestionRequestData getData() {
		return data;
	}

	public void setData(RelatedQuestionRequestData data) {
		this.data = data;
	}

}
