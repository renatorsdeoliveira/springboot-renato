package br.edu.fasam.tcc.renato.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMMENT")
@ApiModel(value = "Comment", description = "Informações sobre a tabela comment.")
public class Comment {

    @Id
    @Column(name = "ID")
    @ApiModelProperty(value="id")
    @GeneratedValue(generator = "SEQCOMMENT", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name="SEQCOMMENT", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    private Integer id;

    @NotNull(message = "Informe o código do post.")
    @Column(name = "POSTID")
    @ApiModelProperty(value="postId")
    private Integer postId;

    @Column(name = "NAME")
    @ApiModelProperty(value="name")
    private String name;

    @Column(name = "EMAIL")
    @ApiModelProperty(value="email")
    private String email;

    @Column(name = "BODY")
    @ApiModelProperty(value="body")
    private String body;

}
