import java.util.Scanner;
import java.util.List;


public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciamentoHospital gerenciamentoHospital = new GerenciamentoHospital();

        // Adicionar os pacientes predefinidos ao GerenciamentoHospital
        List<Paciente> pacientesIniciais = Paciente.criarPacientesIniciais();
        gerenciamentoHospital.setPacientes(pacientesIniciais);

        int opcao = 0;
        while (opcao != 5) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do médico: ");
                    scanner.nextLine(); // Consumir a nova linha pendente
                    String nomeMedico = scanner.nextLine();
                    System.out.println("Digite o CRM do médico: ");
                    String crmMedico = scanner.nextLine();
                    System.out.println("Digite a especialidade do médico: ");
                    String especialidadeMedico = scanner.nextLine();

                    gerenciamentoHospital.cadastrarMedico(nomeMedico, crmMedico, especialidadeMedico);
                    System.out.println("Médico cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do paciente: ");
                    scanner.nextLine(); // Consumir a nova linha pendente
                    String nomePaciente = scanner.nextLine();
                    System.out.println("Digite o sexo do paciente: ");
                    String sexoPaciente = scanner.nextLine();
                    System.out.println("Digite a idade do paciente: ");
                    int idadePaciente = scanner.nextInt();

                    Paciente paciente = new Paciente(nomePaciente, sexoPaciente, idadePaciente);
                    gerenciamentoHospital.cadastrarPaciente(paciente);
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;
                case 3:
                    List<Paciente> pacientes = gerenciamentoHospital.getPacientes();
                    if (pacientes.isEmpty()) {
                        System.out.println("Não há pacientes cadastrados. Cadastre um paciente primeiro.");
                    } else {
                        System.out.println("Selecione o paciente:");
                        for (int i = 0; i < pacientes.size(); i++) {
                            Paciente pacienteSelecionado = pacientes.get(opcaoPaciente - 1);
                            System.out.println(i + 1 + ". " + pacienteSelecionado.getNomeCompleto());
                        }

                        int opcaoPaciente = scanner.nextInt();
                        if (opcaoPaciente >= 1 && opcaoPaciente <= pacientes.size()) {
                            Paciente pacienteSelecionado = pacientes.get(opcaoPaciente - 1);

                            System.out.println("Digite o motivo da consulta: ");
                            String motivoConsulta = scanner.next();

                            System.out.println("Selecione o médico:");
                            List<Medico> medicos = gerenciamentoHospital.getMedicos();
                            for (int i = 0; i < medicos.size(); i++) {
                                Medico medico = medicos.get(i);
                                System.out.println(i + 1 + ". " + medico.getNome() + " especialidade: " + medico.getEspecialidade());
                            }

                            int opcaoMedico = scanner.nextInt();
                            if (opcaoMedico >= 1 && opcaoMedico <= medicos.size()) {
                                Medico medicoSelecionado = medicos.get(opcaoMedico - 1);

                                FichaConsulta fichaConsulta = new FichaConsulta(pacienteSelecionado.getNome(), pacienteSelecionado.getSexo(), pacienteSelecionado.getIdade(), motivoConsulta, medicoSelecionado);
                                gerenciamentoHospital.cadastrarFichaConsulta(fichaConsulta);
                                System.out.println("Ficha de consulta cadastrada com sucesso!");
                            } else {
                                System.out.println("Opção inválida!");
                            }
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 4:
                    gerenciamentoHospital.exibirFichasConsulta();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("===== Sistema de Gerenciamento Hospitalar =====");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Cadastrar médico");
        System.out.println("2. Cadastrar paciente");
        System.out.println("3. Cadastrar ficha de consulta");
        System.out.println("4. Exibir fichas de consulta");
        System.out.println("5. Sair");
    }
}
