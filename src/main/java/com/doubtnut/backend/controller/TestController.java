package com.doubtnut.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtnut.backend.model.RelatedQuestion;
import com.doubtnut.backend.request.RelatedQuestionRequest;
import com.doubtnut.backend.response.BaseResponse;
import com.doubtnut.backend.response.QuestionListResponse;
import com.doubtnut.backend.service.PDFGenerationService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/test")
@Api(value = "Doubtnut Test Resource")
public class TestController {

	@Autowired
	protected PDFGenerationService pdfGenerationService;

	@PostMapping("/related-questions")
	public BaseResponse acceptData(@RequestBody RelatedQuestionRequest relatedQuestionRequest) {
		BaseResponse response = new BaseResponse();
		setResponseStatus(response, 1, "Request Registered");
		long requestId = pdfGenerationService.processRequest(relatedQuestionRequest);
		response.setRequestId(requestId + "");
		return response;
	}

	@PostMapping("/add-questions")
	public BaseResponse addQuestions(@RequestBody RelatedQuestion relatedQuestionRequest) {
		BaseResponse response = new BaseResponse();
		long requestId = pdfGenerationService.addQuestion(relatedQuestionRequest);
		response.setRequestId(requestId + "");
		setResponseStatus(response, 1, "Added Question");
		return response;
	}

	@GetMapping
	public QuestionListResponse getQuestion() {
		QuestionListResponse response = new QuestionListResponse();
		response = pdfGenerationService.getQuestion();
		setResponseStatus(response, 1, "Getting Questions");
		return response;
	}

	private static void setResponseStatus(BaseResponse response, int status, String message) {
		response.setMessage(message);
		response.setStatusCode(status);
	}
}
