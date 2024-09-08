package com.airgear.search.repository.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

public record DataSaveRequest(

        @NotNull(message = "json data can not be null")
        Map<String, Object> jsonData,

        @NotBlank(message = "collection name can not be blank")
        String collectionName

) {
}
