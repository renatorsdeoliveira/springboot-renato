package br.edu.fasam.tcc.renato.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "PhotoQL")
public class PhotoQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}
