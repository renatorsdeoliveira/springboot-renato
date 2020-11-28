package br.edu.fasam.tcc.renato.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "books")
@Where(clause = "is_active = true")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn = UUID.randomUUID().toString();
    private String title;
    private String subject;
    @ManyToOne
    private Author author;
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "is_active")
    private boolean active = true;
}
