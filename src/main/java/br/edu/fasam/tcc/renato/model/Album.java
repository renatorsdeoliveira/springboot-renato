package br.edu.fasam.tcc.renato.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ALBUM")
@ApiModel(value = "Album", description = "Informações sobre a tabela album.")
public class Album extends DefaultModel {

    @NotNull(message = "Informe o código do Album.")
    @Column(name = "USERID")
    @ApiModelProperty(value="userId")
    private Integer userId;

    @Column(name = "TITLE")
    @ApiModelProperty(value="title")
    private String title;


}
