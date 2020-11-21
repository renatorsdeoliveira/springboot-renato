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
@Table(name = "PHOTO")
@ApiModel(value = "Photo", description = "Informações sobre a tabela photo.")
public class Photo extends DefaultModel {

    @NotNull(message = "Informe o código do photo.")
    @Column(name = "ALBUMID")
    @ApiModelProperty(value="albumId")
    private Integer albumId;

    @Column(name = "TITLE")
    @ApiModelProperty(value="title")
    private String title;

    @Column(name = "URL")
    @ApiModelProperty(value="url")
    private String url;

    @Column(name = "THUMBNAIURL")
    @ApiModelProperty(value="thumbnailUrl")
    private String thumbnailUrl;

}
