package Ejer1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Concurso {
    private List<Inscripcion> inscriptos;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinalInscripcion;

    public Concurso(LocalDate fechaInicioInscripcion, LocalDate fechaFinalInscripcion) {
        this.inscriptos = new ArrayList<Inscripcion>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinalInscripcion = fechaFinalInscripcion;
    }

    //Ejer1.Inscripcion
    public void inscribirParticipante(Inscripcion inscripcion){
        if(fechaValida(inscripcion.getFecha())){
            this.inscriptos.add(inscripcion);
            if(inscripcion.getFecha().equals(fechaInicioInscripcion))
                otorgar10Puntos(inscripcion.getParticipante());
        }
    }
    private boolean fechaValida(LocalDate fecha) {
        return !fecha.isBefore(fechaInicioInscripcion) && !fecha.isAfter(fechaFinalInscripcion);
    }
    private void otorgar10Puntos(Participante participante) {
        participante.sumarPuntaje(10);
    }


    //Otros metodos
    public boolean estaInscrito(Participante participante){
        return this.inscriptos.stream().anyMatch(
                inscripcion -> participante.equals(inscripcion.getParticipante()));
    }

    public Participante obtenerParticipante(String dni){
        return participantes().stream().filter(
                participante -> participante.getDni().equals(dni)
        ).findFirst().get();
    }

    private List<Participante> participantes(){
        return inscriptos.stream().map(Inscripcion::getParticipante)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
