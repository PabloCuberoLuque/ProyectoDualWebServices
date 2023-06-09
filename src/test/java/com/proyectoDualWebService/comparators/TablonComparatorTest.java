package com.proyectoDualWebService.comparators;

import com.proyectoDualWebService.dto.Tablon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TablonComparatorTest {

    @Test
    public void testCompare() {
        LocalDateTime now = LocalDateTime.now();
        Tablon tablon1 = Mockito.mock(Tablon.class);
        Tablon tablon2 = Mockito.mock(Tablon.class);

        Mockito.when(tablon1.getCreateAt()).thenReturn(Timestamp.valueOf(now.minusDays(1)));
        Mockito.when(tablon2.getCreateAt()).thenReturn(Timestamp.valueOf(now.minusDays(0)));

        TablonComparator comparator = new TablonComparator();

        int result = comparator.compare(tablon1, tablon2);
        Assertions.assertTrue(result > 0); // tablon1 más antiguo que tablon2
    }

}
