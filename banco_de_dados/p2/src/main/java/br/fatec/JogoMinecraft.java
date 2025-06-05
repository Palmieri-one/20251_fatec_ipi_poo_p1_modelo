package br.fatec;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception {
        var dao = new PersonagemDAO();
        var lista_p1 = dao.listar();

        System.out.println(lista_p1);
    }
}
