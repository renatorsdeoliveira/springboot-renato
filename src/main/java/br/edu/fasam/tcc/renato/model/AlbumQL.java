package br.edu.fasam.tcc.renato.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "AlbumQL")
public class AlbumQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer userId;
    private String title;


}
