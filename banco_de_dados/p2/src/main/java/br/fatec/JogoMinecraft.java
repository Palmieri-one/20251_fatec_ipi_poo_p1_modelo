package br.fatec;

import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var dao = new PersonagemDAO();
        var lista_p1 = dao.listar();
        var p1 = lista_p1.get(0);
        var p2 = lista_p1.get(1);

        var gerador = new Random();

        while(true){
            var ataque = gerador.nextDouble();

            if (p1.estaVivo() == true){
                double acao = gerador.nextDouble(); 
                double probConstruir = p1.getProb_construir();
                double probColetar = p1.getProb_coletar();

                var verificarDano = gerador.nextDouble();
            
                if (acao < probConstruir) {
                    p1.construir();
                    System.out.println(p1);
                } else if (acao < probConstruir + probColetar) {
                    p1.coletarMadeira();
                    System.out.println(p1);
                } else {
                    p1.minerar();
                    System.out.println(p1);
                }

                if (verificarDano <= 0.25){
                    System.out.println("=====================");
                    p1.levarDano();
                    System.out.println(p1);
                }

                if(p2.estaVivo()){
                    if(ataque <= 0.5){
                        System.out.println("=====================");
                        p1.atacar(p2);
                        System.out.println(p2);
                    }
                }
            }
            System.out.println("=====================");


             if (p2.estaVivo() == true){
                    var oQueFazerSteve = gerador.nextDouble();
                    var verificarDanoSteve = gerador.nextDouble();
                   
                    double probConstruirSteve = p2.getProb_construir();
                    double probColetarSteve = p2.getProb_coletar();

                    if (oQueFazerSteve < probConstruirSteve) {
                        p2.construir();
                        System.out.println(p2);
                    } else if (oQueFazerSteve < probConstruirSteve + probColetarSteve) {
                        p2.coletarMadeira();
                        System.out.println(p2);
                    } else {
                        p2.minerar();
                        System.out.println(p2);
                    }

                    if (verificarDanoSteve <= 0.25){
                        System.out.println("=====================");
                        p2.levarDano();
                        System.out.println(p2);
                    }
                    if(p1.estaVivo ()){
                        if(ataque > 0.5){
                            System.out.println("=====================");
                            p2.atacar(p1);
                            System.out.println(p1);
                        }
                    }
                    System.out.println("=====================");
                    
                }
                if(p1.estaVivo() == false && p2.estaVivo() == false){
                    System.out.println("GAME OVER");
                    break;
                }                
        Thread.sleep(5000);  
        }
    }
}
