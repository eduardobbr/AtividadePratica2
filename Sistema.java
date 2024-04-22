import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void executar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    buscarFuncionario();
                    break;
                case 3:
                    editarFuncionario();
                    break;
                case 4:
                    excluirFuncionario();
                    break;
                case 5:
                    listarFuncionarios();
                    break;
                case 6:
                    excluirTodosFuncionarios();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Buscar Funcionário");
        System.out.println("3. Editar Funcionário");
        System.out.println("4. Excluir Funcionário");
        System.out.println("5. Listar Funcionários");
        System.out.println("6. Excluir Todos os Funcionários");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFuncionario() {
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Salário do funcionário: ");
        double salario = scanner.nextDouble();
        funcionarios.add(new Funcionario(nome, salario));
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void buscarFuncionario() {
        System.out.print("Nome do funcionário a ser buscado: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Funcionário encontrado:");
                System.out.println("Nome: " + funcionario.getNome() + ", Salário: " + funcionario.getSalario());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void editarFuncionario() {
        System.out.print("Nome do funcionário a ser editado: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Novo salário: ");
                double novoSalario = scanner.nextDouble();
                funcionario.setNome(novoNome);
                funcionario.setSalario(novoSalario);
                System.out.println("Funcionário editado com sucesso.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void excluirFuncionario() {
        System.out.print("Nome do funcionário a ser excluído: ");
        String nome = scanner.nextLine();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionário excluído com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    private static void listarFuncionarios() {
        System.out.println("---- Funcionários Cadastrados ----");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Salário: " + funcionario.getSalario());
        }
    }

    private static void excluirTodosFuncionarios() {
        funcionarios.clear();
        System.out.println("Todos os funcionários foram excluídos.");
    }
}
