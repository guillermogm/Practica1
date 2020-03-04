package net.ausiasmarch.estadistica.comparators;

import java.util.Comparator;

import net.ausiasmarch.estadistica.modelo.Ciudad;

public class HabitantesComparator implements Comparator<Ciudad> {
    @Override
    /**
     * Compara los habitantes de dos objetos ciudad
     */
    public int compare(Ciudad ciudad1, Ciudad ciudad2) {
        long habitantes=ciudad1.getHabitantes()-ciudad2.getHabitantes();
    	if (habitantes<0)
    		return -1;
    	if(habitantes>0)
    		return 1;
    	else
    	return 0;
    	
    }

}