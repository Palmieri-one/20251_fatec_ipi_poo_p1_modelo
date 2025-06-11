package br.fatec;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String host = "localhost";
    private static String port = "5433";
    private static String db = "db_personagens";
    private static String user = "postgres";
    private static String password = "123456";
    
    //https://google.com:80/search
    public static Connection obterConexao() throws Exception{

        //string de conexão
        var s = String.format(
            "jdbc:postgresql://%s:%s/%s",
            host, port, db
        );
        //cláusula catch or declare
        //exceção verificada pelo compilador
        Connection c = DriverManager.getConnection(
            s, user, password
        );
        return c;
    }    

    public static void main(String[] args) throws Exception{
        var cf = new ConnectionFactory();
        var c = cf.obterConexao(); 
        System.out.println("Conectou");
    }
}