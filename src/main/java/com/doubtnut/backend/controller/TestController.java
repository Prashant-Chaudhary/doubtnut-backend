package com.doubtnut.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtnut.backend.request.RelatedQuestionRequest;
import com.doubtnut.backend.response.BaseResponse;
import com.doubtnut.backend.service.PDFGenerationService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/test")
@Api(value = "Doubtnut Test Resource")
public class TestController {
	
	@Autowired
	protected PDFGenerationService pdfGenerationService;
	
	@PostMapping("/related-questions")
	public BaseResponse updateRoomNo(@RequestBody RelatedQuestionRequest relatedQuestionRequest) {
		BaseResponse response = new BaseResponse();
		setResponseStatus(response, 1, "Request Registered");
		long requestId = pdfGenerationService.generatePDF(relatedQuestionRequest.getList());
		response.setRequestId(requestId+"");
		return response;
	}

	private static void setResponseStatus(BaseResponse response, int status, String message) {
		response.setMessage(message);
		response.setStatusCode(status);
	}
}
