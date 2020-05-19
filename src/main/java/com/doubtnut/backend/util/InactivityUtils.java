package com.doubtnut.backend.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.doubtnut.backend.model.LastAPIRelatedQuestion;

public class InactivityUtils {

	public static Map<Long, LastAPIRelatedQuestion> lastRequestList = new HashMap<Long, LastAPIRelatedQuestion>();

	public static LastAPIRelatedQuestion getExistingProduct(long id) {
		return lastRequestList.get(id);
	}

	public static void addUpdateAPIList(LastAPIRelatedQuestion lastRequest) {
		lastRequestList.put(lastRequest.getUserId(), lastRequest);

		for (Map.Entry<Long, LastAPIRelatedQuestion> item : lastRequestList.entrySet()) {
			System.out.println(item.getKey() + " :: " + item.getValue().getTimestamp() + " :: "
					+ item.getValue().getRelatedQuestionList().size());
		}
		System.out.println("====================");
	}

	public static void removeUserIds(List<Long> inactiveUserIdList) {
		for (Long i : inactiveUserIdList) {
			lastRequestList.remove(i);
		}

	}

}
