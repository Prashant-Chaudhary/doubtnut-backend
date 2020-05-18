package com.doubtnut.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedQuestion {

	@JsonProperty("id")
	long id;

	@JsonProperty("question_text")
	String question;

	/**
	 * @param id
	 * @param question
	 */
	public RelatedQuestion(long id, String question) {
		super();
		this.id = id;
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
