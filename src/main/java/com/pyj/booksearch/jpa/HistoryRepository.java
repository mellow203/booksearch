package com.pyj.booksearch.jpa;

import com.pyj.booksearch.dto.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
