package com.proyecto.proyectointermodular.models;

import java.math.BigDecimal;

public class Pais {
    private String id;
    private String nombre;
    private BigDecimal presupuestoTotal;
    private BigDecimal presupuestoAsignado;

    public Pais(String id, String nombre, BigDecimal presupuestoTotal, BigDecimal presupuestoAsignado) {
        this.id = id;
        this.nombre = nombre;
        this.presupuestoTotal = presupuestoTotal;
        this.presupuestoAsignado = presupuestoAsignado;
    }
    public Pais() {

  this.id = "";
  this.nombre = "";
  this.presupuestoTotal = BigDecimal.ZERO;
  this.presupuestoAsignado = BigDecimal.ZERO;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public void setPresupuestoTotal(BigDecimal presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
    }

    public BigDecimal getPresupuestoAsignado() {
        return presupuestoAsignado;
    }

    public void setPresupuestoAsignado(BigDecimal presupuestoAsignado) {
        this.presupuestoAsignado = presupuestoAsignado;
    }
}