🛠 SGM - Sistema de Gestão de Manutenção

Sistema de Gestão de Manutenção (SGM) desenvolvido em **Java (JDK 21)** com **MySQL**, utilizando o padrão **MVC (Model–View–Controller)** e **DAO** para persistência de dados.

O projeto tem como objetivo **gerenciar ordens de serviço, clientes, usuários, peças e relatórios** de forma modular e organizada, seguindo boas práticas de desenvolvimento orientado a objetos.

📜 Módulos e Responsabilidades
Módulo	Função
Conexao	Gerencia a conexão com o banco de dados via JDBC.
Model	Contém as classes das entidades (Cliente, Usuário, Peça, etc.) e suas DAOs para persistência.
Controller	Faz o controle das operações de CRUD, intermediando o Model e o View.
Reports	Responsável por gerar relatórios (listagens, ordens de serviço, etc.) usando SQL.
View	Camada de interface — interage com o usuário via console ou interface simples.
Principal	Classe principal (Main.java) que inicia o sistema.
SQL	Scripts SQL para criação, procedures e triggers do banco.
Diagramas	Diagramas do banco de dados e estrutura do sistema.

🧠 Padrão de Arquitetura
O sistema segue o padrão MVC (Model–View–Controller) com suporte a DAO e camada de relatórios.



🗂️ Estrutura do Projeto

SGM/
│
├── Diagramas/
│ ├──Diagrama Mermaid do banco de dados
│ └── Diagrama relacional em imagem
│
├── sql/
│ ├── SGM CREATE TABLES.sql 
│ ├── SGM PROCEDURES.sql 
│ └── SGM TRIGGRS.sql 
│
├── fonte/
│ ├── Conexao/
│ │ └── Conexao.java 
│ │
│ ├── Model
│ │ ├── Cliente.java
│ │ ├── Funcionario.java
│ │ ├── Ordem_De_Servico.java
│ │ ├── Ordem_De_ServicoDAO.java
│ │ ├── Pecas.java
│ │ ├── PecasDAO.java
│ │ ├── Usuario.java
│ │ └── UsuarioDAO.java
│ │
│ ├── controller/ 
│ │ ├── Control_Ordem_De_Serico.java
│ │ ├── Control_Pecas.java
│ │ └── Control_Usuario.java
│ │
│ ├── reports/ 
│ │ ├── RelatoriosOs.java
│ │ ├── RelatoriosPecas.java
│ │ └── RelatoriosUsu.java
│ │
│ ├── view/ 
│ │ └── Tela.java
│ │
│ └── principal/
│ └── Main.java # Classe principal de inicialização
│
└── module-info.java
⚙️ Requisitos do Ambiente (Linux)

Antes de rodar o sistema, verifique se os seguintes componentes estão instalados:

| Dependência | Versão recomendada | Verificar instalação |
|--------------|--------------------|----------------------|
| **Java JDK** | 21 ou superior | `java -version` |
| **MySQL Server** | 8.0+ | `mysql --version` |
| **Git** | 2.0+ | `git --version` |
| **Eclipse IDE ou VS Code com extensão Java)

🧩 Configuração do Banco de Dados

1. Acesse o terminal e entre no MySQL:
   ```bash
   mysql -u root -p
Crie o banco de dados:

sql
Copiar código
CREATE DATABASE SGM;
USE SGM;
Execute os scripts da pasta /sql:

bash
Copiar código
mysql -u root -p SGM < "sql/SGM CREATE TABLES.sql"
mysql -u root -p SGM < "sql/SGM PROCEDURES.sql"
mysql -u root -p SGM < "sql/SGM TRIGGRS.sql"
Verifique se as tabelas foram criadas:

sql
Copiar código

SHOW TABLES;
🔌 Configuração da Conexão (Conexao.java)
Edite o arquivo fonte/Conexao/Conexao.java com suas credenciais do MySQL:

java
Copiar código
private static final String URL = "jdbc:mysql://localhost:3306/SGM";
private static final String USUARIO = "root";
private static final String SENHA = "sua_senha";
🚀 Execução do Projeto (via Terminal Linux)
Clone o repositório:

bash
Copiar código
git clone https://github.com/seuusuario/SGM.git
cd SGM/fonte
Compile todas as classes:

bash
Copiar código
javac -d ../bin -cp ".:../lib/*" */*.java */*/*.java
Execute o programa principal:

bash
Copiar código
java -cp "../bin:../lib/*" principal.Main


👨‍💻 Autor
Bruno Oliveira Duarte
Larrisa Moraes de Jesus
Leo Fernandes
Projeto acadêmico de banco de dados | Estudantes de Ciências da Computação
