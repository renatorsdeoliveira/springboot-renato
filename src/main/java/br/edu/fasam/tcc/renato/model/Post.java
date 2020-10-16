package br.edu.fasam.tcc.renato.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Integer userId;
    private Integer id;
    private String tittle;
    private String body;

}
