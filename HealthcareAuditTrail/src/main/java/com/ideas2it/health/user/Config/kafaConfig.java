package com.ideas2it.health.user.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ideas2it.health.patient.Dto.PatientAuditDto;
import com.ideas2it.health.user.Dto.UserAuditDto;
import com.ideas2it.health.vital.signs.Dto.VitalSignAuditDto;

@EnableKafka
@Configuration
public class kafaConfig {

	@Bean
	public ConsumerFactory<String, UserAuditDto> healthconsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_healthuser");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(UserAuditDto.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserAuditDto> healthkafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UserAuditDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(healthconsumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, PatientAuditDto> patientconsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_healthpatient");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(PatientAuditDto.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PatientAuditDto> patientkafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, PatientAuditDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(patientconsumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, VitalSignAuditDto> vitalconsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_healthvital");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(VitalSignAuditDto.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, VitalSignAuditDto> vitalkafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, VitalSignAuditDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(vitalconsumerFactory());
		return factory;
	}

//	@Bean
//	public ConsumerFactory<String, User> userConsumerFactory(){
//		Map<String, Object> configs = new HashMap<String, Object>();
//		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "first_topic-2");
//		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(),new JsonDeserializer<>(User.class));
//	}

}
