package com.hakaneroztekin.javaspringwithdocker.repository;

import com.hakaneroztekin.javaspringwithdocker.model.ClickCount;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickCountRepository extends CrudRepository<ClickCount, String> {
}
