package com.usa.bicipool.service;

import com.usa.bicipool.model.Score;
import com.usa.bicipool.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
@Service
public class ScoreService {
    /**
     * Atributo reporitorio de calificación
     */
    private ScoreRepository repository;

    /**
     * Constructor
     * @param repository
     */
    public ScoreService(ScoreRepository repository) {
        this.repository = repository;
    }

    /**
     * Método para obtener todas las calificaciones
     * @return
     */
    public List<Score> getAll() {
        return repository.getAll();
    }

    /**
     * Método para guardar una calificación
     * @param score
     * @return
     */
    public Score save(Score score) {
        return repository.save(score);
    }

    /**
     * Método para actualizar una calificación
     * @param score
     * @return
     */
    public Score update(Score score){
        Optional<Score> exist = repository.getById(score.getIdScore());
        if (exist.isPresent()) {
            if(score.getScore()!=null){
            exist.get().setScore(score.getScore());
            }
            if(score.getMessage()!=null){
            exist.get().setMessage(score.getMessage());
            }
            if(score.getBike()!=null){
                exist.get().setBike(score.getBike());
            }
            return repository.save(exist.get());
        } else {
            return score;
        }
    }

    /**
     * Método para eliminar una calificación
     * @param idScore
     */
    public void delete(Integer idScore) {
        repository.delete(idScore);
    }
}
