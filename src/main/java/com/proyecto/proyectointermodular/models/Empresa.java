package com.proyecto.proyectointermodular.models;


public class Empresa {
    private String id;
    private String nombre;
    private String sector;
    private String paisOrigenId;

    // Construtor vacio

    public Empresa() {
        this.id = id;
        this.nombre = nombre;
        this.sector = sector;
        this.paisOrigenId = paisOrigenId;
    }
   // Constructor completo
    public Empresa(String id, String nombre, String sector, String paisOrigenId) {
        this.id = id;
        this.nombre = nombre;
        this.sector = sector;
        this.paisOrigenId = paisOrigenId;
    }

// getters

        public String getId () {
            return id;
        }

        public String getNombre () {
            return nombre;
        }

        public String getSector () {
            return sector;
        }

        public String getPaisOrigenId () {
            return paisOrigenId;
        }

        // setters

        public void setId (String id){
            this.id = id;
        }

        public void setNombre (String nombre){
            this.nombre = nombre;
        }

        public void setSector (String sector){
            this.sector = sector;
        }

        public void setPaisOrigenId (String paisOrigenId){
            this.paisOrigenId = paisOrigenId;
        }
    }








