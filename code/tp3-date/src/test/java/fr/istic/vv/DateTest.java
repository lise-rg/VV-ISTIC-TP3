package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    public void testValidDates1() {
        // Test normal date
        assertTrue(Date.isValidDate(15, 1, 2023));
    }

    @Test
    public void testValidDates2() {
        // Test date at the beginning of the month
        assertTrue(Date.isValidDate(1, 1, 2023));
    }

    @Test
    public void testValidDates3() {
        // Test date at the end of the month
        assertTrue(Date.isValidDate(31, 1, 2023));
    }

    @Test
    public void testValidDates4() {
        // Test date at the beginning of the year
        assertTrue(Date.isValidDate(1, 1, 2023));
    }

    @Test
    public void testValidDates5() {
        // Test date at the end of the year
        assertTrue(Date.isValidDate(31, 12, 2023));
    }

    @Test
    public void testValidDates6() {
        // Test date in a leap year
        assertTrue(Date.isValidDate(29, 2, 2024));
    }

    // Partition for invalid dates
    @Test
    public void testInvalidDates1() {
        assertFalse(Date.isValidDate(0, 1, 2023));
    }

    @Test
    public void testInvalidDates2() {
        assertFalse(Date.isValidDate(32, 1, 2023));
    }

    @Test
    public void testInvalidDates3() {
        assertFalse(Date.isValidDate(15, 0, 2023));
    }

    @Test
    public void testInvalidDates4() {
        assertFalse(Date.isValidDate(15, 13, 2023));
    }

    @Test
    public void testInvalidDates5() {
        assertFalse(Date.isValidDate(29, 2, 2023)); // Not a leap year
    }

    @Test
    public void testInvalidDates6() {
        assertFalse(Date.isValidDate(27, 2, 0)); // Not a leap year
    }

    @Test
    public void testInvalidDates7() {
        assertTrue(Date.isValidDate(27, 5, 2)); // Not a leap year
    }

    @Test
    public void testInvalidDates8() {
        assertTrue(Date.isValidDate(27, 11, 2023)); // Not a leap year
    }

    @Test
    public void testInvalidDates9() {
        assertTrue(Date.isValidDate(2, 10, 2023)); // Not a leap year
    }

    // Partition for leap years
    @Test
    public void testLeapYear1() {
        assertTrue(Date.isLeapYear(2024));
    }

    @Test
    public void testLeapYear2() {
        assertFalse(Date.isLeapYear(2023));
    }
    @Test
    public void testLeapYear3() {
        assertTrue(Date.isLeapYear(400));
    }
    // Partition for nextDate and previousDate operations
    @Test
    public void testNextDate1() {
        assertEquals(new Date(16, 1, 2023), new Date(15, 1, 2023).nextDate());
    }

    @Test
    public void testNextDate2() {
        assertEquals(new Date(1, 2, 2023), new Date(31, 1, 2023).nextDate());
    }

    @Test
    public void testNextDate3() {
        assertEquals(new Date(1, 1, 2024), new Date(31, 12, 2023).nextDate());
    }
    @Test
    public void testNextDate4() {
        assertEquals(new Date(2, 2, 2000), new Date(1, 2, 2000).nextDate());
    }

    @Test
    public void testNextDate5() {
        assertEquals(new Date(1, 12, 2000), new Date(30, 11, 2000).nextDate());
    }

    @Test
    public void testNextDate6() {
        assertEquals(new Date(30, 11, 2000), new Date(29, 11, 2000).nextDate());
    }

    @Test
    public void testPreviousDate1() {
        assertEquals(new Date(14, 1, 2023), new Date(15, 1, 2023).previousDate());
    }

    @Test
    public void testPreviousDate2() {
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
    }

    @Test
    public void testPreviousDate3() {
        assertEquals(new Date(1, 11, 2023), new Date(2, 11, 2023).previousDate());
    }

    @Test
    public void testPreviousDate4() {
        assertEquals(new Date(31, 1, 2023), new Date(1, 2, 2023).previousDate());
    }

    @Test
    public void testCompareTo1() {
        Date date1 = new Date(15, 1, 2023);
        Date date2 = new Date(15, 1, 2023);

        assertEquals(0, date1.compareTo(date2));
    }

    @Test
    public void testCompareTo2() {
        Date date1 = new Date(15, 1, 2023);
        Date date3 = new Date(15, 2, 2023);

        assertTrue(date1.compareTo(date3) < 0);
    }

    @Test
    public void testCompareTo3() {
        Date date1 = new Date(15, 1, 2023);
        Date date3 = new Date(15, 2, 2023);

        assertTrue(date3.compareTo(date1) > 0);
    }

    @Test
    public void testCompareTo4() {
        Date date1 = new Date(15, 2, 2022);
        Date date2 = new Date(15, 2, 2023);

        assertTrue(date2.compareTo(date1) > 0);
    }

    @Test
    public void testCompareTo5() {
        Date date1 = new Date(16, 2, 2023);
        Date date2 = new Date(15, 2, 2023);

        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    public void createDate(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(0, 1, 1);
        });
    }

    @Test
    public void testEquals1() {
        Date date1 = new Date(15, 2, 2023);
        Date date2 = new Date(15, 2, 2023);

        assertTrue(date1.equals(date2));
    }

    @Test
    public void testEquals2() {
        Date date1 = new Date(15, 2, 2023);
        Date date2 = new Date(16, 2, 2023);

        assertFalse(date1.equals(date2));
    }

    @Test
    public void testEquals3() {
        Date date1 = new Date(15, 2, 2023);

        assertFalse(date1.equals(null));
    }

    @Test
    public void testEquals4() {
        Date date1 = new Date(15, 2, 2023);

        assertFalse(date1.equals("wrong object"));
    }
}
