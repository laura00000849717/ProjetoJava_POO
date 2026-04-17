## Sistema de Gerenciamento de Biblioteca (Java POO)

Este é um projeto desenvolvido em Java que simula o funcionamento de uma biblioteca, focando na aplicação de conceitos fundamentais de **Programação Orientada a Objetos (POO)**.

## 🚀 Funcionalidades

- **Cadastro de Usuário:** Criação de perfil com nome e matrícula.
- **Banco de Dados de Livros:** Inicialização automática de uma lista de obras clássicas.
- **Empréstimo de Livros:** O usuário pode escolher livros disponíveis, que são movidos para sua lista pessoal.
- **Devolução de Livros:** Possibilidade de devolver livros da lista pessoal para o acervo da biblioteca.
- **Persistência em Memória:** As listas são atualizadas em tempo real enquanto o programa está em execução.

## 🛠️ Conceitos de POO Aplicados

- **Encapsulamento:** Proteção de dados sensíveis nas classes `Book` e `Usuario`.
- **Herança:** Uso de herança para tipos de usuário e tipo de empréstimo.
- **Polimorismo:** Polimorfismo aplicado para classes de empréstimo como comportamentos distintos.
- **Abstração:** Representação de entidades do mundo real em classes Java.
- **Composição:** A classe `Aluno` possui uma lista (`ArrayList`) de objetos do tipo `Book`.
- **Static Members:** Uso de membros estáticos para gerenciar o estado da biblioteca e do scanner global.

## 📁 Estrutura do Projeto

- `Main.java`: Ponto de entrada do sistema.
- `Library.java`: Classe principal com a lógica de menus, empréstimos e devoluções.
- `LibraryUI.java`: Responsável pela visualização da interface e I/O da biblioteca.
- `LibraryDatabase.java`: Repositório responsável por popular o acervo de livros.
- `Usuario.java`: Representação geral do cliente da biblioteca.
- `Aluno.java`: Classe de usuário (aluno) com cadastro, login e salvamento.
- `Book.java`: Modelo de dados para os livros.
- `Emprestimo.java`, `EmprestimoPadrao.java`, `EmprestimoEstendido.java`: Versão inicial das classes que servirão de base para o sistema de prazos.

## 📄 UML

<img width="1091" height="1078" alt="DiagramaUML_Biblioteca3" src="https://github.com/user-attachments/assets/696de947-95db-46b5-a9b1-4257cd119484" />


## 🔧 Como rodar o projeto

1. Certifique-se de ter o **JDK 11 ou superior** instalado.
2. Clone o repositório:
   ```bash
   git clone [https://github.com/laura00000849717/ProjetoJava_POO.git](https://github.com/laura00000849717/ProjetoJava_POO.git)
