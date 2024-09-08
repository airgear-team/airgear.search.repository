package com.airgear.search.repository.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import org.bson.Document;
import java.util.Map;

@Service
public class DataOperations implements Data {

    private final MongoTemplate mongoTemplate;

    public DataOperations(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Map<String, Object> save(Map<String, Object> jsonData, String collectionName) {
        Document document = new Document(jsonData);
        return mongoTemplate.save(document, collectionName);
    }
}
