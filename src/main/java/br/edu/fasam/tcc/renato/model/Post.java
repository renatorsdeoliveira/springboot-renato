package br.edu.fasam.tcc.renato.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Post {

    private Integer userId;
    @Id
    private Integer id;
    private String tittle;
    private String body;

}
