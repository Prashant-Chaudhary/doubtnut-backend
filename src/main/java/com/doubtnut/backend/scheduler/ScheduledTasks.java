package com.doubtnut.backend.scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.doubtnut.backend.logger.DBLogger;
import com.doubtnut.backend.model.LastAPIRelatedQuestion;
import com.doubtnut.backend.service.PDFGenerationService;
import com.doubtnut.backend.util.InactivityUtils;

@Component
public class ScheduledTasks {
	/*
	 * CLASS_NAME contains name of the class to append in logger information.
	 */
	private static final Class<?> CLASS_NAME = ScheduledTasks.class;

	@Autowired
	protected PDFGenerationService pdfGenerationService;

	@Scheduled(cron = "0 0/1 * 1/1 * ?") 
	public void sendRoomAssignNotification() {
		DBLogger.info(CLASS_NAME, "PDF Generation Started .... Checking for Last API requests ");
		System.out.println(LocalDateTime.now());
		List<Long> inactiveUserIdList = new ArrayList<Long>();
		long currentMili = System.currentTimeMillis();
		for (Map.Entry<Long, LastAPIRelatedQuestion> item : InactivityUtils.lastRequestList.entrySet()) {
			System.out.println(TimeUnit.MILLISECONDS.toMinutes(currentMili - item.getValue().getTimestamp()));
			if (TimeUnit.MILLISECONDS.toMinutes(currentMili - item.getValue().getTimestamp()) >= 5) {
				pdfGenerationService.generatePDF(item.getValue().getRelatedQuestionList() , item.getKey());
				inactiveUserIdList.add(item.getKey());
			}
		}
		InactivityUtils.removeUserIds(inactiveUserIdList);
		DBLogger.info(CLASS_NAME, "PDF Generation Completed .. PDFs are stored in the pdfs folder.");
	}

}
