import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nomeCompleto;
    private String sexo;
    private int idade;

    public Paciente(String nomeCompleto, String sexo, int idade) {
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public static List<Paciente> criarPacientesIniciais() {
        List<Paciente> pacientes = new ArrayList<>();

        pacientes.add(new Paciente("João Silva", "Masculino", 25));
        pacientes.add(new Paciente("Ana Santos", "Feminino", 32));
        pacientes.add(new Paciente("Pedro Almeida", "Masculino", 41));
        pacientes.add(new Paciente("Sofia Costa", "Feminino", 19));
        pacientes.add(new Paciente("Luís Pereira", "Masculino", 37));
        pacientes.add(new Paciente("Maria Oliveira", "Feminino", 28));
        pacientes.add(new Paciente("André Santos", "Masculino", 43));
        pacientes.add(new Paciente("Carolina Rodrigues", "Feminino", 22));
        pacientes.add(new Paciente("Tiago Ferreira", "Masculino", 30));
        pacientes.add(new Paciente("Beatriz Martins", "Feminino", 27));
        pacientes.add(new Paciente("Ricardo Sousa", "Masculino", 35));
        pacientes.add(new Paciente("Jéssica Carvalho", "Feminino", 24));
        pacientes.add(new Paciente("Mário Rodrigues", "Masculino", 29));
        pacientes.add(new Paciente("Mariana Costa", "Feminino", 31));
        pacientes.add(new Paciente("Gabriel Fernandes", "Masculino", 38));
        pacientes.add(new Paciente("Laura Mendes", "Feminino", 23));
        pacientes.add(new Paciente("Hugo Pereira", "Masculino", 34));
        pacientes.add(new Paciente("Sofia Santos", "Feminino", 26));
        pacientes.add(new Paciente("Miguel Almeida", "Masculino", 39));
        pacientes.add(new Paciente("Inês Silva", "Feminino", 21));
        pacientes.add(new Paciente("António Oliveira", "Masculino", 33));
        pacientes.add(new Paciente("Catarina Ferreira", "Feminino", 20));
        pacientes.add(new Paciente("Diogo Sousa", "Masculino", 36));
        pacientes.add(new Paciente("Inês Costa", "Feminino", 25));
        pacientes.add(new Paciente("Rafael Fernandes", "Masculino", 40));
        pacientes.add(new Paciente("Diana Carvalho", "Feminino", 29));
        pacientes.add(new Paciente("Manuel Rodrigues", "Masculino", 42));
        pacientes.add(new Paciente("Sofia Alves", "Feminino", 24));
        pacientes.add(new Paciente("Rui Silva", "Masculino", 37));
        pacientes.add(new Paciente("Beatriz Pereira", "Feminino", 22));
        pacientes.add(new Paciente("Nuno Martins", "Masculino", 31));
        pacientes.add(new Paciente("Joana Sousa", "Feminino", 27));
        pacientes.add(new Paciente("Diogo Santos", "Masculino", 36));
        pacientes.add(new Paciente("Rita Mendes", "Feminino", 23));
        pacientes.add(new Paciente("André Ferreira", "Masculino", 39));
        pacientes.add(new Paciente("Carolina Costa", "Feminino", 20));
        pacientes.add(new Paciente("Miguel Sousa", "Masculino", 28));
        pacientes.add(new Paciente("Mariana Santos", "Feminino", 30));
        pacientes.add(new Paciente("Hugo Almeida", "Masculino", 32));
        pacientes.add(new Paciente("Leonor Silva", "Feminino", 25));
        pacientes.add(new Paciente("Luís Costa", "Masculino", 36));
        pacientes.add(new Paciente("Sofia Fernandes", "Feminino", 33));
        pacientes.add(new Paciente("David Carvalho", "Masculino", 26));
        pacientes.add(new Paciente("Ana Mendes", "Feminino", 34));
        pacientes.add(new Paciente("Carlos Rodrigues", "Masculino", 31));
        pacientes.add(new Paciente("Inês Alves", "Feminino", 29));
        pacientes.add(new Paciente("Diogo Pereira", "Masculino", 30));
        pacientes.add(new Paciente("Rita Santos", "Feminino", 28));
        pacientes.add(new Paciente("André Oliveira", "Masculino", 37));
        pacientes.add(new Paciente("Joana Ferreira", "Feminino", 24));
        pacientes.add(new Paciente("Sofia Gomes", "Feminino", 17));
        pacientes.add(new Paciente("Pedro Costa", "Masculino", 16));
        pacientes.add(new Paciente("Marta Santos", "Feminino", 14));
        pacientes.add(new Paciente("José Alves", "Masculino", 15));
        pacientes.add(new Paciente("Beatriz Rodrigues", "Feminino", 13));
        pacientes.add(new Paciente("Luísa Oliveira", "Feminino", 12));
        pacientes.add(new Paciente("Diogo Mendes", "Masculino", 17));
        pacientes.add(new Paciente("Carolina Sousa", "Feminino", 16));
        pacientes.add(new Paciente("Sofia Fernandes", "Feminino", 15));
        pacientes.add(new Paciente("Miguel Santos", "Masculino", 14));
        pacientes.add(new Paciente("Antónia Almeida", "Feminino", 62));
        pacientes.add(new Paciente("Manuel Pereira", "Masculino", 65));
        pacientes.add(new Paciente("Maria Rodrigues", "Feminino", 70));
        pacientes.add(new Paciente("Joaquim Fernandes", "Masculino", 68));
        pacientes.add(new Paciente("Augusta Silva", "Feminino", 72));
        pacientes.add(new Paciente("Artur Costa", "Masculino", 66));
        pacientes.add(new Paciente("Margarida Santos", "Feminino", 61));
        pacientes.add(new Paciente("Alfredo Ferreira", "Masculino", 71));
        pacientes.add(new Paciente("Olga Carvalho", "Feminino", 69));
        pacientes.add(new Paciente("Isidro Sousa", "Masculino", 74));
        pacientes.add(new Paciente("Emília Oliveira", "Feminino", 67));
        pacientes.add(new Paciente("Arnaldo Santos", "Masculino", 73));
        pacientes.add(new Paciente("Júlia Alves", "Feminino", 75));
        pacientes.add(new Paciente("Leonel Rodrigues", "Masculino", 70));
        pacientes.add(new Paciente("Berta Costa", "Feminino", 78));
        pacientes.add(new Paciente("Amadeu Martins", "Masculino", 76));
        pacientes.add(new Paciente("Celeste Mendes", "Feminino", 80));
        pacientes.add(new Paciente("Henrique Ferreira", "Masculino", 79));
        pacientes.add(new Paciente("Odete Silva", "Feminino", 77));
        pacientes.add(new Paciente("Augusto Pereira", "Masculino", 82));

        return pacientes;
    }
}
