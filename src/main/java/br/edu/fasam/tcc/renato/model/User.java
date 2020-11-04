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
public class User {

    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "id")
    @GeneratedValue(generator = "SEQCOMMENT", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "SEQCOMMENT", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    private Integer id;


    @Column(name = "NAME")
    @ApiModelProperty(value = "name")
    private String name;

    @Column(name = "USERNAME")
    @ApiModelProperty(value = "username")
    private String username;

    @Column(name = "EMAIL")
    @ApiModelProperty(value = "email")
    private String email;

    @OneToOne
    @Column(name = "ADDRESS")
    @ApiModelProperty(value = "address")
    private Address address;

}

