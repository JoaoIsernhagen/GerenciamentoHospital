class Paciente {
    private String nome;
    private String sexo;
    private int idade;
    private double altura;
    private double peso;

    public Paciente(){

    }

    public Paciente(String nome, String sexo, int idade, double altura, double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public static void adicionarPacientesIniciais(GerenciamentoHospital gerenciamentoHospital) {
        gerenciamentoHospital.cadastrarPaciente("Ana Maria Santos", "Feminino", 42, 1.68, 68.5);
        gerenciamentoHospital.cadastrarPaciente("Juliana Pereira Santos", "Feminino", 28, 1.70, 63.7);
        gerenciamentoHospital.cadastrarPaciente("Felipe Martins Ferreira", "Masculino", 35, 1.78, 76.4);
        gerenciamentoHospital.cadastrarPaciente("Laura Almeida Rocha", "Feminino", 49, 1.64, 72.1);
        gerenciamentoHospital.cadastrarPaciente("André Santos Silva", "Masculino", 37, 1.82, 79.8);
        gerenciamentoHospital.cadastrarPaciente("Carolina Oliveira Costa", "Feminino", 33, 1.69, 65.2);
        gerenciamentoHospital.cadastrarPaciente("Guilherme Mendes Rocha", "Masculino", 29, 1.73, 74.6);
        gerenciamentoHospital.cadastrarPaciente("Beatriz Fernandes Lima", "Feminino", 31, 1.67, 61.8);
        gerenciamentoHospital.cadastrarPaciente("Rafaela Ferreira Almeida", "Feminino", 27, 1.68, 58.3);
        gerenciamentoHospital.cadastrarPaciente("Matheus Costa Santos", "Masculino", 43, 1.85, 88.7);
        gerenciamentoHospital.cadastrarPaciente("Isabela Lima Oliveira", "Feminino", 50, 1.60, 69.4);
        gerenciamentoHospital.cadastrarPaciente("Rodrigo Santos Silva", "Masculino", 34, 1.79, 82.5);
        gerenciamentoHospital.cadastrarPaciente("Camila Rocha Fernandes", "Feminino", 26, 1.66, 60.1);
        gerenciamentoHospital.cadastrarPaciente("Lucas Almeida Costa", "Masculino", 39, 1.81, 77.9);
        gerenciamentoHospital.cadastrarPaciente("Mariana Silva Santos", "Feminino", 32, 1.70, 64.3);
        gerenciamentoHospital.cadastrarPaciente("Gabriel Lima Ferreira", "Masculino", 36, 1.77, 81.2);
        gerenciamentoHospital.cadastrarPaciente("Isadora Costa Pereira", "Feminino", 45, 1.63, 67.8);

    }
}