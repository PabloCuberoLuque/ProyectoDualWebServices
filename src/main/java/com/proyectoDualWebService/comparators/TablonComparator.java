package com.proyectoDualWebService.comparators;

import com.proyectoDualWebService.dto.Tablon;

import java.util.Comparator;

public class TablonComparator implements Comparator<Tablon> {
    @Override
    public int compare(Tablon t1, Tablon t2){
        return t2.getCreatedAt().compareTo(t1.getCreatedAt());
    }
}
