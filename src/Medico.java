public class Medico {
    private String nome;
    private String crm;
    private String especialidade;

    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }
    public static void adicionarMedicosIniciais(GerenciamentoHospital gerenciamentoHospital) {
        gerenciamentoHospital.cadastrarMedico("Lucas Oliveira", "12345", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Camila Santos", "23456", "Neurologista");
        gerenciamentoHospital.cadastrarMedico("Pedro Almeida", "34567", "Pediatra");
        gerenciamentoHospital.cadastrarMedico("Ana Costa", "45678", "Ginecologista");
        gerenciamentoHospital.cadastrarMedico("Rafael Lima", "56789", "Psiquiatria");
        gerenciamentoHospital.cadastrarMedico("Juliana Souza", "67890", "Cardiologia");
        gerenciamentoHospital.cadastrarMedico("Mateus Ferreira", "78901", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Isabella Fernandes", "89012", "Neurologista");
        gerenciamentoHospital.cadastrarMedico("Gustavo Cardoso", "90123", "Pediatra");
        gerenciamentoHospital.cadastrarMedico("Laura Rodrigues", "01234", "Ginecologista");
        gerenciamentoHospital.cadastrarMedico("Rodrigo Santos", "23451", "Psiquiatria");
        gerenciamentoHospital.cadastrarMedico("Mariana Oliveira", "34562", "Cardiologia");
        gerenciamentoHospital.cadastrarMedico("Gabriel Alves", "45673", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Carolina Costa", "56784", "Neurologista");
        gerenciamentoHospital.cadastrarMedico("Thiago Lima", "67895", "Pediatra");
        gerenciamentoHospital.cadastrarMedico("Amanda Souza", "78906", "Ginecologista");
        gerenciamentoHospital.cadastrarMedico("Eduardo Ferreira", "89017", "Psiquiatria");
        gerenciamentoHospital.cadastrarMedico("Beatriz Fernandes", "90128", "Cardiologia");
        gerenciamentoHospital.cadastrarMedico("Marcelo Cardoso", "01239", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Livia Rodrigues", "23450", "Clinico Geral");
    }


    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
