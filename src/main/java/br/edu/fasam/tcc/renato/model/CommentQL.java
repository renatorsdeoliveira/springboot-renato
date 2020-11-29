package br.edu.fasam.tcc.renato.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "CommentQL")
public class CommentQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer postId;
    private String name;
    private String email;
    private String body;

}
