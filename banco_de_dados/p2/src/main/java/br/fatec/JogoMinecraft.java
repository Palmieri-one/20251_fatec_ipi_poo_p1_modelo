package br.fatec;

import java.util.ArrayList;
import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var dao = new PersonagemDAO();
        var lista = new ArrayList<Personagem>();
        try {
            lista = dao.listar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(("Erro ao listar personagens! Tente novamente mais tarde."));
            return;
        }
        var p1 = lista.get(0);
        var p2 = lista.get(1);
       
        var gerador = new Random();
        int iteracao = 1;

        while(true){
            System.out.println("RODADA " + iteracao);
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

                if(p1.estaVivo() && p2.estaVivo()){
                    if(ataque <= 0.5){
                        System.out.println("=====================");
                        p1.atacar(p2);
                        System.out.println(p2);
                        if(!p2.estaVivo()){
                            p1.setVitorias(p1.getVitorias() + 1);
                            p2.setDerrotas(p2.getDerrotas() + 1);
                            try {
                                dao.atualizarVitoriasDerrotas(p1.getCodigo(), p1.getVitorias(), p1.getDerrotas());
                                dao.atualizarVitoriasDerrotas(p2.getCodigo(), p2.getVitorias(), p2.getDerrotas());
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Erro ao atualizar vitórias/derrotas! Tente novamente mais tarde.");
                            }
                            System.out.println("VITÓRIA DE " + p1.getNome() + "!");
                            System.out.println(p1);
                            System.out.println(p2);
                        }
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
                    if(p2.estaVivo() && p1.estaVivo()){
                        if(ataque > 0.5){
                            System.out.println("=====================");
                            p2.atacar(p1);
                            if(!p1.estaVivo()){
                                p2.setVitorias(p2.getVitorias() + 1);
                                p1.setDerrotas(p1.getDerrotas() + 1);
                                try {
                                    dao.atualizarVitoriasDerrotas(p1.getCodigo(), p1.getVitorias(), p1.getDerrotas());
                                    dao.atualizarVitoriasDerrotas(p2.getCodigo(), p2.getVitorias(), p2.getDerrotas());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Erro ao atualizar vitórias/derrotas! Tente novamente mais tarde.");
                                }
                                System.out.println("VITÓRIA DE " + p2.getNome() + "!");
                                System.out.println(p1);
                                System.out.println(p2);
                            }
                        }
                    }
                    System.out.println("=====================");
                    
                }
                if(p1.estaVivo() == false && p2.estaVivo() == false){
                    System.out.println("GAME OVER");
                    break;
                }          

                if(iteracao >= 1){
                    if(p1.estaVivo()){
                         p1.alterarProbabilidades(gerador);
                         try {
                            dao.atualizarProbabilidades(p1.getCodigo(), p1.getProb_construir(), p1.getProb_coletar(), p1.getProb_minerar());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Erro ao atualizar probabilidades do " + p1.getNome() + " Tente novamente mais tarde.");
                        }
                    }
                    if(p2.estaVivo()){
                        p2.alterarProbabilidades(gerador);
                        try {
                            dao.atualizarProbabilidades(p2.getCodigo(), p2.getProb_construir(), p2.getProb_coletar(), p2.getProb_minerar());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Erro ao atualizar probabilidades do " + p2.getNome() + " Tente novamente mais tarde.");
                        }
                    }
                }
            iteracao++;      
            Thread.sleep(5000);  
        }
    }
}
