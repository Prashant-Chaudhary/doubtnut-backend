package com.doubtnut.backend.request;

import java.util.List;

import com.doubtnut.backend.model.RelatedQuestion;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedQuestionRequestData {

	@JsonProperty("user_id")
	private long userId;

	@JsonProperty("question")
	private List<RelatedQuestion> list;

	public List<RelatedQuestion> getList() {
		return list;
	}

	public void setList(List<RelatedQuestion> list) {
		this.list = list;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
