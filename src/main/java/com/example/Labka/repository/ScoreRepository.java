package com.example.Labka.repository;

import com.example.Labka.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    Score findByUserIdAndExamId(Long userId, Long examId);
}
