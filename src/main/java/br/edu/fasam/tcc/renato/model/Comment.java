package br.edu.fasam.tcc.renato.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;

}
