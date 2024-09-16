package com.example.playground;

import com.example.playground.exception.InvalidInputException;
import com.example.playground.service.DiamondService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DiamondServiceTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void validateInput_ShouldPassForValidInput() {
        DiamondService service = new DiamondService("A");
        assertDoesNotThrow(() -> service.validateInput("A"));
    }

    @Test
    void validateInput_ShouldThrowExceptionForNullInput() {
        DiamondService service = new DiamondService(null);
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> service.validateInput(null));
        assertEquals("Input must be a single character.", exception.getMessage());
    }

    @Test
    void validateInput_ShouldThrowExceptionForMultipleCharacterInput() {
        DiamondService service = new DiamondService("ABC");
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> service.validateInput("ABC"));
        assertEquals("Input must be a single character.", exception.getMessage());
    }

    @Test
    void printDiamond_ShouldThrowExceptionForInvalidInput() {
        DiamondService service = new DiamondService("3");
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                service::printDiamond);
        assertEquals("Input must be an uppercase alphabetic character.", exception.getMessage());
    }

    @Test
    void validateInput_ShouldThrowExceptionForLowerCaseCharacter() {
        DiamondService service = new DiamondService("a");
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> service.validateInput("a"));
        assertEquals("Input must be an uppercase alphabetic character.", exception.getMessage());
    }

    @Test
    void printDiamond_ShouldPrintDiamondForValidInputA() {
        DiamondService service = new DiamondService("A");
        assertDoesNotThrow(service::printDiamond);
        assertEquals(1, outContent.toString().split("\n").length); // no of rows printed
        assertEquals(" A", outContent.toString().split("\n")[0]);
    }

    @Test
    void printDiamond_ShouldPrintDiamondForValidInputC() {
        DiamondService service = new DiamondService("C");
        assertDoesNotThrow(service::printDiamond);
        assertEquals(5, outContent.toString().split("\n").length);
        assertEquals("  B B", outContent.toString().split("\n")[1]);
        assertEquals(" C   C", outContent.toString().split("\n")[2]);
    }

    @Test
    void printDiamond_ShouldPrintDiamondForValidInputZ() {
        DiamondService service = new DiamondService("Z");
        assertDoesNotThrow(service::printDiamond);
        assertEquals(51, outContent.toString().split("\n").length);
        assertEquals("B B", outContent.toString().split("\n")[1].trim());
        assertEquals("C   C", outContent.toString().split("\n")[48].trim());
        assertEquals("J                 J", outContent.toString().split("\n")[41].trim());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
