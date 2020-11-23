package com.example.elastic.demo.Repositary;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elastic.demo.Model.Elastic;

public interface ElasticRepositary extends ElasticsearchRepository<Elastic, Integer> {

	Elastic findByFirstname(String firstname);

}
