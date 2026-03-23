import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nome;
    int idade;
    int matricula;
   
    private List<Book> meusLivros = new ArrayList<>();

    private Usuario(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    public static Usuario createUsuarioInstance(String nome, int idade, int matricula) {
        return new Usuario(nome, idade, matricula);
    }

    public List<Book> getMeusLivros() {
        return meusLivros;
    }
}