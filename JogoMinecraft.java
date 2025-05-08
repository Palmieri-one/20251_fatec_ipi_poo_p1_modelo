import java.util.Random;

public class JogoMinecraft{
    public static void main(String[] args) throws Exception {
    var p1 = new JogadorMinecraft("Alex");
    int acoes = 3;
    var gerador = new Random();
    while(true){
        var oQueFazer = 1 + gerador.nextInt(acoes); //nextdouble (if oQueFazer < 0.25)
        var verificarDano = gerador.nextDouble();
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
                Thread.sleep(5000);
                if (p1.estaVivo() == false ){
                System.out.println("GAME OVER");
                System.out.println("=====================");
                System.exit(1);
                }
            }        
    }
}
