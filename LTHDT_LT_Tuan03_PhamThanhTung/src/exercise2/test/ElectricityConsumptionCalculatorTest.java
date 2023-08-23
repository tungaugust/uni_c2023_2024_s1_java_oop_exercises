package exercise2.test;

import exercise2.main.ElectricityConsumptionCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityConsumptionCalculatorTest {
    @ParameterizedTest
    @DisplayName("Test 1.1")
    @CsvFileSource(resources = "/exercise2/test/testcase.csv", delimiter = ',', numLinesToSkip = 1)
    void test1(int oldQuantity, int newQuantity, long amount) {
        assertEquals((double) amount, ElectricityConsumptionCalculator.totalAmount(oldQuantity, newQuantity));
    }

    @ParameterizedTest
    @DisplayName("Test 1.2")
    @CsvFileSource(resources = "/exercise2/test/testcase.csv", delimiter = ',', numLinesToSkip = 1)
    void test2(int oldQuantity, int newQuantity, int amount) {
        assertEquals(amount, ElectricityConsumptionCalculator.getTienDien(oldQuantity, newQuantity));
    }
}