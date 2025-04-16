package com.proyecto.proyectointermodular.models;

import java.math.BigDecimal;

public class Postulacion {
    private Empresa empresa;
    private Contrato contrato;
    private BigDecimal propuestaImporte;
    private String resultado;

    public Postulacion() {
        this.empresa = new Empresa();
        this.contrato = new Contrato();
        this.propuestaImporte = BigDecimal.ZERO;
        this.resultado = "";
    }
    public Postulacion(Empresa empresa, Contrato contrato, BigDecimal propuestaImporte, String resultado) {
        this.empresa = empresa;
        this.contrato = contrato;
        this.propuestaImporte = propuestaImporte;
        this.resultado = resultado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public BigDecimal getPropuestaImporte() {
        return propuestaImporte;
    }

    public void setPropuestaImporte(BigDecimal propuestaImporte) {
        this.propuestaImporte = propuestaImporte;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Empresa: " + empresa.getNombre() +
                ", Contrato: " + contrato.getTitulo() +
                ", Propuesta: " + propuestaImporte + " €" +
                ", Resultado: " + resultado;
    }
}
