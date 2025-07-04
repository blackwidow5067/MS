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

        // Validate that ModelAndView is not null and the view is "display"
        assertNotNull(mav);
        assertEquals("display", mav.getViewName());

        // Validate the student object is present in the model with key "xyz"
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

        // Validate that an empty name is correctly set on the student object
        Student student = (Student) mav.getModel().get("xyz");
        assertEquals("", student.getStname());
    }

    @Test
    void testGetStudent_WithNegativeId() {
        StudentController controller = new StudentController();
        ModelAndView mav = controller.getStudent(-1, "Neg ID");

        // Validate that the negative ID and name are correctly set on the student object
        Student student = (Student) mav.getModel().get("xyz");
        assertEquals(-1, student.getStid());
        assertEquals("Neg ID", student.getStname());
    }


    @Test
    void testGetStudent_WithNullName() {
        // In the current version of the controller, stid cannot be null, so this test case would work for empty name
        StudentController controller = new StudentController();
        ModelAndView mav = controller.getStudent(123, null);

        // Validate that the name is null
        Student student = (Student) mav.getModel().get("xyz");
        assertNull(student.getStname());
    }

    @Test
    void testGetStudent_ModelAttribute() {
        StudentController controller = new StudentController();
        ModelAndView mav = controller.getStudent(123, "Alice");

        // Validate the student object is correctly added to the model under "xyz"
        assertTrue(mav.getModel().containsKey("xyz"));
        assertNotNull(mav.getModel().get("xyz"));
    }

}
