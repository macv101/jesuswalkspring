/*package com.jesuswalk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoCredential;


//@Configuration
class MongoConfigurationBeans {

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        mongo.setPort(27017);
        MongoCredential[] credentials = { MongoCredential.createCredential("", "JesusWalk", "".toCharArray())};
        mongo.setCredentials(credentials);
        return mongo;
    }
    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "JesusWalk");
    }
}
*/