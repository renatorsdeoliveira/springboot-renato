package br.edu.fasam.tcc.renato.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS")
@ApiModel(value = "Address", description = "Informações sobre a tabela address.")
public class Address {

    @Column(name = "STREET")
    @ApiModelProperty(value = "street")
    private String street;

    @Column(name = "SUITE")
    @ApiModelProperty(value = "suite")
    private String suite;

    @Column(name = "CITY")
    @ApiModelProperty(value = "city")
    private String city;

    @Column(name = "ZIPCODE")
    @ApiModelProperty(value = "zipcode")
    private String zipcode;

    @OneToOne
    @Column(name = "GEO")
    @ApiModelProperty(value = "geo")
    private Geo geo;
}
