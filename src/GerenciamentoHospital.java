import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GerenciamentoHospital {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<FichaConsulta> fichasConsulta;

    public GerenciamentoHospital() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.fichasConsulta = new ArrayList<>();
        Medico.adicionarMedicosIniciais(this);
    }

        public void setPacientes(List<Paciente> pacientes) {
            this.pacientes = pacientes;
        }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println(paciente.getNomeCompleto() + " foi cadastrado com sucesso!");
    }
    public void cadastrarMedico(String nome, String crm, String especialidade) {
        medicos.add(new Medico(nome, crm, especialidade));
    }

    public void cadastrarFichaConsulta(FichaConsulta fichaConsulta) {
        fichasConsulta.add(fichaConsulta);
    }

    public void exibirMedicos() {
        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            System.out.println((i + 1) + ". " + medico.getNome() + " especialidade: " + medico.getEspecialidade());
        }
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public Paciente buscarPacientePorNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNomeCompleto().equals(nome)) {
                return paciente;
            }
        }
        return null; // Retorna null se não encontrar o paciente
    }

    public void exibirFichasConsulta() {
        System.out.println("===== Fichas de Consulta =====");
        for (FichaConsulta fichaConsulta : fichasConsulta) { // Corrigir aqui
            System.out.println("Nome do Paciente: " + fichaConsulta.getNomePaciente());
            System.out.println("Sexo do Paciente: " + fichaConsulta.getSexoPaciente());
            System.out.println("Idade do Paciente: " + fichaConsulta.getIdadePaciente());
            System.out.println("Motivo da Consulta: " + fichaConsulta.getMotivoConsulta());
            System.out.println("Médico: " + fichaConsulta.getMedico().getNome() + " - " + fichaConsulta.getMedico().getEspecialidade());
            System.out.println("Data e Hora: " + fichaConsulta.getDataHoraFormatada());
            System.out.println("---------------------");
        }
    }


    public void exibirPacientesOrdenadosPorNome() {
        List<FichaConsulta> fichasOrdenadas = new ArrayList<>(fichasConsulta);
        Collections.sort(fichasOrdenadas, Comparator.comparing(FichaConsulta::getNomePaciente));

        System.out.println("===== Fichas de Consulta =====");
        for (FichaConsulta fichaConsulta : fichasOrdenadas) {
            System.out.println("Nome do Paciente: " + fichaConsulta.getNomePaciente());
            System.out.println("Sexo do Paciente: " + fichaConsulta.getSexoPaciente());
            System.out.println("Motivo da Consulta: " + fichaConsulta.getMotivoConsulta());
            System.out.println("Médico: " + fichaConsulta.getMedico().getEspecialidade() + " - " + fichaConsulta.getMedico().getNome());
            System.out.println("---------------------");
        }
    }

    public List<Medico> getMedicos() {
        return medicos;
    }


}
