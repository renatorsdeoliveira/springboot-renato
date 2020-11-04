package br.edu.fasam.tcc.renato.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TODO")
@ApiModel(value = "Todo", description = "Informações sobre a tabela todo")
public class Todo {

    @Id
    @Column(name = "name")
    @ApiModelProperty(value = "id")
    @GeneratedValue(generator = "SEQCOMMENT", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "SEQCOMMENT", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator" )
    private Integer id;


    @NotNull(message = "Informe o código do todo.")
    @Column(name = "USERID")
    @ApiModelProperty(value = "userId")
    private Integer userId;

    @Column(name = "TITLE")
    @ApiModelProperty(value = "title")
    private String title;

    @Column(name = "BOOLEAN")
    @ApiModelProperty(value = "boolean")
    private Boolean completed;
}
