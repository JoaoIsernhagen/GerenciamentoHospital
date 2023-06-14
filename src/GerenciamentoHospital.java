import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

        String[] columnNames = {"#", "Nome", "Especialidade"};

        Object[][] data = new Object[medicos.size()][3];
        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            data[i][0] = i + 1;
            data[i][1] = medico.getNome();
            data[i][2] = medico.getEspecialidade();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "Médicos Ordenados por Especialidade", JOptionPane.INFORMATION_MESSAGE);
    }


    public void exibirPacientesOrdenadosPorNome() {
        Collections.sort(pacientes, Comparator.comparing(Paciente::getNome));

        String[] columnNames = {"#", "Nome"};

        Object[][] data = new Object[pacientes.size()][2];
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            data[i][0] = i + 1;
            data[i][1] = paciente.getNome();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "Pacientes Ordenados por Nome", JOptionPane.INFORMATION_MESSAGE);
    }


    public Medico getMedicoPorNome(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equals(nome)) {
                return medico;
            }
        }
        return null;
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
