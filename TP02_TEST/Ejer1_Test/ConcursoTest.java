package Ejer1_Test;

import Ejer1.Concurso;
import Ejer1.EnDiscoRegistroDeInscripcion;
import Ejer1.Inscripcion;
import Ejer1.Participante;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class ConcursoTest {
    String rutaEjemplo = "TP02/TextDoc2026_1.txt";

    @Test
    void participanteInscrito(){
        Concurso concurso1 = new Concurso(101,
                LocalDate.of(2026, 3, 20),
                LocalDate.of(2026,4,29),
                new EnDiscoRegistroDeInscripcion(rutaEjemplo)
        );

        Participante participante = new Participante("Rodrigo Quichan", "43138364");
        Inscripcion inscripcion1 = new Inscripcion(participante, LocalDate.now());
        concurso1.inscribirParticipante(inscripcion1);

        //Verificación
        Assert.assertTrue(concurso1.estaInscrito(participante));
    }

    @Test
    void participanteNoInscrito(){
        Concurso concurso1 = new Concurso(102,
                LocalDate.of(2026, 3, 20),
                LocalDate.of(2026,4,29),
                new EnDiscoRegistroDeInscripcion(rutaEjemplo)
        );

        Participante part1 = new Participante("Rodrigo Quichan", "43138364");
        Participante part2 = new Participante("Daniel Correa", "20000000");

        Inscripcion i1 = new Inscripcion(part1, LocalDate.now());
        concurso1.inscribirParticipante(i1);

        //Verificación
        Assert.assertFalse(concurso1.estaInscrito(part2));
    }

    @Test
    void puntajeNuloParticipante(){
        Concurso concurso1 = new Concurso(103,
                LocalDate.of(2026, 3, 20),
                LocalDate.of(2026,4,29),
                new EnDiscoRegistroDeInscripcion(rutaEjemplo)
        );

        Participante participante = new Participante("Rodrigo Quichan", "43138364");
        Inscripcion inscripcion1 = new Inscripcion(participante, LocalDate.now());

        concurso1.inscribirParticipante(inscripcion1);


        //Verificacion

        System.out.println(participante.toString());

        int puntajeAcumulado = concurso1.obtenerParticipante("43138364").getPuntaje();
        Assert.assertEquals(0, puntajeAcumulado);
    }

    @Test
    void puntaje10Participante(){
        Concurso concurso1 = new Concurso(104,
                LocalDate.now(),
                LocalDate.of(2026,4,29),
                new EnDiscoRegistroDeInscripcion(rutaEjemplo)
        );

        Participante participante = new Participante("Rodrigo Quichan", "43138364");
        Inscripcion inscripcion1 = new Inscripcion(participante, LocalDate.now());

        concurso1.inscribirParticipante(inscripcion1);

        //Verificacion
        int puntajeAcumulado = concurso1.obtenerParticipante("43138364").getPuntaje();
        Assert.assertEquals(10, puntajeAcumulado);

    }
}