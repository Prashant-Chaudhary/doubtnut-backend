package com.doubtnut.backend.request;

import java.util.List;

import com.doubtnut.backend.model.RelatedQuestion;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedQuestionRequest {

	@JsonProperty("data")
	List<RelatedQuestion> list;

	public List<RelatedQuestion> getList() {
		return list;
	}

	public void setList(List<RelatedQuestion> list) {
		this.list = list;
	}

}
