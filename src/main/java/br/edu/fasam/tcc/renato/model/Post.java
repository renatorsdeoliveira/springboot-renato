package br.edu.fasam.tcc.renato.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POST")
@ApiModel(value = "Post", description = "Informações sobre a tabela post.")
public class Post extends DefaultModel {

    @NotNull(message = "Informe o código do user.")
    @ApiModelProperty(value="userId")
    @Column(name = "USERID")
    private Integer userId;

    @Column(name = "TITLE")
    @ApiModelProperty(value="title")
    private String title;

    @Column(name = "BODY")
    @ApiModelProperty(value="body")
    private String body;

}
