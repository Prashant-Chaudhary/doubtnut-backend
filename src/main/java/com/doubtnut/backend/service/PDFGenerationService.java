package com.doubtnut.backend.service;

import java.util.List;

import com.doubtnut.backend.model.RelatedQuestion;

public interface PDFGenerationService {
	public long generatePDF(List<RelatedQuestion> list);
}
