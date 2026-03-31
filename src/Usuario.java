import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    String nome;
    String matricula;
    private static final Scanner scanner = new Scanner(System.in);
   
    private List<Book> meusLivros = new ArrayList<>();

    private Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public static Usuario createUsuarioInstance() {
        System.out.print("Insira um nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Insira seu número de matrícula: ");
        String matricula = scanner.nextLine();

        return new Usuario(nome, matricula);
    }

    public String getNome(){
        return nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public List<Book> getMeusLivros() {
        return meusLivros;
    }
}