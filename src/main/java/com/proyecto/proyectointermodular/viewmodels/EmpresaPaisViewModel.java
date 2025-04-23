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

    public String getEmpresaId() { return empresaId; }
    public String getEmpresaNombre() { return empresaNombre; }
    public String getPaisId() { return paisId; }
    public String getPaisNombre() { return paisNombre; }

    public void setEmpresaId(String empresaId) { this.empresaId = empresaId; }
    public void setEmpresaNombre(String empresaNombre) { this.empresaNombre = empresaNombre; }
    public void setPaisId(String paisId) { this.paisId = paisId; }
    public void setPaisNombre(String paisNombre) { this.paisNombre = paisNombre; }
}

