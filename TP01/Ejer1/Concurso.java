package Ejer1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Concurso {
    private int id;
    private List<Inscripcion> inscriptos;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinalInscripcion;
    private RegistroDeInscripcion registro;

    public Concurso(int id, LocalDate fechaInicioInscripcion, LocalDate fechaFinalInscripcion, RegistroDeInscripcion registro) {
        this.id = id;
        this.inscriptos = new ArrayList<Inscripcion>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinalInscripcion = fechaFinalInscripcion;
        this.registro = registro;
    }

    //Ejer1.Inscripcion
    public void inscribirParticipante(Inscripcion inscripcion){
        if (!fechaValida(inscripcion.getFecha()))
            throw new RuntimeException("Inscripcion cerrada");
        if(esElPrimerDiaDeInscripcion(inscripcion))
            otorgar10Puntos(inscripcion.getParticipante());

        this.inscriptos.add(inscripcion);
        String registroEnTexto = inscripcion.getFecha() + ", " + inscripcion.getParticipante().getNombre() + ", " + this.id + "\n";

        this.registro.registrar(registroEnTexto);


    }

    private boolean esElPrimerDiaDeInscripcion(Inscripcion inscripcion) {
        return inscripcion.getFecha().equals(fechaInicioInscripcion);
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
