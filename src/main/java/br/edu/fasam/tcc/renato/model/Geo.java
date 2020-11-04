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

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GEO")
@ApiModel(value = "Geo", description = "Informações sobre a geo.")
public class Geo {

    @Column(name = "LAT")
    @ApiModelProperty(value = "lat")
    private String lat;

    @Column(name = "LNG")
    @ApiModelProperty(value = "lng")
    private String lng;

}
