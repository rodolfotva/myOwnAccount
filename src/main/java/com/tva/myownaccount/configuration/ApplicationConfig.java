package com.tva.myownaccount.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

@Configuration
@ComponentScan(basePackages = "com.tva.myownaccount")
@EnableMongoRepositories({"com.tva.myownaccount.repositorie"})
public class ApplicationConfig {

  @Bean
  public MongoDbFactory mongoDbFactory() throws Exception {
	  
	String user = System.getenv("MONGODB_USERNAME");
	String pass = System.getenv("MONGODB_PASS");
	String server00 = System.getenv("MONGODB_SERVER00");
	String server01 = System.getenv("MONGODB_SERVER01");
	String server02 = System.getenv("MONGODB_SERVER02");
	Integer port = Integer.valueOf(System.getenv("MONGODB_PORT"));

	List<ServerAddress> saList = new ArrayList<>();
	saList.add(new ServerAddress(server00, port));
	saList.add(new ServerAddress(server01, port));
	saList.add(new ServerAddress(server02, port));

    char[] pwd = pass.toCharArray();

    MongoCredential credential = MongoCredential.createCredential(user, "admin", pwd);
    MongoClientOptions options = MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred()).retryWrites(true).requiredReplicaSetName("Cluster0-shard-0")
        .maxConnectionIdleTime(6000).sslEnabled(true).build();

    MongoClient mongoClient = new MongoClient(saList, credential, options);
    return new SimpleMongoDbFactory(mongoClient, "myOwnAccount");
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
    return mongoTemplate;
  }

}
