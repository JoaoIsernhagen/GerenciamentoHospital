import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        GerenciamentoHospital gerenciamento = new GerenciamentoHospital();
        Scanner scanner = new Scanner(System.in);

        Medico medico = new Medico();
        Paciente paciente = new Paciente();

        System.out.println("===== Menu Principal =====");
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Cadastrar Paciente");
            System.out.println("3. Cadastrar Ficha de Consulta");
            System.out.println("5. Exibir Pacientes");
            System.out.println("6. Exibir Médicos");
            System.out.println("4. Exibir Fichas de Consulta");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarMedico(gerenciamento, scanner);
                    break;
                case 2:
                    cadastrarPaciente(gerenciamento, scanner);
                    break;
                case 3:
                    cadastrarFichaConsulta(gerenciamento, scanner);
                    break;
                case 4:
                    exibirFichasConsulta(gerenciamento);
                    break;
                case 5:
                    gerenciamento.exibirPacientesOrdenadosPorNome();
                    break;
                case 6:
                    gerenciamento.exibirMedicosOrdenadosPorNome();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Digite novamente.");
            }
        }
    }

    public static void cadastrarMedico(GerenciamentoHospital gerenciamento, Scanner scanner) {
        System.out.println("===== Cadastro de Médico =====");
        System.out.print("Nome do médico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("CRM do médico: ");
        String crm = scanner.nextLine();

        System.out.print("Especialidade do médico: ");
        String especialidade = scanner.nextLine();

        gerenciamento.cadastrarMedico(nomeMedico, crm, especialidade);
        System.out.println("Médico cadastrado com sucesso!\n");
    }

    public static void cadastrarPaciente(GerenciamentoHospital gerenciamento, Scanner scanner) {
        System.out.println("===== Cadastro de Paciente =====");
        System.out.print("Nome completo do paciente: ");
        String nomePaciente = scanner.nextLine();

        System.out.print("Sexo do paciente: ");
        String sexo = scanner.nextLine();

        System.out.print("Idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Altura do paciente: ");
        double altura = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Peso do paciente: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        gerenciamento.cadastrarPaciente(nomePaciente, sexo, idade, altura, peso);
        System.out.println("Paciente cadastrado com sucesso!\n");
    }

    public static void cadastrarFichaConsulta(GerenciamentoHospital gerenciamento, Scanner scanner) {
        System.out.println("===== Cadastro de Ficha de Consulta =====");

        System.out.print("Selecione o paciente:");
        gerenciamento.exibirPacientesOrdenadosPorNome(); // Mostra os pacientes disponíveis

        int numeroPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Paciente paciente = gerenciamento.getPacientePorNumero(numeroPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado. A ficha de consulta não será cadastrada.");
            return;
        }

        System.out.print("Motivo da consulta: ");
        String motivoConsulta = scanner.nextLine();

        System.out.println("Selecione o médico:");
        gerenciamento.exibirMedicosOrdenadosPorEspecialidade(); // Mostra os médicos disponíveis ordenados por
        // especialidade

        int numeroMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Medico medico = gerenciamento.getMedicoPorNumero(numeroMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado. A ficha de consulta não será cadastrada.");
            return;
        }



        gerenciamento.cadastrarFichaConsulta(motivoConsulta, medico, paciente);

        System.out.println("Ficha de consulta cadastrada com sucesso!");
    }

    public static Medico selecionarMedico(GerenciamentoHospital gerenciamento, Scanner scanner) {

        System.out.println("Selecione o médico:");
        gerenciamento.exibirMedicosOrdenadosPorNome(); // Mostra os médicos disponíveis

        int numeroMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        return gerenciamento.getMedicoPorNumero(numeroMedico);
    }

    public static void exibirFichasConsulta(GerenciamentoHospital gerenciamento) {
        System.out.println("===== Fichas de Consulta =====");
        gerenciamento.exibirFichasConsulta();
    }
}