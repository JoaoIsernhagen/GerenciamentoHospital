import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {
    private GerenciamentoHospital gerenciamento;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextArea outputTextArea;

    public Interface() {
        gerenciamento = new GerenciamentoHospital();
        frame = new JFrame("Hospital Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));

        JButton cadastrarMedicoButton = new JButton("Cadastrar Médico");
        cadastrarMedicoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarMedico();
            }
        });
        buttonPanel.add(cadastrarMedicoButton);

        JButton cadastrarPacienteButton = new JButton("Cadastrar Paciente");
        cadastrarPacienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarPaciente();
            }
        });
        buttonPanel.add(cadastrarPacienteButton);

        JButton cadastrarFichaConsultaButton = new JButton("Cadastrar Ficha de Consulta");
        cadastrarFichaConsultaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarFichaConsulta();
            }
        });
        buttonPanel.add(cadastrarFichaConsultaButton);

        JButton exibirFichasConsultaButton = new JButton("Exibir Fichas de Consulta");
        exibirFichasConsultaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirFichasConsulta();
            }
        });
        buttonPanel.add(exibirFichasConsultaButton);

        JButton exibirPacientesOrdenadosButton = new JButton("Exibir Pacientes Ordenados por Nome");
        exibirPacientesOrdenadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirPacientesOrdenadosPorNome();
            }
        });
        buttonPanel.add(exibirPacientesOrdenadosButton);

        JButton exibirMedicosOrdenadosButton = new JButton("Exibir Médicos Ordenados por Especialidade");
        exibirMedicosOrdenadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirMedicosOrdenadosPorEspecialidade();
            }
        });
        buttonPanel.add(exibirMedicosOrdenadosButton);

        mainPanel.add(buttonPanel, BorderLayout.WEST);

        frame.getContentPane().add(mainPanel);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Centralize a janela na tela
        frame.setVisible(true);
    }

    private void cadastrarMedico() {
        String nomeMedico = JOptionPane.showInputDialog(frame, "Nome do médico:");
        String crm = JOptionPane.showInputDialog(frame, "CRM do médico:");
        String especialidade = JOptionPane.showInputDialog(frame, "Especialidade do médico:");

        gerenciamento.cadastrarMedico(nomeMedico, crm, especialidade);
        output("Médico cadastrado com sucesso!\n");
    }

    private void cadastrarPaciente() {
        String nomePaciente = JOptionPane.showInputDialog(frame, "Nome completo do paciente:");
        String sexo = JOptionPane.showInputDialog(frame, "Sexo do paciente:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog(frame, "Idade do paciente:"));
        double altura = Double.parseDouble(JOptionPane.showInputDialog(frame, "Altura do paciente:"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog(frame, "Peso do paciente:"));

        gerenciamento.cadastrarPaciente(nomePaciente, sexo, idade, altura, peso);
        output("Paciente cadastrado com sucesso!\n");
    }

    private void cadastrarFichaConsulta() {
        String crm = JOptionPane.showInputDialog(frame, "CRM do médico:");
        String nomePaciente = JOptionPane.showInputDialog(frame, "Nome completo do paciente:");
        String dataConsulta = JOptionPane.showInputDialog(frame, "Data da consulta:");
        String descricao = JOptionPane.showInputDialog(frame, "Descrição da consulta:");

        gerenciamento.cadastrarFichaConsulta(dataConsulta, null, null);
        output("Ficha de consulta cadastrada com sucesso!\n");
    }

    private void exibirFichasConsulta() {
        String crm = JOptionPane.showInputDialog(frame, "CRM do médico:");

        gerenciamento.exibirFichasConsulta();
    }

    private void exibirPacientesOrdenadosPorNome() {
        gerenciamento.exibirPacientesOrdenadosPorNome();
    }

    private void exibirMedicosOrdenadosPorEspecialidade() {
        gerenciamento.exibirMedicosOrdenadosPorEspecialidade();
    }

    private void output(Object object) {
        outputTextArea.append(object + "\n");
        outputTextArea.setCaretPosition(outputTextArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }
}
