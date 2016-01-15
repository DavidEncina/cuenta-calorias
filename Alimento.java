
/**
 * Write a description of class Alimento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alimento
{
    // Almacena el nombre del alimento.
    private String nombreAlimento;
    // Almacena las proteinas del alimento.
    private float gramosProteinas;
    // Almacena los carbohidratos del alimento.
    private float gramosCarbohidratos;
    // Almacena las grasas del alimento.
    private float gramosGrasas;
    // Almacena el macronutriente del alimento.
    private String macronutriente;
    // Almacena las calorias del alimento.
    private float calorias;

    /**
     * Constructor for objects of class Alimento
     */
    public Alimento(String nombreAlimento, float gramosProteinas, float gramosCarbohidratos, float gramosGrasas)
    {
        this.nombreAlimento = nombreAlimento;
        this.gramosProteinas = gramosProteinas;
        this.gramosCarbohidratos = gramosCarbohidratos;
        this.gramosGrasas = gramosGrasas;         
        if (gramosProteinas >= 0 && gramosCarbohidratos >= 0 && gramosGrasas >= 0) {
            calorias = (gramosProteinas * 4) + (gramosCarbohidratos * 4) + (gramosGrasas * 9);
        }        
        if (gramosProteinas >= gramosCarbohidratos && gramosProteinas >= gramosGrasas) {
            macronutriente = "Proteinas";
            if (gramosProteinas == gramosCarbohidratos && gramosProteinas == gramosGrasas) {
                macronutriente = "Proteinas, carbohidratos y grasas";
            }
            else if (gramosProteinas == gramosCarbohidratos) {
                macronutriente = "Proteinas y carbohidratos";
            }
            else if (gramosProteinas == gramosGrasas) {
                macronutriente = "Proteinas y grasas";
            }
        }
        if (gramosCarbohidratos >= gramosProteinas && gramosCarbohidratos >= gramosGrasas) {
            macronutriente = "Carbohidratos";
            if (gramosCarbohidratos == gramosProteinas) {
                macronutriente = "Carbohidratos y proteinas";
            }
            else if (gramosCarbohidratos == gramosGrasas) {
                macronutriente = "Carbohidratos y grasas";
            }
        }
        if (gramosGrasas >= gramosProteinas && gramosGrasas >= gramosCarbohidratos) {
            macronutriente = "Grasas";
            if (gramosGrasas == gramosProteinas) {
                macronutriente = "Grasas y proteinas";
            }
            else if (gramosGrasas == gramosCarbohidratos) {
                macronutriente = "Grasas y carbohidratos";
            }
        }
    }

    /**
     * Metodo que nos enseña por pantalla el alimento y las proteinas, carbohidratos y grasas de este.
     * Ademas tambien muestra sus calorias y componentes mayoritarios.
     */
    public void muestraDatos()
    {
        System.out.println("Nombre: " + nombreAlimento);
        System.out.println("Proteinas por cada 100 gramos: " + gramosProteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + gramosCarbohidratos);
        System.out.println("Grasas por cada 100 gramos: " + gramosGrasas);
        System.out.println("Calorias: " + calorias);
        System.out.println("Componente/s mayoritario/s: " + macronutriente);
    }
    
    /**
     * Devuelve las Proteinas
     */
    public float getProteinas()
    {
        return gramosProteinas;
    }
    
    /**
     * Devuelve los carbohidratos
     */
    public float getCarbohidratos()
    {
        return gramosCarbohidratos;
    }
    
    /**
     * Devuelve las grasas
     */
    public float getGrasas()
    {
        return gramosGrasas;
    }
    
    /**
     * Devuelve las Calorias
     */
    public float getCalorias()
    {
        return calorias;
    }
    
    /**
     * Devuelve el nombre del alimento que se consume.
     */
    public String getNombreAlimento()
    {
        return nombreAlimento;
    }
}
