package test.bankapp;

import main.bankapp.Bank;
import main.bankapp.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank("Hallow Bank", 5);
        bank.addNew("1001-5555-2010", "Peter Walker", 10000.0);
        bank.addNew("1001-5555-2020","James Edward", 5000.0);
        bank.addNew("1001-5555-2030", "John Smith",8000);

    }

    @AfterEach
    void tearDown() {
        bank = null;
    }

    @Test
    void testDefaultConstructor(){
        assertDoesNotThrow(() -> new Bank());
    }

    @ParameterizedTest
    @CsvSource({
            "ACB,10,"
            , "ACB,0,Number of accounts must be greater than 0"
            , "ACB,-5,Number of accounts must be greater than 0"
            , ",10,The bank name must not be null"
    })
    void testParameterizedConstructor(String name, int numberOfAccount, String expected){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Bank(name, numberOfAccount);
            throw new IllegalArgumentException();
        });
        assertEquals(expected, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "0,1001-5555-2050,Cassandra Sirius,7000,"
            , "1,1001-5555-2050,Cassandra Sirius,7000,Bank is full"
            , "0,1001-5555-2010,Cassandra Sirius,7000,Account number already exists"
    })
    void testAddNew(int flag, String accountNumber, String ownerName, double balance, String message) {
        // Làm đầy danh sách tài khoản của ngân hàng
        if (flag == 1) {
            bank.addNew("1001-5555-2031", "John Smith",8000);
            bank.addNew("1001-5555-2032", "John Smith",8000);
        }
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.addNew(accountNumber, ownerName, balance);
            throw new IllegalArgumentException();
        });
        assertEquals(message, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1001-5555-2020,James Edward"
            , "1001-5555-2021,null"
    })
    void testFind(String accountNumber, String expected) {
        BankAccount bankAccount = bank.find(accountNumber);
        String result = (bankAccount == null) ? "null" : bankAccount.getOwnerName();
        assertEquals(expected, result);
    }

    @Test
    void testGetTotalBalance() {
        double expected = 23000.0;
        assertEquals(0, Double.compare(expected, bank.getTotalBalance()));
    }

    @Test
    void testGetNumberOfAccounts() {
        int expected = 3;
        assertEquals(expected, bank.getNumberOfAccounts());
    }

    @Test
    void getAccounts() {
        BankAccount[] expected = new BankAccount[5];
        expected[0] = new BankAccount("1001-5555-2010", "Peter Walker", 10000.0);
        expected[1] = new BankAccount("1001-5555-2020","James Edward", 5000.0);
        expected[2] = new BankAccount("1001-5555-2030", "John Smith",8000);

        BankAccount[] accounts = bank.getAccounts();
        for (int i = 0; i < bank.getNumberOfAccounts(); i++) {
            assertEquals(expected[i].getAccountNumber(), accounts[i].getAccountNumber());
            assertEquals(expected[i].getOwnerName(), accounts[i].getOwnerName());
            assertEquals(expected[i].getBalance(), accounts[i].getBalance());
        }
    }

    @Test
    void testGetName() {
        String expected = "Hallow Bank";
        assertEquals(expected, bank.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "PI Bank,PI Bank"
            , ",The bank name must not be null"
    })
    void testSetName(String name, String message) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.setName(name);
            throw new IllegalArgumentException();
        });
        if (exception.getMessage() == null){
            assertEquals(message, bank.getName());
        } else {
            assertEquals(message, exception.getMessage());
        }
    }
}