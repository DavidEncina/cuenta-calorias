
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
}
