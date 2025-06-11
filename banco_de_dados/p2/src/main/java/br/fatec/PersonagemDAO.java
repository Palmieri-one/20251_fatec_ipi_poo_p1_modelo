package br.fatec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;

public class PersonagemDAO {
    public ArrayList<Personagem> listar() throws Exception{
        var personagens = new ArrayList<Personagem>();
        var sql = "SELECT * FROM tb_personagem ORDER BY cod_personagem";
        try(
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ){
                //lidar com o resultado
                while(rs.next()){
                    var codigo = rs.getInt("cod_personagem");
                    var nome = rs.getString("nome");
                    var prob_construir = rs.getDouble("prob_construir");
                    var prob_coletar = rs.getDouble("prob_coletar");
                    var prob_minerar = rs.getDouble("prob_mineirar");
                    var vitorias = rs.getInt("vitorias");
                    var derrotas = rs.getInt("derrotas");
                    var personagem = new Personagem (codigo, nome, prob_construir, prob_coletar, prob_minerar, vitorias, derrotas);
                    personagens.add(personagem);  
                }    
                return personagens;
        }
}

    public void atualizarVitoriasDerrotas(int codigo, int vitorias, int derrotas) throws Exception {
    String sql = "UPDATE tb_personagem SET vitorias=?, derrotas=? WHERE cod_personagem=?";
    try (Connection conexao = ConnectionFactory.obterConexao();
         PreparedStatement ps = conexao.prepareStatement(sql)) {
        ps.setInt(1, vitorias);
        ps.setInt(2, derrotas);
        ps.setInt(3, codigo);
        ps.executeUpdate();
    }
}
}

    