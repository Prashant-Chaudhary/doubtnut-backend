package com.doubtnut.backend.service;

import java.util.List;

import com.doubtnut.backend.model.RelatedQuestion;
import com.doubtnut.backend.request.RelatedQuestionRequest;
import com.doubtnut.backend.response.QuestionListResponse;

public interface PDFGenerationService {
	public long generatePDF(List<RelatedQuestion> list, Long userId);

	public long addQuestion(RelatedQuestion relatedQuestionRequest);

	public QuestionListResponse getQuestion();

	public long processRequest(RelatedQuestionRequest relatedQuestionRequest);
}
