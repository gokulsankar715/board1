package com.example.elastic.demo.Controller;

import java.net.InetAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elastic.demo.Advice.TrackLogging;
import com.example.elastic.demo.Model.Elastic;
import com.example.elastic.demo.Model.ElasticSwagger;
import com.example.elastic.demo.Repositary.ElastiJpaRepasitary;
import com.example.elastic.demo.Repositary.ElasticRepositary;

@RestController
@RequestMapping("/swagger")
public class ElasticSwaggerController {

	@Autowired
	private ElastiJpaRepasitary elastiJpaRepo;

	@Autowired
	private ElasticRepositary elasticRepo;

	String hostname = null;
	InetAddress addr;

	@TrackLogging
	@PostMapping("/saveElastic")

	public void addElastic(@RequestBody ElasticSwagger swa) {
		elastiJpaRepo.save(swa);
	}

	@GetMapping("/getElasticId/{id}")
	public Elastic getElasticFirstname(@PathVariable int id) {
		return elasticRepo.findById(id).get();
	}

	@GetMapping("/getAllDetails")
	public List<ElasticSwagger> getAllDetails() {
		return elastiJpaRepo.findAll();
	}

	@TrackLogging
	@GetMapping("/getFirstname/{firstname}")
	@Cacheable(value = "elasticswaggers", key = "#firstname")
	public List<ElasticSwagger> getFirstname(@PathVariable String firstname) {
		System.out.println("Entry");
		return elastiJpaRepo.findByFirstname(firstname);
	}

	@DeleteMapping("/deleteFirstname/{id}")
	public void deleteByUserName(@PathVariable int id) {
		elastiJpaRepo.deleteById(id);
	}

	@PostMapping("/save")
	public int addElastic(@RequestBody Elastic elastic) {
		elasticRepo.save(elastic);
		return 1;

	}

	public String getAd(String id) {
		switch (id) {
		case "1":
			return "Gokul";
		case "2":
			return "Sankar";
		case "3":
			return "Babu";
		default:
			return "Unknown";
		}
	}

}
