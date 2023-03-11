import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankDatabaseTest {
    @BeforeAll
    public static void initializeTest(){System.out.println("Testing started.");}

    @AfterAll
    public static void finalizeTest(){System.out.println("Testing ended.");}

    @Test
    public void getAccount_1() {
        BankDatabase testDatabase = new BankDatabase();
        assertTrue(testDatabase.getAccount(12345) != null);
    }

    @Test
    public void getAccount_2() {
        BankDatabase testDatabase = new BankDatabase();
        assertNotNull(testDatabase.getAccount(98765));
    }

    @Test
    public void getAccount_3() {
        BankDatabase testDatabase = new BankDatabase();
        assertTrue(testDatabase.getAccount(19234) instanceof Account);
    }

    @Test
    public void getAccount_4() {
        BankDatabase testDatabase = new BankDatabase();
        assertNotNull(testDatabase.getAccount(99999));
    }

//    @Test
//    @ParameterizedTest
//    @ValueSource(ints = {-145, 0, 58642})
//    public void getAccount_False(int accountNumber) {
//        BankDatabase testDatabase = new BankDatabase();
//        assertNull(testDatabase.getAccount(accountNumber));
//    }


    @Test
    public void authenticateUser_1() {
        BankDatabase testDatabase = new BankDatabase();
        assertTrue(testDatabase.authenticateUser(11111));
    }

    @Test
    public void authenticateUser_2() {
        BankDatabase testDatabase = new BankDatabase();
        assertTrue(testDatabase.authenticateUser(22222));
    }

    @Test
    public void authenticateUser_3() {
        BankDatabase testDatabase = new BankDatabase();
        assertTrue(testDatabase.authenticateUser(33333));
    }

    @Test
    public void authenticateUser_4() {
        BankDatabase testDatabase = new BankDatabase();
        assertTrue(testDatabase.authenticateUser(00000));
    }

//    @Test
//    @ParameterizedTest
//    @ValueSource(ints = {12345, 5550, 123, 67754})
//    public void authenticateUser_False(int pin) {
//        BankDatabase testDatabase = new BankDatabase();
//        assertFalse(testDatabase.authenticateUser(pin));
//    }

    @Test
    public void getIsAdmin_Admin() {
        BankDatabase testBankDatabase = new BankDatabase();
        assertEquals(1, testBankDatabase.getIsAdmin(99999));
    }

    @Test
    public void getIsAdmin_User_1() {
        BankDatabase testBankDatabase = new BankDatabase();
        assertFalse(1 == testBankDatabase.getIsAdmin(19234));
    }

    @Test
    public void getIsAdmin_User_2() {
        BankDatabase testBankDatabase = new BankDatabase();
        assertFalse(1 == testBankDatabase.getIsAdmin(98765));
    }

//    @Test
//    @ParameterizedTest
//    @ValueSource(ints = {987, 34665, 9945})
//    public void getIsAdmin_Randoms(int accountNumber) {
//        BankDatabase testBankDatabase = new BankDatabase();
//        assertFalse(1 == testBankDatabase.getIsAdmin(accountNumber));
//    }

//    @Test
//    public void getIsAdmin_Admin_Missing() {
//        BankDatabase testBankDatabase = new BankDatabase();
//        assertFalse(1 == testBankDatabase.getIsAdmin(9999));
//    }

    @Test
    public void getAccountNumberWithPin_1() {
        BankDatabase testBankDatabase = new BankDatabase();
        Account testAccount = testBankDatabase.accounts.get(0);
        assertEquals(testAccount.getAccountNumber(), testBankDatabase.getAccountNumberWithPin(testAccount.getPin()));
    }

//    @Test
//    public void getAccountNumberWithPin_2() {
//        BankDatabase testBankDatabase = new BankDatabase();
//        Account testAccount = testBankDatabase.accounts.get(1);
//        assertEquals(testAccount.getAccountNumber(), testBankDatabase.getAccountNumberWithPin(testAccount.getPin()));
//    }
//
//    @Test
//    public void getAccountNumberWithPin_3() {
//        BankDatabase testBankDatabase = new BankDatabase();
//        Account testAccount = testBankDatabase.accounts.get(testBankDatabase.accounts.size()-2);
//        assertEquals(testAccount.getAccountNumber(), testBankDatabase.getAccountNumberWithPin(testAccount.getPin()));
//    }
//
//    @Test
//    public void getAccountNumberWithPin_4() {
//        BankDatabase testBankDatabase = new BankDatabase();
//        Account testAccount = testBankDatabase.accounts.get(testBankDatabase.accounts.size()-1);
//        assertEquals(testAccount.getAccountNumber(), testBankDatabase.getAccountNumberWithPin(testAccount.getPin()));
//    }

//    @Test
//    public void addUser_1() {
//        BankDatabase testBankDatabase = new BankDatabase();
//        int accountNumber = testBankDatabase.accounts.size();
//        testBankDatabase.addUser();
//        assertEquals(accountNumber + 1, testBankDatabase.accounts.size());
//    }

    @Test
    public void deleteUser_1() {
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = testBankDatabase.accounts.size();
        testBankDatabase.deleteUser(accountNumber-2);
        assertEquals(testBankDatabase.accounts.size(), accountNumber-1);
    }

    @Test
    public void deleteUser_2() { // delete from the start
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = testBankDatabase.accounts.size();
        testBankDatabase.deleteUser(0);
        assertEquals(testBankDatabase.accounts.size(), accountNumber-1);
    }

    @Test
    public void deleteUser_3() { // delete from the end
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = testBankDatabase.accounts.size();
        testBankDatabase.deleteUser(accountNumber-1);
        assertEquals(testBankDatabase.accounts.size(), accountNumber-1);
    }

    @Test
    public void deleteUser_4() { // delete from the middle
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = testBankDatabase.accounts.size();
        testBankDatabase.deleteUser(accountNumber/2);
        assertEquals(testBankDatabase.accounts.size(), accountNumber-1);
    }

    @Test
    public void deleteUser_5() { // delete from out of bound position
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = testBankDatabase.accounts.size();
        assertThrows(IllegalArgumentException.class, () -> {
            testBankDatabase.deleteUser(accountNumber + 1);
        });
    }

    @Test
    public void getAccountType_WBTest_1(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 98765;
        assertTrue(0 == testBankDatabase.getAccountType(accountNumber));
    }

    @Test
    public void getAccountType_WBTest_2(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 99999;
        assertTrue(1 == testBankDatabase.getAccountType(accountNumber));
    }

    @Test
    public void getAccountType_WBTest_3(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 13568;
        assertTrue(-1 == testBankDatabase.getAccountType(accountNumber));
    }

    @Test
    public void getAccountType_mutant_1(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 98765;
        assertTrue(0 == testBankDatabase.getAccountType_mutant1(accountNumber));
    }

    @Test
    public void getAccountType_mutant_2(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 99999;
        assertTrue(1 == testBankDatabase.getAccountType_mutant2(accountNumber));
    }

    @Test
    public void getAccountType_mutant_3(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 13568;
        assertTrue(-1 == testBankDatabase.getAccountType_mutant3(accountNumber));
    }

    @Test
    public void getAccountType_mutant_4(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 13568;
        assertTrue(-1 == testBankDatabase.getAccountType_mutant4(accountNumber));
    }

    @Test
    public void test_DT_1(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 12345;
        assertTrue(0 == testBankDatabase.getAccountType(accountNumber));
    }

    @Test
    public void test_DT_2(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 99999;
        assertTrue(1 == testBankDatabase.getAccountType(accountNumber));
    }

    @Test
    public void test_DT_3(){
        BankDatabase testBankDatabase = new BankDatabase();
        int accountNumber = 76268;
        assertTrue(-1 == testBankDatabase.getAccountType(accountNumber));
    }

}