package co.com.sofka.app.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = Long.valueOf(1L);
        Long number2 = Long.valueOf(1L);
        Long expectedValue = Long.valueOf(2L);

        // Act
        Long result = basicCalculator.suma( number1,number2 );
        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "9,   3,   12",
            "4,   8,   12",
            "50,  75,  125",
            "80,  20,  100"
    })
    public void severalSuma(Long uno, Long dos, Long expectResult) {
        assertEquals(expectResult, basicCalculator.suma(uno, dos),
                () -> uno + " + " + dos + " should equal " + expectResult);
    }

    //resta
    @DisplayName("Testing several substraction case")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "8,   4,   4",
            "28,  9,   19",
            "20,  18,  2",
            "50,  30,  20"
    })

    public void severalresta(Long uno, Long dos, Long expectResult) {
        assertEquals(expectResult, basicCalculator.resta(uno, dos),
                () -> uno + " - " + dos + " should equal " + expectResult);
    }

    //Multiplicacion
    @DisplayName("Testing several multiplication test")
    @ParameterizedTest(name = "{0} *  {1} = {2}")
    @CsvSource({
            "9,   3,   27",
            "8,   7,   56",
            "10,  5,   50",
            "4,   3,   12"
    })

    public void severalMulti(Long uno, Long dos, Long expectResult) {
        assertEquals(expectResult, basicCalculator.multiplicacion(uno, dos),
                () -> uno + " * " + dos + " should equal " + expectResult);
    }


    //division
    @DisplayName("Testing several division")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,   1,  0",
            "30,  5,  6",
            "40,  4,  10",
            "12,  2,  6"
    })

    //Division
    void severalDivision(Long uno, Long dos, Long expectResult) {
        Long result = basicCalculator.division(uno, dos);
        Assertions.assertEquals(expectResult, result);
    }

    @DisplayName("Testing several validation division case")
    @ParameterizedTest(name = "{0} /{1}")
    @CsvSource({"4,0"})
    void severalSadDivision(Long uno, Long second) {
        var response = assertThrows(RuntimeException.class, ()->{
            Long result = basicCalculator.division(uno,second);
        });
        Assertions.assertEquals("No se puede dividir por cero",response.getMessage());
    }
}