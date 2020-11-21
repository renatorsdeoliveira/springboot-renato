package br.edu.fasam.tcc.renato.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class DefaultModel {

    @Id
    @ApiModelProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

}
