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
    String pass = "Xrt2Dr913";
    String user = "rodolfotva";

    List<ServerAddress> saList = new ArrayList<>();
    saList.add(new ServerAddress("cluster0-shard-00-00-fvnbi.mongodb.net", 27017));
    saList.add(new ServerAddress("cluster0-shard-00-01-fvnbi.mongodb.net", 27017));
    saList.add(new ServerAddress("cluster0-shard-00-02-fvnbi.mongodb.net", 27017));

    char[] pwd = pass.toCharArray();

    MongoCredential credential = MongoCredential.createCredential(user, "admin", pwd);
    MongoClientOptions options = MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred()).retryWrites(true).requiredReplicaSetName("Cluster0-shard-0")
        .maxConnectionIdleTime(6000).sslEnabled(true).build();

    MongoClient mongoClient = new MongoClient(saList, credential, options);
    return new SimpleMongoDbFactory(mongoClient, "mybank");
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
    return mongoTemplate;
  }

}
