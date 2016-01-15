import java.util.ArrayList;

/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    // Almacena el nombre del usuario.
    private String nombreUsuario;
    //Guarda la cantidad total de proteinas que ha comido el usuario
    private float proteinas;
    //Guarda la cantidad total de carbohidratos que ha comido el usuario
    private float carbohidratos;
    //Guarda la cantidad total de grasas que ha comido el usuario
    private float grasas;
    //Guarda la cantidad total de calorias que ha comido el usuario
    private float calorias;
    //Guarda el alimento mas calorico ingerido hasta el momento
    private Alimento masCalorias;
    //Guarda la lista de los alimentos consumidos por el usuario.
    private ArrayList<Alimento> listaAlimentosIngeridos;

    /**
     * Constructor for objects of class Usuario
     */
    public Usuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
        proteinas = 0;
        carbohidratos = 0;
        grasas = 0;
        calorias = 0;
        masCalorias = null;
        listaAlimentosIngeridos = new ArrayList<Alimento>();
    }

    /**
     * Metodo que permite al usuario comer, se le proporciona un alimento y los gramos que come del mismo.
     */
    public void comer(Alimento nombreAlimento, float gramosAlimento)
    {
        proteinas = proteinas + ((nombreAlimento.getProteinas()/100)*gramosAlimento);
        carbohidratos = carbohidratos + ((nombreAlimento.getCarbohidratos()/100)*gramosAlimento);
        grasas = grasas + ((nombreAlimento.getGrasas()/100)*gramosAlimento);
        calorias = calorias + ((nombreAlimento.getCalorias()/100)*gramosAlimento);

        if (masCalorias != null) {
            if (masCalorias.getCalorias() <= nombreAlimento.getCalorias()) {
                masCalorias = nombreAlimento;
            }
        }
        else {
            masCalorias = nombreAlimento;
        }
        listaAlimentosIngeridos.add(nombreAlimento);
    }

    /**
     * Muestra por pantalla la informacion de lo que ha comido el usuario.
     */
    public void mostrarDatos()
    {
        float totalNutrientes = (proteinas + grasas + carbohidratos) / 100;
        String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinas;
        String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " + carbohidratos;
        String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasas;
        if (proteinas > 0) {
            datosProteinas = datosProteinas + " (" + proteinas / totalNutrientes + "%)";
        }
        if (carbohidratos > 0) {
            datosCarbohidratos = datosCarbohidratos + " (" + carbohidratos / totalNutrientes + "%)";
        }
        if (grasas > 0) {
            datosGrasas = datosGrasas + " (" + grasas / totalNutrientes + "%)";
        }

        System.out.println("Nombre: " + nombreUsuario);
        System.out.println("Gramos totales de proteinas ingeridos: "+ proteinas);
        System.out.println("Gramos totales de carbohidratos ingeridos: "+ carbohidratos);
        System.out.println("Gramos totales de grasas ingeridos: "+ grasas);
        System.out.println("Calorias totales ingeridas: "+ calorias);
    }

    /**
     * Devuelve el nombre del usuario.
     */
    public String getNombre()
    {
        return nombreUsuario;
    }

    /**
     * Devuelve las calorias que ha consumido el usuario.
     */
    public float getCalorias()
    {
        return calorias;
    }

    /**
     * Metodo para comparar la ingesta de calorías entre dos usuarios.
     */
    public void compararCalorias (Usuario usuarioAComparar)
    {
        if (calorias > usuarioAComparar.getCalorias()){
            System.out.println(nombreUsuario + " ha consumido más calorias que " + usuarioAComparar.getNombre() + " (" + calorias + " frente a " + usuarioAComparar.getCalorias() + ")");
        }
        else if (calorias < usuarioAComparar.getCalorias()){
            System.out.println(usuarioAComparar.getNombre() + " ha consumido más calorias que " + nombreUsuario + " (" + usuarioAComparar.getCalorias() + " frente a " + calorias + ")");
        }
        else {
            System.out.println(nombreUsuario + " ha consumido las mismas calorias que " + usuarioAComparar.getNombre() + " (" + calorias + " igual a " + usuarioAComparar.getCalorias() + ")");
        } 
    }

    /**
     * Permite visualizar por pantalla el nombre del alimento más calórico por cada 100 gramos consumido hasta ahora por un usuario.
     */
    public void alimentoMasCalorico()
    {
        if (masCalorias != null) {
            System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: " + masCalorias.getNombreAlimento() + " (" + masCalorias.getCalorias() + " calorias por cada 100 gramos)");
        }
        else {
            System.out.println("Aun no ha ingerido alimentos");
        }
    }

    /**
     * Permite visualizar por pantalla los datos nutricionales del alimento que el usuario ha comido en una determinada posición.
     */
    public void verDatosNutricionales(int index)
    {
        if ((index >= 1) && (index <= listaAlimentosIngeridos.size())) {
            Alimento alimentoParaMostrar = listaAlimentosIngeridos.get(index - 1);
            alimentoParaMostrar.muestraDatos();            
            //listaAlimentosIngeridos.get(index - 1).muestraDatos();
        }
        else {
            System.out.println("El indice introducido no es valido");
        }
    }

    /**
     *  Permite pasar como parámetro el nombre de un alimento e indique si el usuario ha comido ese alimento más de una vez o no.
     *  Si lo ha hecho, cuántas veces lo ha hecho.
     */
    public void seHaComidoElAlimento(String nombreAlimento)
    {
        int contador = 0;
        for (Alimento alimentoQueBusco : listaAlimentosIngeridos) {
            if (alimentoQueBusco.getNombreAlimento().contains(nombreAlimento)) {
                contador++;
            }
        }
        if (contador == 1) {
            System.out.println("El usuario ha comido el alimento " + nombreAlimento + " " + " 1 vez");
        }
        else if (contador > 1) {
            System.out.println("El usuario ha comido el alimento " + nombreAlimento + " " + contador + " veces");
        }
        else {
            System.out.println("El usuario no ha comido el alimento " + nombreAlimento);
        }
    }
    
    /**
     * Informa de los nombres de aquellos alimentos que el usuario ha consumido más de una vez, en caso de que los haya.
     */
    public void queHaConsumidoVariasVeces()
    {
        int contador = 0;
        for (Alimento comidoVariasVeces : listaAlimentosIngeridos) {
            if (
        }
    }
}
