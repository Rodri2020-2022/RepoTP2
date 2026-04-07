package Ejer1;

public class Participante {
    private String nombre;
    private String dni;
    private int puntaje;

    public Participante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void sumarPuntaje(int puntos){
        this.puntaje += puntos;
    }

    @Override
    public String toString() {
        return "Modelo.Ejer1.Participante {" +
                "Nombre = " + nombre + '\'' +
                ", Dni = " + dni + '\'' +
                ", Puntaje = " + puntaje +
                '}';
    }

    //Getters
    public String getDni() {
        return dni;
    }
    public int getPuntaje() {
        return puntaje;
    }

}
