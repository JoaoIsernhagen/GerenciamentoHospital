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

    private void cadastrarFichaConsulta() {
        String[] nomesPacientes = gerenciamento.getNomesPacientes();
        String[] nomesMedicos = gerenciamento.getNomesMedicos();

        if (nomesPacientes.length == 0 || nomesMedicos.length == 0) {
            output("Não há pacientes ou médicos cadastrados. A ficha de consulta não pode ser cadastrada.\n");
            return;
        }

        String nomePaciente = (String) JOptionPane.showInputDialog(frame, "Selecione o paciente:", "Cadastro de Ficha de Consulta",
                JOptionPane.QUESTION_MESSAGE, null, nomesPacientes, nomesPacientes[0]);

        if (nomePaciente == null) {
            return; // O usuário cancelou a seleção
        }

        String nomeMedico = (String) JOptionPane.showInputDialog(frame, "Selecione o médico:", "Cadastro de Ficha de Consulta",
                JOptionPane.QUESTION_MESSAGE, null, nomesMedicos, nomesMedicos[0]);

        if (nomeMedico == null) {
            return; // O usuário cancelou a seleção
        }

        Medico medico = gerenciamento.getMedicoPorNome(nomeMedico);
        Paciente paciente = gerenciamento.getPacientePorNome(nomePaciente);

        if (medico == null) {
            output("Médico não encontrado. A ficha de consulta não será cadastrada.\n");
            return;
        }

        if (paciente == null) {
            output("Paciente não encontrado. A ficha de consulta não será cadastrada.\n");
            return;
        }

        gerenciamento.cadastrarFichaConsulta("", medico, paciente);
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