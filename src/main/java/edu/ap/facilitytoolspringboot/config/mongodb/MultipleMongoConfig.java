package edu.ap.facilitytoolspringboot.config.mongodb;

import com.mongodb.MongoClient;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {
    private final MultipleMongoProperties mongoProperties;

    public MultipleMongoConfig(MultipleMongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    public MongoTemplate locatieMongoTemplate() throws Exception {
        return new MongoTemplate(locatieFactory(this.mongoProperties.getLocation()));
    }

    public MongoTemplate meldingMongoTemplate() throws Exception {
        return new MongoTemplate(meldingFactory(this.mongoProperties.getMelding()));
    }

    public MongoTemplate categoryMongoTemplate() throws Exception {
        return new MongoTemplate(categoryFactory(this.mongoProperties.getCategory()));
    }

    public MongoDbFactory locatieFactory(final MongoProperties mongo) throws Exception {
        return (MongoDbFactory) new MongoClient("127.0.0.1", 27017);
    }

    public MongoDbFactory meldingFactory(final MongoProperties mongo) throws Exception {
        return (MongoDbFactory) new MongoClient("127.0.0.1", 27017);
    }

    public MongoDbFactory categoryFactory(final MongoProperties mongo) throws Exception {
        return (MongoDbFactory) new MongoClient("127.0.0.1", 27017);
    }

}