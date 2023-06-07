public class Medico {
    private String nome;
    private String crm;
    private String especialidade;

    public Medico(){

    }

    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
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

    public static void adicionarMedicosIniciais(GerenciamentoHospital gerenciamentoHospital) {
        gerenciamentoHospital.cadastrarMedico("Dr. Lucas Oliveira", "12345", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Dr. Camila Santos", "23456", "Neurologista");
        gerenciamentoHospital.cadastrarMedico("Dr. Pedro Almeida", "34567", "Pediatra");
        gerenciamentoHospital.cadastrarMedico("Dr. Ana Costa", "45678", "Ginecologista");
        gerenciamentoHospital.cadastrarMedico("Dr. Rafael Lima", "56789", "Psiquiatria");
        gerenciamentoHospital.cadastrarMedico("Dr. Juliana Souza", "67890", "Cardiologia");
        gerenciamentoHospital.cadastrarMedico("Dr. Mateus Ferreira", "78901", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Dr. Isabella Fernandes", "89012", "Neurologista");
        gerenciamentoHospital.cadastrarMedico("Dr. Gustavo Cardoso", "90123", "Pediatra");
        gerenciamentoHospital.cadastrarMedico("Dr. Laura Rodrigues", "01234", "Ginecologista");
        gerenciamentoHospital.cadastrarMedico("Dr. Rodrigo Santos", "23451", "Psiquiatria");
        gerenciamentoHospital.cadastrarMedico("Dr. Mariana Oliveira", "34562", "Cardiologia");
        gerenciamentoHospital.cadastrarMedico("Dr. Gabriel Alves", "45673", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Dr. Carolina Costa", "56784", "Neurologista");
        gerenciamentoHospital.cadastrarMedico("Dr. Thiago Lima", "67895", "Pediatra");
        gerenciamentoHospital.cadastrarMedico("Dr. Amanda Souza", "78906", "Ginecologista");
        gerenciamentoHospital.cadastrarMedico("Dr. Eduardo Ferreira", "89017", "Psiquiatria");
        gerenciamentoHospital.cadastrarMedico("Dr. Beatriz Fernandes", "90128", "Cardiologia");
        gerenciamentoHospital.cadastrarMedico("Dr. Marcelo Cardoso", "01239", "Clinico Geral");
        gerenciamentoHospital.cadastrarMedico("Dr. Livia Rodrigues", "23450", "Clinico Geral");
    }
}