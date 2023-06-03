package com.proyectoDualWebService.comparators;

import com.proyectoDualWebService.dto.Tablon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TablonComparatorTest {

    @Test
    public void testCompare() {
        TablonComparator comparator = new TablonComparator();

        Tablon tablon1 = new Tablon();
        tablon1.setCreateAt(Timestamp.valueOf(LocalDateTime.of(2023, 5, 31, 10, 0, 0)));

        Tablon tablon2 = new Tablon();
        tablon2.setCreateAt(Timestamp.valueOf(LocalDateTime.of(2023, 5, 31, 11, 0, 0)));

        int result = comparator.compare(tablon1, tablon2);
        Assertions.assertTrue(result < 0, "valor negativo");

        result = comparator.compare(tablon2, tablon1);
        Assertions.assertTrue(result > 0, "valor positivo");

        result = comparator.compare(tablon1, tablon1);
        Assertions.assertEquals(0, result, "cero");
    }
}
