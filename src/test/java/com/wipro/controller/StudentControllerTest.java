package com.wipro.controller;

import com.wipro.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    void testGetStudent_ReturnsModelAndViewWithStudentData() {
        StudentController controller = new StudentController();
        int id = 101;
        String name = "John Doe";

        ModelAndView mav = controller.getStudent(id, name);

        assertNotNull(mav);
        assertEquals("display", mav.getViewName());

        Object studentObj = mav.getModel().get("xyz");
        assertNotNull(studentObj);
        assertTrue(studentObj instanceof Student);

        Student student = (Student) studentObj;
        assertEquals(id, student.getStid());
        assertEquals(name, student.getStname());
    }

    @Test
    void testGetStudent_WithEmptyName() {
        StudentController controller = new StudentController();
        ModelAndView mav = controller.getStudent(123, "");

        Student student = (Student) mav.getModel().get("xyz");
        assertEquals("", student.getStname());
    }

    @Test
    void testGetStudent_WithNegativeId() {
        StudentController controller = new StudentController();
        ModelAndView mav = controller.getStudent(-1, "Neg ID");

        Student student = (Student) mav.getModel().get("xyz");
        assertEquals(-1, student.getStid());
        assertEquals("Neg ID", student.getStname());
    }
    @Test
void testGetStudent_WithNullName() {
    StudentController controller = new StudentController();
    ModelAndView mav = controller.getStudent(123, null);

    Student student = (Student) mav.getModel().get("xyz");
    assertNull(student.getStname());
}

@Test
void testGetStudent_WithNullId() {
    StudentController controller = new StudentController();
    ModelAndView mav = controller.getStudent(null, "Test Name");

    Student student = (Student) mav.getModel().get("xyz");
    assertNull(student.getStid());
}
@Test
    void testGetStudent_ModelAttribute() {
        StudentController controller = new StudentController();
        ModelAndView mav = controller.getStudent(123, "Alice");

        assertTrue(mav.getModel().containsKey("xyz"));
        assertNotNull(mav.getModel().get("xyz"));
    }
    
}
