package com.usa.bicipool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author CarlinGebyte
 */
@Entity
@Table(name = "score")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Score implements Serializable {
    /**
     * Atributo Id de la calificación
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idScore;

    /**
     * Atributo mensaje
     */
    @NotNull
    @NotBlank
    @Column(name = "message")
    private String message;

    /**
     * Atributo score/calificación
     */
    @NotNull
    @Column(name = "score")
    private Integer score;
    
    @ManyToOne
    @JoinColumn(name="serial")
    @JsonIgnoreProperties({"scores","favorites","reservations","owner"})
    private Bike bike;

}
