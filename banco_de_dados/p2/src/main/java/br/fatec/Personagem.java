package br.fatec;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {
    private int codigo;
    private String nome;
    private double prob_construir;
    private double prob_coletar;
    private double prob_minerar;
    private int vitorias;
    private int derrotas;
    private int vida;
    private int blocosColetados;
    private List<String> inventario;


public Personagem(int codigo, String nome, Double prob_construir, Double prob_coletar, Double prob_mineirar, int vitorias, int derrotas){
    this.nome = nome;
    this.vida = 10;
    this.blocosColetados = 0;
    this.inventario = new ArrayList<>();
    this.prob_construir = prob_construir;
    this.prob_coletar = prob_coletar;
    this.prob_minerar = prob_mineirar;
    this.vitorias = vitorias;
    this.derrotas = derrotas;
}

public void minerar() {
    System.out.println(nome + " esta minerando...");
    blocosColetados++;
    inventario.add("Pedra");
}

public void coletarMadeira() {
    System.out.println(nome + " coletou madeira.");
    inventario.add("Madeira");
}

public void construir() {
    if (inventario.size() >= 2) {
        System.out.println(nome + " construiu algo com seus recursos!");
        inventario.remove(0);
        inventario.remove(0);
    } else {
        System.out.println(nome + " nao tem blocos suficientes para construir.");
    }
}

public void levarDano() {
    vida--;
    System.out.println(nome + " levou dano! Vida atual: " + vida);
}

public void atacar(Personagem j){
    System.out.println(nome + " atacou "); 
    j.levarDano();
}

public boolean estaVivo() {
    return vida > 0;
}

@Override
public String toString() {
    return String.format(
        "%s - Vida: %d, Blocos: %d, Inventário: %s, Vitorias: %d, Derrotas: %d",
        nome, vida, blocosColetados, inventario, vitorias, derrotas
    );
}
}

