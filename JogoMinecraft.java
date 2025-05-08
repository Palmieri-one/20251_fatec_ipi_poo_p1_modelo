import java.util.Random;

public class JogoMinecraft{
    public static void main(String[] args) throws Exception {
    var p1 = new JogadorMinecraft("Alex");
    var p2 = new JogadorMinecraft("Steve Construtor");
    int acoes = 3;
    var gerador = new Random();
    while(true){
        var oQueFazer = 1 + gerador.nextInt(acoes); //nextdouble (if oQueFazer < 0.25)
        var verificarDano = gerador.nextDouble();
            if (p1.estaVivo() == true){
            switch (oQueFazer){
                case 1:
                    p1.minerar();
                    break;
                case 2:
                    p1.coletarMadeira();
                    break;
                case 3:
                    p1.construir();
                    break;
                }
                if (verificarDano <= 0.25){
                    p1.levarDano();
                }
                System.out.println(p1);
                System.out.println("=====================");
                
            }
                if (p2.estaVivo() == true){
                    var oQueFazerSteve = gerador.nextDouble();
                    var verificarDanoSteve = gerador.nextDouble();
                    if (oQueFazerSteve <=0.6){
                        p2.construir();
                    }
                    if (oQueFazerSteve > 0.6 && oQueFazerSteve <= 0.9){
                    p2.coletarMadeira();
                    }
                    if(oQueFazerSteve > 0.9 && oQueFazerSteve <= 1){
                        p2.minerar();
                    }
                    if (verificarDanoSteve <= 0.25){
                        p2.levarDano();
                    }
                    System.out.println(p2);
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
