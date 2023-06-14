// Aluno João Ricardo Cruz Isernhage e João Vitor Farias Soares


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Comparator;


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

        JButton exibirPacientesOrdenadosButton = new JButton("Consultar pacientes");
        exibirPacientesOrdenadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirPacientesOrdenadosPorNome();
            }
        });
        buttonPanel.add(exibirPacientesOrdenadosButton);

        JButton exibirMedicosOrdenadosButton = new JButton("Consultar Medicos");
        exibirMedicosOrdenadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirMedicosOrdenadosPorEspecialidade();
            }
        });
        buttonPanel.add(exibirMedicosOrdenadosButton);

        mainPanel.add(buttonPanel, BorderLayout.WEST);

        ImageIcon logo = new ImageIcon("C:\\Users\\joaor\\Desktop\\Livro\\GerenciamentoHospital\\Imagens\\hospital.png");
        JLabel logoLabel = new JLabel(logo);
        mainPanel.add(logoLabel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        frame.setSize(2000, 1200);
        frame.setLocationRelativeTo(null); // Centralize a janela na tela
        frame.setVisible(true);


        frame.getContentPane().add(mainPanel);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Centralize a janela na tela
        frame.setVisible(true);
    }

    private void cadastrarMedico() {
        JTextField nomeField = new JTextField();
        JTextField crmField = new JTextField();
        JTextField especialidadeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nome do Médico:"));
        panel.add(nomeField);
        panel.add(new JLabel("CRM do Médico:"));
        panel.add(crmField);
        panel.add(new JLabel("Especialidade:"));
        panel.add(especialidadeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Médico",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nomeMedico = nomeField.getText();
            String crm = crmField.getText();
            String especialidade = especialidadeField.getText();

            gerenciamento.cadastrarMedico(nomeMedico, crm, especialidade);
            output("Médico cadastrado com sucesso!\n");
        }
    }


    private void cadastrarPaciente() {
        JTextField nomeField = new JTextField();
        JTextField sexoField = new JTextField();
        JTextField idadeField = new JTextField();
        JTextField alturaField = new JTextField();
        JTextField pesoField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nome Completo do Paciente:"));
        panel.add(nomeField);
        panel.add(new JLabel("Sexo do Paciente:"));
        panel.add(sexoField);
        panel.add(new JLabel("Idade do Paciente:"));
        panel.add(idadeField);
        panel.add(new JLabel("Altura do Paciente:"));
        panel.add(alturaField);
        panel.add(new JLabel("Peso do Paciente:"));
        panel.add(pesoField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Paciente",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nomePaciente = nomeField.getText();
            String sexo = sexoField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            double altura = Double.parseDouble(alturaField.getText());
            double peso = Double.parseDouble(pesoField.getText());

            gerenciamento.cadastrarPaciente(nomePaciente, sexo, idade, altura, peso);
            output("Paciente cadastrado com sucesso!\n");
        }
    }


    public void cadastrarFichaConsulta() {
        String[] nomesPacientes = gerenciamento.getNomesPacientes();
        String[] nomesMedicos = gerenciamento.getNomesMedicos();

        if (nomesPacientes.length == 0 || nomesMedicos.length == 0) {
            JOptionPane.showMessageDialog(frame, "Não há pacientes ou médicos cadastrados. A ficha de consulta não pode ser cadastrada.");
            return;
        }

        // Ordenar os nomes dos pacientes em ordem alfabética
        Arrays.sort(nomesPacientes);

        String nomePaciente = (String) JOptionPane.showInputDialog(frame, "Selecione o paciente:", "Cadastro de Ficha de Consulta",
                JOptionPane.QUESTION_MESSAGE, null, nomesPacientes, nomesPacientes[0]);

        if (nomePaciente == null) {
            return; // O usuário cancelou a seleção
        }

        String motivoConsulta = JOptionPane.showInputDialog(frame, "Informe o motivo da consulta:", "Cadastro de Ficha de Consulta",
                JOptionPane.QUESTION_MESSAGE);

        if (motivoConsulta == null || motivoConsulta.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Motivo da consulta não informado. A ficha de consulta não será cadastrada.");
            return;
        }

        // Ordenar as especialidades dos médicos em ordem alfabética
        Arrays.sort(nomesMedicos, Comparator.comparing(medico -> gerenciamento.getMedicoPorNome(medico).getEspecialidade()));

        // Criar um array de strings formatadas com nome e especialidade dos médicos
        String[] nomesMedicosFormatados = new String[nomesMedicos.length];
        for (int i = 0; i < nomesMedicos.length; i++) {
            Medico medico = gerenciamento.getMedicoPorNome(nomesMedicos[i]);
            nomesMedicosFormatados[i] = medico.getNome() + " - " + medico.getEspecialidade();
        }

        String nomeMedico = (String) JOptionPane.showInputDialog(frame, "Selecione o médico:", "Cadastro de Ficha de Consulta",
                JOptionPane.QUESTION_MESSAGE, null, nomesMedicosFormatados, nomesMedicosFormatados[0]);

        if (nomeMedico == null) {
            return; // O usuário cancelou a seleção
        }

        // Remover a parte da especialidade do nome do médico selecionado
        String nomeMedicoSelecionado = nomeMedico.split(" - ")[0];

        Medico medico = gerenciamento.getMedicoPorNome(nomeMedicoSelecionado);
        Paciente paciente = gerenciamento.getPacientePorNome(nomePaciente);

        if (medico == null) {
            JOptionPane.showMessageDialog(frame, "Médico não encontrado. A ficha de consulta não será cadastrada.");
            return;
        }

        if (paciente == null) {
            JOptionPane.showMessageDialog(frame, "Paciente não encontrado. A ficha de consulta não será cadastrada.");
            return;
        }

        gerenciamento.cadastrarFichaConsulta(motivoConsulta, medico, paciente);
        JOptionPane.showMessageDialog(frame, "Ficha de consulta cadastrada com sucesso!");
    }

    public void exibirFichasConsulta() {
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