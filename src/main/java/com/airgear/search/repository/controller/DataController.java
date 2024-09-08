package com.airgear.search.repository.controller;

import com.airgear.search.repository.request.DataSaveRequest;
import com.airgear.search.repository.service.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {

    private final Data dataOperations;

    public DataController(Data dataOperations) {
        this.dataOperations = dataOperations;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Object>> saveData(@RequestBody @Valid DataSaveRequest request,
                                                        UriComponentsBuilder ucb) {
        Map<String, Object> save = dataOperations.save(request.jsonData(), request.collectionName());
        return ResponseEntity
                .created(ucb.path("/messages/{id}/{collectionName}").build(save.get("_id"), request.collectionName()))
                .body(save);
    }
}
