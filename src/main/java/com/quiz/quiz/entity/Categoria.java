package com.quiz.quiz.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;

    @NotEmpty(message = "No puede estar vacío")
    @Size(min = 10, max=100, message = "Mínimo 10 caracteres, 100 máximo")
    @Column(name = "nomProducto", nullable = false, length = 100)
    private String nomProducto;

    @NotEmpty(message = "No puede estar vacío")
    @Size(min = 10, max=100, message = "Mínimo 10 caracteres, 100 máximo")
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    public Categoria() {}

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
