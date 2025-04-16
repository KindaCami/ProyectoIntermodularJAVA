package com.proyecto.proyectointermodular.models;

public class EmpresaPais {
   private String empresaId;
   private String paisId;

   public EmpresaPais(){
       this.empresaId = "";
       this.paisId = "";

   }

    public EmpresaPais(String empresaId, String paisId) {
        this.empresaId = empresaId;
        this.paisId = paisId;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }
}
