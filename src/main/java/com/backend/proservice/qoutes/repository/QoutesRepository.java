package com.backend.proservice.qoutes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.proservice.qoutes.entity.QoutesContentEntity;

@Repository
public interface QoutesRepository extends JpaRepository<QoutesContentEntity, Long> {

	@Query(value="select * from qoutes_content where IS_TOP_HUN='Y'", nativeQuery = true)
    List<QoutesContentEntity> getTopHundredQoutes();
	
	@Query(value="select * from qoutes_content where AUTHOR_ID=:authorId", nativeQuery = true)
    List<QoutesContentEntity> getQoutesByAuthorID(String authorId);
	
	@Query(value="select * from qoutes_content where TOPIC_ID=:topicId", nativeQuery = true)
    List<QoutesContentEntity> getQoutesByTopicID(String topicId);
	
	@Query(value="select * from qoutes_content where LOWER(QOUTES) like LOWER('%' :searchedKeyword '%')", nativeQuery = true)
    List<QoutesContentEntity> searchGlobalInQoutes(String searchedKeyword);
}
