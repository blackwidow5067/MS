package com.wipro.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentConstructorAndGetters() {
        Student s = new Student(1, "Test Name");

        assertEquals(1, s.getStid());
        assertEquals("Test Name", s.getStname());
    }

    @Test
    void testSetters() {
        Student s = new Student();
        s.setStid(10);
        s.setStname("Alice");

        assertEquals(10, s.getStid());
        assertEquals("Alice", s.getStname());
    }

    @Test
    void testToString() {
        Student s = new Student(100, "Bob");
        String result = s.toString();

        assertTrue(result.contains("stid=100"));
        assertTrue(result.contains("stname=Bob"));
    }
}
