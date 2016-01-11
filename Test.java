
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Test
     */
    public void Test1()
    {
        Alimento alimento1 = new Alimento("pan", 1, 1, 1);
        Alimento alimento2 = new Alimento("vino", 2, 2, 2);
		Usuario usuario1 = new Usuario("pepe");
		Usuario usuario2 = new Usuario("juan");
		
		usuario1.comer(alimento1, 1);
		usuario2.comer(alimento2, 1);
		
		usuario1.compararCalorias(usuario2);		
    }
    
    /**
     * Constructor for objects of class Test
     */
    public void Test2()
    {
        Alimento alimento1 = new Alimento("pan", 1, 1, 1);
        Alimento alimento2 = new Alimento("vino", 2, 2, 2);
		Usuario usuario1 = new Usuario("pepe");
		Usuario usuario2 = new Usuario("juan");
		
		usuario1.comer(alimento1, 1);
		usuario2.comer(alimento1, 1);
		
		usuario1.compararCalorias(usuario2);		
    }
    
    /**
     * Constructor for objects of class Test
     */
    public void Test3()
    {
        Alimento alimento1 = new Alimento("pan", 1, 1, 1);
        Alimento alimento2 = new Alimento("vino", 2, 2, 2);
		Usuario usuario1 = new Usuario("pepe");
		Usuario usuario2 = new Usuario("juan");
		
		usuario1.comer(alimento2, 1);
		usuario2.comer(alimento1, 1);
		
		usuario1.compararCalorias(usuario2);		
    }
}
