package test.bankapp;

import main.bankapp.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount, otherAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("1001-5555-2020","Peter Walker", 10000.0);
        otherAccount = new BankAccount("1001-5555-2030","James Edward", 5000.0);
    }

    @AfterEach
    void tearDown() {
        bankAccount = null;
        otherAccount = null;
    }

    @Test
    void testDefaultConstructor(){
        assertDoesNotThrow(() -> new BankAccount());
    }

    @ParameterizedTest
    @CsvSource({
            "1001-5555-2010,John Smith,2000,"
            , ",John Smith,2000,The account number must not be null"
            , "1001-5555-2010,,2000,The owner name must not be null"
            , "1001-5555-2010,John Smith,0,"
            , "1001-5555-2010,John Smith,-1000,Balance must be greater than or equal to 0"
    })
    void testParameterizedConstructor(String accountNumber, String ownerName, double balance, String expected){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(accountNumber, ownerName, balance);
            throw new IllegalArgumentException();   // mặc định là null
        });
        assertEquals(expected, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "2000,12000"
            , "0,Amount must be greater than 0"
            , "-1000,Amount must be greater than 0"
    })
    void testDeposit(double amount, String expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(amount);
            throw new IllegalArgumentException();
        });
        if (exception.getMessage() == null){
            assertEquals(Double.valueOf(expected), bankAccount.getBalance());
        } else {
            assertEquals(expected, exception.getMessage());
        }

    }

    @ParameterizedTest
    @CsvSource({
            "3000,7000"
            , "0,Amount must be greater than 0 and less than or equal to balance"
            , "-1000,Amount must be greater than 0 and less than or equal to balance"
            , "10001,Amount must be greater than 0 and less than or equal to balance"
    })
    void testWithdraw(double amount, String expected) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(amount);
            throw new IllegalArgumentException();
        });
        if (exception.getMessage() == null){
            assertEquals(Double.valueOf(expected), bankAccount.getBalance());
        } else {
            assertEquals(expected, exception.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "3000,7000,8000"
            , "0,Amount must be greater than 0 and less than or equal to balance,"
            , "-1000,Amount must be greater than 0 and less than or equal to balance,"
            , "10001,Amount must be greater than 0 and less than or equal to balance,"
    })
    void testTransfer(double amount, String expected1, String expected2) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.transfer(otherAccount, amount);
            throw new IllegalArgumentException();
        });
        if (exception.getMessage() == null){
            assertAll(
                    () -> assertEquals(Double.valueOf(expected1), bankAccount.getBalance()),
                    () -> assertEquals(Double.valueOf(expected2), otherAccount.getBalance())
            );
        } else {
            assertEquals(expected1, exception.getMessage());
        }
    }

    @Test
    void testGetBalance() {
        double expected = 10000.0;
        assertEquals(0, Double.compare(expected, bankAccount.getBalance()));
        // cách khác: assertEquals(expected, bankAccount.getBalance(), Math.abs(expected - bankAccount.getBalance()));
    }

    @Test
    void testGetAccountNumber() {
        String expected = "1001-5555-2020";
        assertEquals(expected, bankAccount.getAccountNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "1001-5555-2050,1001-5555-2050"
            , ",The account number must not be null"
    })
    void testSetAccountNumber(String accountNumber, String message) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.setAccountNumber(accountNumber);
            throw new IllegalArgumentException();
        });
        if (exception.getMessage() == null){
            assertEquals(message, bankAccount.getAccountNumber());
        } else {
            assertEquals(message, exception.getMessage());
        }
    }

    @Test
    void testGetOwnerName() {
        String expected = "Peter Walker";
        assertEquals(expected, bankAccount.getOwnerName());
    }

    @ParameterizedTest
    @CsvSource({
            "Joseph Valentine,Joseph Valentine"
            , ",The owner name must not be null"
    })
    void testSetOwnerName(String ownerName, String message) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.setOwnerName(ownerName);
            throw new IllegalArgumentException();
        });
        if (exception.getMessage() == null){
            assertEquals(message, bankAccount.getOwnerName());
        } else {
            assertEquals(message, exception.getMessage());
        }
    }

    @Test
    void testToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
        String expected = String.format("%-20s | %-25s | %15s", "1001-5555-2020", "Peter Walker", decimalFormat.format(10000.0));
        assertEquals(expected, bankAccount.toString());
    }
}