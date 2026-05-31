package com.poo.entity;

public class Aluno {

    private String nome;
    private final double[] notas;
    private double media;

    public Aluno(String nome, int indice) {

        this.nome = nome;
        notas = new double[indice];
    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public double getNotas(int indice) {

        return notas[indice];

    }

    public void setNotas(double nota, int indice) {

        this.notas[indice] = nota;

    }

    public double getMedia() {

        return media;

    }

    public void setMedia(double media) {

        this.media = media;

    }

}
