package com.usa.bicipool.interfaces;

import com.usa.bicipool.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreCrud extends JpaRepository<Score, Integer> {
}
