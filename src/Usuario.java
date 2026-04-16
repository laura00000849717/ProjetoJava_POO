import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Usuario {
    String nome;
    String matricula;
    private List<Book> meusLivros = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public static Usuario iniciarSessao() {
        Usuario usuarioInstance;
        boolean hasAccount = verificarConta();

        if (hasAccount) {
            usuarioInstance = logarUsuario();;
        } else {
            usuarioInstance = criarUsuario();
        }

        if (usuarioInstance == null) {
            return null;
        }

        return usuarioInstance;
    }

    
    private static boolean verificarConta() {
        while (true) {
            System.out.println("Você possui uma conta?");
            System.out.println("(S) Sim  (N) Não");
            
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (input.equals("S")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Seleção inválida. Tente novamente.");
            }
        }
    }

    public static Usuario criarUsuario() {
        System.out.print("Insira um nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Insira seu número de matrícula: ");
        String matricula = scanner.nextLine();

        Usuario usuario = new Usuario(nome, matricula);
        usuario.salvarUsuario();

        return usuario;
    }
    
    public static Usuario logarUsuario() {
        buscarArquivoUsuarios(); // garantir que arquivo de salvamento existe

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new java.io.File("usuarios.txt"))) {
            while (fileScanner.hasNextLine()) {
                String linha = fileScanner.nextLine();
                String[] dados = linha.split(";");

                if (dados[0].equals(nome) && dados[1].equals(matricula)) {
                    System.out.println("Login realizado com sucesso.");
                    return new Usuario(nome, matricula);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo.");
        }

        System.out.println("Usuário não encontrado.");
        return null;
    }

    public void salvarUsuario() {
        buscarArquivoUsuarios(); // garantir que arquivo de salvamento existe

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(nome + ";" + matricula);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário.");
            e.printStackTrace();
        }
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

    private static void buscarArquivoUsuarios() {
        try {
            File arquivo = new File("usuarios.txt");

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo de usuários.");
            e.printStackTrace();
        }
    }
}   