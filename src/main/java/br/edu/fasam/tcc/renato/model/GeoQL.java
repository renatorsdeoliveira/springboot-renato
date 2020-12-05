package br.edu.fasam.tcc.renato.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GeoQL")
public class GeoQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lat;
    private String lng;

}
