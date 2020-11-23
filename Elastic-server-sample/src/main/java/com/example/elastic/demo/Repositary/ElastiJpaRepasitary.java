package com.example.elastic.demo.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elastic.demo.Model.ElasticSwagger;

@Repository
public interface ElastiJpaRepasitary extends JpaRepository<ElasticSwagger, Integer> {

	List<ElasticSwagger> findByFirstname(String firstname);

}
