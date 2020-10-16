package br.edu.fasam.tcc.renato.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photos {
    private Integer albumId;
    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;

}
