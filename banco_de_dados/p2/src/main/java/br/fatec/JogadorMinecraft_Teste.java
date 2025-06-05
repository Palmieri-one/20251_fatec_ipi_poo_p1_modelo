package br.fatec;
import java.util.*;

public class JogadorMinecraft_Teste {
    private String nome;
    private int vida;
    private int blocosColetados;
    private List<String> inventario;

    public JogadorMinecraft_Teste(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>();
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

    public void atacar(JogadorMinecraft_Teste j){
        System.out.println(nome + " atacou "); 
        j.levarDano();
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Vida: %d, Blocos: %d, Inventário: %s",
            nome, vida, blocosColetados, inventario
        );
    }
}
