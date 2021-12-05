package com.usa.bicipool.repository;

import com.usa.bicipool.interfaces.ScoreCrud;
import com.usa.bicipool.model.Score;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
@Repository
public class ScoreRepository {
    /**
     * Atributo Crud de Score
     */
    private ScoreCrud scoreCrud;

    /**
     * Contructor
     *
     * @param scoreCrud
     */
    public ScoreRepository(ScoreCrud scoreCrud) {
        this.scoreCrud = scoreCrud;
    }

    /**
     * Método para obtener todas las calificaciones
     *
     * @return
     */
    public List<Score> getAll() {
        return scoreCrud.findAll();
    }

    public Optional<Score> getById(Integer idScore) {
        return scoreCrud.findById(idScore);
    }

    /**
     * Método para guardar una calificación
     *
     * @param score
     * @return
     */
    public Score save(Score score) {
        return scoreCrud.save(score);
    }

    /**
     * Método para eliminar una calificación
     *
     * @param idScore
     */
    public void delete(Integer idScore) {
        scoreCrud.deleteById(idScore);
    }
}
