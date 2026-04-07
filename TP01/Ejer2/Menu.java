package Ejer2;

public class Menu {
    public static final Plato MILANESA =
            new Plato("MINALESA NAPOLITANA",
                    "Milanesa de carne con una porcion de limon, lechuga y aderezos",
                    20000,
                    TIPO.PRINCIPAL);
    public static final Plato MILANESA_GIGANTE =
            new Plato("MINALESA NAPOLITANA GIGANTE",
                    "Milanesa de carne de mayor tamaño (el doble de la milanesa normal) con una porcion de limon, lechuga y aderezos",
                    35000,
                    TIPO.PRINCIPAL);
    public static final Plato PAPAS_FRITAS =
            new Plato("PAPAS FRITAS",
                    "Paquete de papas fritas",
                    9000,
                    TIPO.ENTRADA);

    public static final Bebida PEPSI_BOTELLA = new Bebida("Gaseosa de cola 200ml", 4500);


}
