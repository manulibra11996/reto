package com.certidevs.reto.entities;

import jakarta.persistence.*;

@Entity // indica que esta clase es una tabla
@Table(name = "Tareas") // personaliza el nombre de la tabla
public class Tarea {
    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private Boolean completada;
    @ManyToOne
    private Proyecto proyecto;

    public Tarea() {

    }

    public Tarea(String titulo, String descripcion, Boolean completada, Proyecto proyecto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
        this.proyecto = proyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "La tarea cuyo id es " + id + " tiene el titulo " + titulo + " tiene la descripción de " + descripcion +
                (completada?" y esta completada.":" y no esta completada.") +
                ". Teniendo estos proyectos: " + proyecto.toString();
    }
}
