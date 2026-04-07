package Ejer2;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int nroMesa;
    private int capacidadPorPersona;
    private List<Comensal> comensales;

    public Mesa(int nroMesa, int capacidadPorPersona) {
        this.nroMesa = nroMesa;
        this.capacidadPorPersona = capacidadPorPersona;
        this.comensales = new ArrayList<Comensal>();
    }

    public void asignarComensal(Comensal comensal){
        this.comensales.add(comensal);
    }
    public List<Comensal> getComensales() {
        return comensales;
    }

}
