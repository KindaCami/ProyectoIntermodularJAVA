package com.proyecto.proyectointermodular.models;

import java.math.BigDecimal;

public class ContratoPais {
    private Contrato contrato;
    private Pais pais;
    private BigDecimal aporte;

    // Constructor vacío
    public ContratoPais() {
        this.contrato = new Contrato();
        this.pais = new Pais();
        this.aporte = BigDecimal.ZERO;

    }
  //Contructor completo
    public ContratoPais(Contrato contrato, Pais pais, BigDecimal aporte) {
        this.contrato = contrato;
        this.pais = pais;
        this.aporte = aporte;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public BigDecimal getAporte() {
        return aporte;
    }

    public void setAporte(BigDecimal aporte) {
        this.aporte = aporte;
    }

    @Override
    public String toString() {
        return "Contrato: " + contrato.getTitulo() +
                ", País: " + pais.getNombre() +
                ", Aporte: " + aporte + "€";
    }
}
