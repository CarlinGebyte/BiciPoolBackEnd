package com.usa.bicipool.controller;

import com.usa.bicipool.model.Score;
import com.usa.bicipool.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CarlinGebyte
 */
@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
    /**
     * Atributo servicio
     */
    private ScoreService service;

    /**
     * Constructor
     * @param service
     */
    public ScoreController(ScoreService service) {
        this.service = service;
    }

    /**
     * Meétodo para obtener todas las calificaciones
     * @return
     */
    @GetMapping("/all")
    public List<Score> getAll() {
        return service.getAll();
    }

    /**
     * Método para crear una calificación
     * @param score
     * @return
     */
    @PostMapping("/save")
    public Score save(@RequestBody Score score) {
        return service.save(score);
    }

    /**
     * Métoo para actualizar una calificación
     * @param score
     * @return
     */
    @PutMapping("/update")
    public Score update(@RequestBody Score score) {
        return service.update(score);
    }

    /**
     * Método para eliminar una calificación
     * @param idScore
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idScore) {
        service.delete(idScore);
    }
}
