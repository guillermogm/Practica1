package net.ausiasmarch.estadistica.comparators;

import java.util.Comparator;

import net.ausiasmarch.estadistica.modelo.Ciudad;

public class CiudadComparator implements Comparator<Ciudad> {
    @Override
    public int compare(Ciudad c1, Ciudad c2) {
    	int c=c1.getCiudad().compareTo(c2.getCiudad());
    	return c;
    }
}
