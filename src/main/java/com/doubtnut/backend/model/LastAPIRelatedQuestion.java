package com.doubtnut.backend.model;

import java.util.List;

public class LastAPIRelatedQuestion {

	private long userId;

	private long timestamp;

	private List<RelatedQuestion> relatedQuestionList;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<RelatedQuestion> getRelatedQuestionList() {
		return relatedQuestionList;
	}

	public void setRelatedQuestionList(List<RelatedQuestion> relatedQuestionList) {
		this.relatedQuestionList = relatedQuestionList;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
