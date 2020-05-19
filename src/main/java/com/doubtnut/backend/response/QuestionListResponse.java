package com.doubtnut.backend.response;

import java.util.List;

import com.doubtnut.backend.model.RelatedQuestion;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionListResponse extends BaseResponse {

	@JsonProperty("data")
	private List<RelatedQuestion> questionList;

	public List<RelatedQuestion> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<RelatedQuestion> questionList) {
		this.questionList = questionList;
	}

}
