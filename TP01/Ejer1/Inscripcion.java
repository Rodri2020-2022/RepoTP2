package Ejer1;

import java.time.LocalDate;

public class Inscripcion {
    private Participante participante;
    private LocalDate fecha;

    public Inscripcion(Participante participante, LocalDate fecha) {
        this.participante = participante;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public Participante getParticipante() {
        return participante;
    }
}
