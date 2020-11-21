package br.edu.fasam.tcc.renato.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
@ApiModel(value = "User", description = "Informaçções sobre a tabela user")
public class User extends DefaultModel {

    @Column(name = "NAME")
    @ApiModelProperty(value = "name")
    private String name;

    @Column(name = "USERNAME")
    @ApiModelProperty(value = "username")
    private String username;

    @Column(name = "EMAIL")
    @ApiModelProperty(value = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @ApiModelProperty(value = "address")
    private Address address;

}

