package exercise1.test;

import exercise1.main.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Cộng hai số ra kết quả đúng")
    void test1() {
        assertEquals(3, Calculator.sum(1, 2));
    }

    @Test
    @DisplayName("Cộng hai số ra kết quả sai")
    void test2() {
        assertNotEquals(-2, Calculator.sum(1, -2));
    }

    @Test
    @DisplayName("Cộng bốn số ra kết quả đúng")
    void test3() {
        assertEquals(10, Calculator.sum(1, 2, 3, 4));
    }

    @Test
    @DisplayName("Cộng không số (không truyền đối số)")
    void test4() {
        assertEquals(0, Calculator.sum());
    }

    @Test
    @DisplayName("Chia hai số nguyên ra kết quả đúng")
    void test5() {
        assertEquals(0.5f, Calculator.div(1, 2));
    }

    @Test
    @DisplayName("Chia cho số 0, ném ra ngoại lệ ArithmeticException")
    void test6() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.div(1, 0);
        });
    }
}