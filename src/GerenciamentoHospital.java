import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
        Medico.adicionarMedicosIniciais(this);
        Paciente.adicionarPacientesIniciais(this);
    }

    public void cadastrarMedico(String nome, String crm, String especialidade) {
        Medico medico = new Medico(nome, crm, especialidade);
        medicos.add(medico);
    }

    public String[] getNomesMedicos() {
        String[] nomes = new String[medicos.size()];
        for (int i = 0; i < medicos.size(); i++) {
            nomes[i] = medicos.get(i).getNome();
        }
        return nomes;
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

    public String[] getNomesPacientes() {
        String[] nomes = new String[pacientes.size()];
        for (int i = 0; i < pacientes.size(); i++) {
            nomes[i] = pacientes.get(i).getNome();
        }
        return nomes;
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

    public Medico getMedicoPorNome(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equals(nome)) {
                return medico;
            }
        }
        return null;
    }

    public Paciente getPacientePorNumero(int numero) {
        if (numero >= 1 && numero <= pacientes.size()) {
            return pacientes.get(numero - 1);
        } else {
            return null;
        }
    }

    public Paciente getPacientePorNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(nome)) {
                return paciente;
            }
        }
        return null;
    }

    public void exibirFichasConsulta() {
        StringBuilder mensagem = new StringBuilder();
        for (FichaConsulta fichaConsulta : fichasConsulta) {
            String alturaFormatada = String.format("%.2f", fichaConsulta.getPaciente().getAltura());
            mensagem.append("Nome do Paciente: ").append(fichaConsulta.getPaciente().getNome()).append("\n");
            mensagem.append("Sexo: ").append(fichaConsulta.getPaciente().getSexo()).append("\n");
            mensagem.append("Idade: ").append(fichaConsulta.getPaciente().getIdade()).append("\n");
            mensagem.append("Altura: ").append(alturaFormatada).append(" - Peso: ").append(fichaConsulta.getPaciente().getPeso()).append(" KG").append("\n");
            mensagem.append("Motivo da consulta: ").append(fichaConsulta.getMotivoConsulta()).append("\n");
            mensagem.append("Médico: ").append(fichaConsulta.getMedico().getNome()).append(" - Especialidade: ").append(fichaConsulta.getMedico().getEspecialidade()).append("\n");
            mensagem.append("Data da Consulta: ").append(dateFormat.format(fichaConsulta.getDataConsulta())).append("\n");
            mensagem.append("----------------------------------------------------").append("\n");
        }

        JTextArea textArea = new JTextArea(mensagem.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Fichas de Consulta", JOptionPane.INFORMATION_MESSAGE);
    }
}
