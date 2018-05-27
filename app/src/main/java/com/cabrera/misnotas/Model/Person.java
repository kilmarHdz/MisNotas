package com.cabrera.misnotas.Model;

public class Person {
    private String carnet;
    private int nota;
    private String materia;
    private String catedratico;
    public Person(){
    }
    public Person(String carnet, int nota, String materia, String catedratico){
        this.carnet=carnet;
        this.nota=nota;
        this.materia=materia;
        this.catedratico=catedratico;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    public String getCarnet() {
        return carnet;
    }

    public int getNota() {
        return nota;
    }

    public String getMateria() {
        return materia;
    }

    public String getCatedratico() {
        return catedratico;
    }
}
