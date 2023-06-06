import java.text.SimpleDateFormat;
import java.util.*;

class GerenciamentoHospital {
    private SimpleDateFormat dateFormat;
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<FichaConsulta> fichasConsulta;


    public GerenciamentoHospital() {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        fichasConsulta = new ArrayList<>();
    }



    public void cadastrarMedico(String nome, String crm, String especialidade) {
        Medico medico = new Medico(nome, crm, especialidade);
        medicos.add(medico);
    }

    public void exibirMedicosOrdenadosPorNome() {
        Collections.sort(medicos, Comparator.comparing(Medico::getNome));

        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            System.out.println((i + 1) + ". " + medico.getNome() + " - " + medico.getEspecialidade());
        }
    }

    public void cadastrarPaciente(String nome, String sexo, int idade, double altura, double peso) {
        Paciente paciente = new Paciente(nome, sexo, idade, altura, peso);
        pacientes.add(paciente);
    }

    public void cadastrarFichaConsulta(String motivoConsulta, Medico medico, Paciente paciente) {
        FichaConsulta fichaConsulta = new FichaConsulta(motivoConsulta, medico, paciente);
        fichasConsulta.add(fichaConsulta);
    }

    public void exibirMedicosOrdenadosPorEspecialidade() {
        Collections.sort(medicos, Comparator.comparing(Medico::getEspecialidade));

        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            System.out.println((i + 1) + ". " + medico.getNome() + " - " + medico.getEspecialidade());
        }
    }

    public void exibirPacientesOrdenadosPorNome() {
        Collections.sort(pacientes, Comparator.comparing(Paciente::getNome));

        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            System.out.println((i + 1) + ". " + paciente.getNome());
        }
    }

    public Medico getMedicoPorNumero(int numero) {
        if (numero >= 1 && numero <= medicos.size()) {
            return medicos.get(numero - 1);
        } else {
            return null;
        }
    }

    public Paciente getPacientePorNumero(int numero) {
        if (numero >= 1 && numero <= pacientes.size()) {
            return pacientes.get(numero - 1);
        } else {
            return null;
        }
    }

    public void exibirFichasConsulta() {
        for (FichaConsulta fichaConsulta : fichasConsulta) {
            String alturaFormatada = String.format("%.2f", fichaConsulta.getPaciente().getAltura());
            System.out.println("Nome do Paciente: " + fichaConsulta.getPaciente().getNome());
            System.out.println("Sexo: " + fichaConsulta.getPaciente().getSexo());
            System.out.println("Idade: " + fichaConsulta.getPaciente().getIdade());
            System.out.println("Altura: " + alturaFormatada + " - Peso: " + fichaConsulta.getPaciente().getPeso() + " KG");
            System.out.println("Motivo da consulta: " + fichaConsulta.getMotivoConsulta());
            System.out.println("Médico: " + fichaConsulta.getMedico().getNome() + " - Especialidade: " + fichaConsulta.getMedico().getEspecialidade());
            System.out.println("Data da Consulta: " + dateFormat.format(fichaConsulta.getDataConsulta()));
            System.out.println("----------------------------------------------------");
        }
    }




}