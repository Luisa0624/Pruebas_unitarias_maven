package co.com.sofka.app.calculator;

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
            "50,  75, 125",
            "80,  20, 100"
    })
    public void severalSums(Long uno, Long dos, Long expectResult) {
        assertEquals(expectResult, basicCalculator.suma(uno, dos),
                () -> uno + " + " + dos + " should equal " + expectResult);
    }
}