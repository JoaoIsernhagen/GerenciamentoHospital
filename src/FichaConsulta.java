import java.util.Date;

class FichaConsulta {
    private String motivoConsulta;
    private Medico medico;
    private Paciente paciente;
    private Date dataConsulta;

    public FichaConsulta(String motivoConsulta, Medico medico, Paciente paciente) {
        this.motivoConsulta = motivoConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.dataConsulta = new Date();
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }
}