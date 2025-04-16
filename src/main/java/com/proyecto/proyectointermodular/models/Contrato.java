package com.proyecto.proyectointermodular.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Contrato {
    private int id;
    private String titulo;
    private String descripcion;
    private String ambito;
    private BigDecimal importe;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Contrato() {
        // Constructor vacío útil para cuando necesito instanciar
        // y luego usar setters manualmente o desde otras clases como ContratoPais
    }


    public Contrato(int id, String titulo, String descripcion, String ambito,
                    BigDecimal importe, String estado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ambito = ambito;
        this.importe = importe;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}

