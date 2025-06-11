package br.fatec;
import java.util.Random;

public class JogoMinecraft_Teste{
    public static void main(String[] args) throws Exception {
    var p1 = new JogadorMinecraft_Teste("Alex");
    var p2 = new JogadorMinecraft_Teste("Steve Construtor");
    int acoes = 3;
    var gerador = new Random();
    while(true){
        var oQueFazer = 1 + gerador.nextInt(acoes); 
        var verificarDano = gerador.nextDouble();
        var ataque = gerador.nextDouble();
            if (p1.estaVivo() == true){
            switch (oQueFazer){
                case 1:
                    p1.minerar();
                    System.out.println(p1);
                    break;
                case 2:
                    p1.coletarMadeira();
                    System.out.println(p1);
                    break;
                case 3:
                    p1.construir();
                    System.out.println(p1);
                    break;
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
                
                System.out.println("=====================");
                
            }
                if (p2.estaVivo() == true){
                    var oQueFazerSteve = gerador.nextDouble();
                    var verificarDanoSteve = gerador.nextDouble();
                    if (oQueFazerSteve <=0.6){
                        p2.construir();
                        System.out.println(p2);
                    }
                    if (oQueFazerSteve > 0.6 && oQueFazerSteve <= 0.9){
                        p2.coletarMadeira();
                        System.out.println(p2);
                    }
                    if(oQueFazerSteve > 0.9 && oQueFazerSteve <= 1){
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
