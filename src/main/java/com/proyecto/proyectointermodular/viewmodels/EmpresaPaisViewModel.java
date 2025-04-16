package com.proyecto.proyectointermodular.viewmodels;

public class EmpresaPaisViewModel {
    private String empresaId;
    private String empresaNombre;
    private String paisId;
    private String paisNombre;

    public EmpresaPaisViewModel(String empresaId, String empresaNombre, String paisId, String paisNombre) {
        this.empresaId = empresaId;
        this.empresaNombre = empresaNombre;
        this.paisId = paisId;
        this.paisNombre = paisNombre;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public String getEmpresaNombre() {
        return empresaNombre;
    }

    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }
}
