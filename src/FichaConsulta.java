import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FichaConsulta {
    private String nomePaciente;
    private String sexoPaciente;
    private int idadePaciente;
    private String motivoConsulta;
    private Medico medico;
    private LocalDateTime dataHora;

    public FichaConsulta(String nomePaciente, String sexoPaciente, int idadePaciente, String motivoConsulta, Medico medico) {
        this.nomePaciente = nomePaciente;
        this.sexoPaciente = sexoPaciente;
        this.idadePaciente = idadePaciente;
        this.motivoConsulta = motivoConsulta;
        this.medico = medico;
        this.dataHora = LocalDateTime.now();
    }

    public String getDataHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public int getIdadePaciente() {
        return idadePaciente;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getEspecialidadeMedico() {
        return medico.getEspecialidade();
    }
}