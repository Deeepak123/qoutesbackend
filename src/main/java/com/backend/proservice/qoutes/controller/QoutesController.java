package com.backend.proservice.qoutes.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.proservice.qoutes.entity.AuthorsEntity;
import com.backend.proservice.qoutes.entity.QoutesContentEntity;
import com.backend.proservice.qoutes.entity.StatsEntity;
import com.backend.proservice.qoutes.entity.TopicsEntity;
import com.backend.proservice.qoutes.service.QoutesService;
import com.backend.proservice.qoutes.util.SecurityAPIs;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="api/qoutes/")
public class QoutesController {

	@Autowired
	QoutesService qoutesSer;
	
	@Autowired
	SecurityAPIs securityAPI;
		
	@PostMapping("saveQoutes")
	public ResponseEntity<Map<String, Object>> saveQoutes(@RequestBody  Map<String, Object> reqBody) {
		qoutesSer.saveQoutes(reqBody);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("getTopHundredQoutes")
	public ResponseEntity<List<QoutesContentEntity>> getTopHundredQoutes(HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<QoutesContentEntity> responseList = qoutesSer.getTopHundredQoutes();
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<QoutesContentEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("getAuthors")
	public ResponseEntity<List<AuthorsEntity>> getAuthors(HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<AuthorsEntity> responseList = qoutesSer.getAuthors();
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<AuthorsEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<AuthorsEntity>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<AuthorsEntity>>(HttpStatus.FORBIDDEN);
		}	
	}
	
	@GetMapping("getTopics")
	public ResponseEntity<List<TopicsEntity>> getTopics(HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<TopicsEntity> responseList = qoutesSer.getTopics();
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<TopicsEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<TopicsEntity>>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<List<TopicsEntity>>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("getQoutesByAuthorID")
	public ResponseEntity<List<QoutesContentEntity>> getQoutesByAuthorID(@RequestParam String authorID, HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<QoutesContentEntity> responseList = qoutesSer.getQoutesByAuthorID(authorID);
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<QoutesContentEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("getQoutesByTopicID")
	public ResponseEntity<List<QoutesContentEntity>> getQoutesByTopicID(@RequestParam String topicID, HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<QoutesContentEntity> responseList = qoutesSer.getQoutesByTopicID(topicID);
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<QoutesContentEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("searchGlobalInQoutes")
	public ResponseEntity<List<QoutesContentEntity>> searchGlobalInQoutes(@RequestParam String searchedKeyword, HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<QoutesContentEntity> responseList = qoutesSer.searchGlobalInQoutes(searchedKeyword);
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<QoutesContentEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<List<QoutesContentEntity>>(HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("saveStats")
	public ResponseEntity<Map<String, Object>> saveStats(@RequestBody Map<String, Object> body, HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			qoutesSer.saveStats();
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/getStats")
    public ResponseEntity<List<StatsEntity>> getLast30DaysStats(HttpServletRequest httpReq) {
		if(securityAPI.verifyToken(httpReq)) {
			List<StatsEntity> responseList = qoutesSer.getStats();
			if(responseList != null && !responseList.isEmpty()) {
				return new ResponseEntity<List<StatsEntity>>(responseList, HttpStatus.OK);
			}
			return new ResponseEntity<List<StatsEntity>>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
    }
	
}
