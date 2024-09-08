package com.airgear.search.repository.service;

import java.util.Map;

public interface Data {

    Map<String, Object> save(Map<String, Object> jsonData, String collectionName);

}
