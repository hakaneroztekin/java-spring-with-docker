package com.hakaneroztekin.javaspringwithdocker.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("ClickCount")
@Builder
@Data
public class ClickCount {
    @Id
    private String id;
    private long count;
}
