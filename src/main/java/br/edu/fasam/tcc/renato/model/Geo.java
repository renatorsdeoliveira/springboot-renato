package br.edu.fasam.tcc.renato.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Geo {
    private String lat;
    private String lng;

}
