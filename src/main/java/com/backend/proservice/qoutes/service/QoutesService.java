package com.backend.proservice.qoutes.service;

import java.util.List;
import java.util.Map;

import com.backend.proservice.qoutes.entity.AuthorsEntity;
import com.backend.proservice.qoutes.entity.QoutesContentEntity;
import com.backend.proservice.qoutes.entity.StatsEntity;
import com.backend.proservice.qoutes.entity.TopicsEntity;

public interface QoutesService {
	void saveQoutes(Map<String, Object> reqBody);
	List<QoutesContentEntity> getTopHundredQoutes();
	List<AuthorsEntity> getAuthors();
	List<TopicsEntity> getTopics();
	List<QoutesContentEntity> getQoutesByAuthorID(String authorId);
	List<QoutesContentEntity> getQoutesByTopicID(String topicId);
	List<QoutesContentEntity> searchGlobalInQoutes(String searchedKeyword);
	void saveStats();
	List<StatsEntity> getStats();
}
