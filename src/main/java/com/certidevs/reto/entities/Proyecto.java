package com.certidevs.reto.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // indica que esta clase es una tabla
@Table(name = "Proyectos") // personaliza el nombre de la tabla
public class Proyecto {
    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private Boolean activo;

    public Proyecto() {

    }

    public Proyecto(String nombre, String descripcion, LocalDate fechaInicio, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "El proyecto con el id " + id + " cuyo nombre es " + nombre + " teniendo de descripción " + descripcion
                + ", teniendo la fecha de inicio " + fechaInicio + (activo?" y esta activo.":" y no esta activo.");
    }
}
