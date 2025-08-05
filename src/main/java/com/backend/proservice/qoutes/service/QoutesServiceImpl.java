package com.backend.proservice.qoutes.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.proservice.qoutes.entity.AuthorsEntity;
import com.backend.proservice.qoutes.entity.QoutesContentEntity;
import com.backend.proservice.qoutes.entity.StatsEntity;
import com.backend.proservice.qoutes.entity.TopicsEntity;
import com.backend.proservice.qoutes.repository.AuthorsRepository;
import com.backend.proservice.qoutes.repository.QoutesRepository;
import com.backend.proservice.qoutes.repository.StatsRepository;
import com.backend.proservice.qoutes.repository.TopicsRepository;
import com.backend.proservice.qoutes.util.GenericService;

@Service
public class QoutesServiceImpl implements QoutesService {
	
	@Autowired
	QoutesRepository qoutesRepo;
	
	@Autowired
	AuthorsRepository authorRepo;
	
	@Autowired
	TopicsRepository topicRepo;
	
	@Autowired
	StatsRepository statsRepo;

	@Override
	public void saveQoutes(Map<String, Object> reqBody) {
		if(reqBody != null) {
			QoutesContentEntity entityQ = new QoutesContentEntity();
			entityQ.setQoutes(GenericService.objToString(reqBody.get("qoutes")));
			entityQ.setAuthorId(GenericService.objToString(reqBody.get("authorId")));
			entityQ.setIstopHun(GenericService.objToString(reqBody.get("istopHun")));
			qoutesRepo.save(entityQ);
			qoutesRepo.flush();
		}
	}

	@Override
	public List<QoutesContentEntity> getTopHundredQoutes() {
		return qoutesRepo.getTopHundredQoutes();
	}
	
	@Override
	public List<AuthorsEntity> getAuthors() {
		return authorRepo.findAll();
	}
	
	@Override
	public List<TopicsEntity> getTopics() {
		return topicRepo.findAll();
	}

	@Override
	public List<QoutesContentEntity> getQoutesByAuthorID(String authorId) {
		return qoutesRepo.getQoutesByAuthorID(authorId);
	}
	
	@Override
	public List<QoutesContentEntity> getQoutesByTopicID(String topicId) {
		return qoutesRepo.getQoutesByTopicID(topicId);
	}
	
	@Override
	public List<QoutesContentEntity> searchGlobalInQoutes(String searchedKeyword) {
		return qoutesRepo.searchGlobalInQoutes(searchedKeyword);
	}
	
	@Override
	public void saveStats() {
		LocalDate todayDate = LocalDate.now();
		Optional<StatsEntity> statusEntity = statsRepo.findById(todayDate);
		if(!statusEntity.isEmpty()) {
			StatsEntity statsEnt = statusEntity.get();
			double updatedCount = statsEnt.getCount() + 1;
			statsEnt.setCount(updatedCount);
			statsRepo.save(statsEnt);
			statsRepo.flush();
		}else {
			StatsEntity statsEntity = new StatsEntity();
			statsEntity.setCountDate(todayDate);
			statsEntity.setCount(1);
			statsRepo.save(statsEntity);
			statsRepo.flush();
		}
	}

}
