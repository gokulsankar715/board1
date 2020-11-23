package com.example.elastic.demo.Model;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "elatic-db", shards = 2)
public class Elastic {
	@Id
	private int id;
	private String firstname;

}
