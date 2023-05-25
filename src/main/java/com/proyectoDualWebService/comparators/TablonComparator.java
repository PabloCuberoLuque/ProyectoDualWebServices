package com.proyectoDualWebService.comparators;

import com.proyectoDualWebService.dto.Tablon;

import java.util.Comparator;

public class TablonComparator implements Comparator<Tablon> {

    @Override
    public int compare(Tablon o1, Tablon o2) {
        return o2.getCreatedAt().compareTo(o1.getCreatedAt());
    }
}