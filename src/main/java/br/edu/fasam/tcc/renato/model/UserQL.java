package br.edu.fasam.tcc.renato.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "UserQL")
@Where(clause = "is_active = true")
public class UserQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    @ManyToOne
    private AddressQL address;
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "is_active")
    private boolean active = true;
}
