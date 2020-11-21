package br.edu.fasam.tcc.renato.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends DefaultModel {

    private Integer userId;
    private String tittle;
    private String body;

}
