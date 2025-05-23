package test.postfix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import postfix.Postfix;
import stack.Underflow;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PostfixEvaluationTest {

    public static Stream<Arguments> testCases() {
        return TestCases.allTestCases()
                .map(a -> arguments(a[0], a[2], ((Number) a[3]).doubleValue())); // a[3] = Ergebnis
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testEvaluatePostfix(String comment, String postfixStr, double expected) throws Underflow {
        double actual = Postfix.evaluate(postfixStr);
        assertEquals(expected, actual, 0.001, comment + " (postfix was: " + postfixStr + ")");
    }
}
