package br.com.faculdadedonaduzzi.lab.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private String prazo;


    private Date dataPrevisao;

    public Task(String titulo, String descricao, TaskStatus status, String prazo, Date dataPrevisao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prazo = prazo;
        this.dataPrevisao = dataPrevisao;
    }

    public Task(){}
}