package net.ausiasmarch.estadistica.modelo;


import java.util.*;

import net.ausiasmarch.common.Convert;
import net.ausiasmarch.estadistica.comparators.CiudadComparator;
import net.ausiasmarch.estadistica.comparators.ComunidadCiudadComparator;
import net.ausiasmarch.estadistica.comparators.HabitantesComparator;

/**
 * GestorCiudades.java
 *
 * @author Desarrollador
 */
public class GestorCiudades {

    // Lista de ciudades
    private List<Ciudad> ciudades;

    /**
     * Constructor
     */
    public GestorCiudades() {
        ciudades = new ArrayList<Ciudad>();   // crea la lista de ciudades
    }

    /**
     * Obtiene la lista de ciudades
     *
     * @return List
     */
    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    /**
     * Establece la lista de ciudades
     *
     * @param ciudades
     */
    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * Obtiene la suma de habitantes de todas las ciudades
     *
     * @return int
     */
    public long totalHabitantes() {   
    	long resultado=0;
    	for(Ciudad c: ciudades) {
    		resultado+=c.getHabitantes();
    	}
    	return resultado;
    }
    
    public long totalHabitantes(List<Ciudad> ciudades) {   
    	long resultado=0;
    	for(Ciudad c: ciudades) {
    		resultado+=c.getHabitantes();
    	}
    	return resultado;
    }

    /**
     * Obtiene el numero de ciudades de la lista
     *
     * @return int
     */
    public int numCiudades() {
    	return ciudades.size();
    }
    public int numCiudades(List<Ciudad> ciudades) {
    	return ciudades.size();
    }

    /**
     * Obtiene la media de habitantes de las ciudades
     *
     * @return double
     */
     public double mediaHabitantes() {  
    	 double media=totalHabitantes()/numCiudades();
    	 return media;
     }

    /**
     * Ordena las ciudades de menor a mayor habitantes
     */
    public void ordenarHabitantesAsc() {
     Collections.sort(this.ciudades, new HabitantesComparator());
    }

    /**
     * Ordena las ciudades por de mayor a menor habitantes
     */
    public void ordenarHabitantesDesc() { 
    	ordenarHabitantesAsc();
    	 Collections.reverse(this.ciudades);
    }

    /**
     * Ordena las ciudades alfabetiamente por ciudad dentro de cada comunidad
     */
    public void ordenarComunidadCiudad() {
    	Collections.sort(this.ciudades, new ComunidadCiudadComparator());
	  }

    /**
     * Busca la ciudad con el nombre indicado
     *
     * @param nombreCiudad
     * @return List
     */
    public Ciudad buscarCiudad(String nombreCiudad) {
      	int indice=0;
    	for(Ciudad c: ciudades) {
    		
    		if(c.getCiudad().equalsIgnoreCase(nombreCiudad)) {
    	    	return ciudades.get(indice);
    		}
    		indice++;
    	}	
    	return null;
      }
    

    /**
     * Borra la ciudad con el nombre indicado de una comunidad
     *
     * @param nombre
     * @return List
     */
  public boolean borrarCiudad(String nombre,HashMap<String,List<Ciudad>> listaCom) {
	   
	   Ciudad ciudadBuscada=buscarCiudad(nombre);
	   String comunidad=ciudadBuscada.getComunidad();
	   
	   List<Ciudad> listaCiudades=listaCom.get(comunidad);
	   
	
	   
   	for(int i=0;i<ciudades.size();i++) {
   		if(ciudades.get(i).getCiudad().equalsIgnoreCase(nombre)) {
   			ciudades.remove(i);
   		   listaCiudades.remove(ciudadBuscada);
   		if (listaCiudades.isEmpty()) {
			listaCom.remove(comunidad);
		}
   			return true;
   		}
   	}	
   	
   	return false;
    }
  
    /**
     * Obtiene la ciudad con mayor habitantes
     *
     * @return Ciudad
     */
    public Ciudad ciudadMayorHabitantes() {
    	
    	return Collections.max(ciudades, new HabitantesComparator());
     }

    /**
     * Convierte un Lista de objetos ciudad en un list de list con los datos de
     * cada ciudad
     *
     * @param ciudades
     * @return
     */
    public List<List> aslistaCiudades(List<Ciudad> ciudades) {
        List<List> listaCiudades = new ArrayList();
        for (Ciudad ciudad : ciudades) {
            List lista = new ArrayList();
            lista.add(ciudad.getComunidad());
            lista.add(ciudad.getCiudad());
            lista.add(ciudad.getHabitantes());
            listaCiudades.add(lista);
        }
        return listaCiudades;
    }
    public List<List> aslistaComunidad(HashMap<String,List<Ciudad>> ciudades){
    	List<List> datosComunidad=new ArrayList();
    	
    	Set<String> clave=ciudades.keySet();
    	Iterator<String> it=clave.iterator();
    	while(it.hasNext()) {
    		String valor=it.next();
    		List<Ciudad> datos=ciudades.get(valor);
    		List lista= new ArrayList();
    		
    		lista.add(valor);
    		lista.add(numCiudades(datos));
    		lista.add(totalHabitantes(datos));
    		
    		datosComunidad.add(lista);
    	}
    		return datosComunidad;
    		
    }
  
 }   
 // fin del gestor








