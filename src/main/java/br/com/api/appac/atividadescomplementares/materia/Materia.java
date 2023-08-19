package br.com.api.appac.atividadescomplementares.materia;

import java.math.BigDecimal;

import br.com.api.appac.atividadescomplementares.semestre.Semestre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materia")
@Getter
@Setter
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;
}

