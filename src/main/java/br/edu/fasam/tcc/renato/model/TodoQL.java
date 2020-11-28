package br.edu.fasam.tcc.renato.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "TodoQL")
public class TodoQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer userId;
    private String title;
    private Boolean completed;

}
