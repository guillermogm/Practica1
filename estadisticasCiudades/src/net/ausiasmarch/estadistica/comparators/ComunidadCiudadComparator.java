package net.ausiasmarch.estadistica.comparators;

import java.util.Comparator;

import net.ausiasmarch.estadistica.modelo.Ciudad;

public class ComunidadCiudadComparator implements Comparator<Ciudad> {

    @Override
    public int compare(Ciudad c1, Ciudad c2) {
    	if (c1.getComunidad().equalsIgnoreCase(c2.getComunidad()))
    	return c1.getCiudad().compareTo(c2.getCiudad());
    	else 
    	return c1.getComunidad().compareTo(c2.getComunidad());

    }
}