package org.example;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static java.awt.AWTEventMulticaster.add;
import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    private Wallet wallet;
    private ArrayList<String> listKartu;

    @BeforeAll
    static void setUpClass(){
        System.out.println("Setup class");
    }
    @BeforeEach
    void setUp(){
        listKartu = new ArrayList<>();
        listKartu.add("Kartu ATM 12345678");
        wallet = new Wallet("Charles Lescrec", 100000,listKartu);
    }
    @Test
    public void TestConstructor() {
        String ownerName = "Charles Lecrec";
        double uangCash = 100000;
        ArrayList<String> listKartu = new ArrayList<>();
        listKartu.add("Kartu ATM 12345678");

        Wallet wallet = new Wallet(ownerName, uangCash, listKartu);

        assertEquals(ownerName, wallet.getOwnerName());
        assertEquals(uangCash, wallet.getUangCash());
        assertEquals(listKartu, wallet.getListKartu());
    }
    @Test
    void TestWithdraw() throws InsufficientFundsException {
        double amount = 50000;
        Wallet wallet = new Wallet("Charles Lecrec", 100000, new ArrayList<>());
        wallet.withdraw(amount);

        assertEquals(100000 - amount, wallet.getUangCash());
    }

    @Test
    void TestDeposit() {
        double amount = 50000;
        Wallet wallet = new Wallet("Charles Lecrec", 100000, new ArrayList<>());
        wallet.deposit(amount);

        assertEquals(100000 + amount, wallet.getUangCash());
    }

    @Test
    void TestAddCard() {
        String idCard = "Kartu Kredit 98765432";
        Wallet wallet = new Wallet("Charles Lecrec", 100000, new ArrayList<>());
        wallet.addCard(idCard);
        assertTrue(wallet.getListKartu().contains(idCard));
    }

    @Test
    void TestRemoveCard() {
        String idCard = "Kartu ATM 12345678";
        Wallet wallet = new Wallet("Charles Lecrec", 100000, new ArrayList<>());
        wallet.getListKartu().add(idCard);

        wallet.removeCard(idCard);

        assertFalse(wallet.getListKartu().contains(idCard));
    }

    @Test
    public void testWithdrawNegativeBalance() {
        double amount = 150000;

        Wallet wallet = new Wallet("Charles Lecrec", 100000, new ArrayList<>());
        try {
            wallet.withdraw(amount);
            fail("Saldo tidak boleh negatif setelah penarikan");
        } catch (InsufficientFundsException e) {
            // Expected exception
        }
        // Verifikasi saldo tetap sama
        assertEquals(100000, wallet.getUangCash());
    }
    @AfterEach
    void teardown(){
        wallet = null;
        listKartu.clear();
    }
    @AfterAll
    static void tearDownClass(){
        System.out.println("Tear down class");
    }

}