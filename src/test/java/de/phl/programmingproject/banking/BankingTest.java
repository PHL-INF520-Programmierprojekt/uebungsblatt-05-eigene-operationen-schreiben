package de.phl.programmingproject.banking;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link BankAccount} exercise.
 */
public class BankingTest {

    BankAccount bankAccount = new BankAccount(133.7, 42);
    BankAccount otherBankAccount = new BankAccount(5, 0);

    private Method getTransferToMethod() {
        return TestUtils.getMethod(BankAccount.class, "transferTo", BankAccount.class, double.class);
    }

    private Method getAddInterestMethod() {
        return TestUtils.getMethod(BankAccount.class, "addInterest", double.class);
    }

    @Test
    public void task_1_transferTo_throws_IllegalArgumentException_if_amount_is_negative() {
        Method finalTransferToMethod = getTransferToMethod();
        Exception exception = assertThrows(Exception.class, () -> finalTransferToMethod.invoke(bankAccount,
                        otherBankAccount, -1),
                "The 'transferTo' method must throw an IllegalArgumentException if the amount is negative!");
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass(),
                "The 'transferTo' method must throw an IllegalArgumentException if the amount is negative!");
    }

    @Test
    public void task_1_transferTo_throws_IllegalArgumentException_if_otherBankAccount_is_null() {
        Method finalTransferToMethod = getTransferToMethod();
        Exception exception = assertThrows(Exception.class, () -> finalTransferToMethod.invoke(bankAccount,
                        null, 1),
                "The 'transferTo' method must throw an IllegalArgumentException if the other bank account is null!");
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass(),
                "The 'transferTo' method must throw an IllegalArgumentException if the other bank account is null!");
    }

    @Test
    public void task_1_transferTo_throws_IllegalArgumentException_if_amount_is_greater_than_balance() {
        Method finalTransferToMethod = getTransferToMethod();
        Exception exception = assertThrows(Exception.class, () -> finalTransferToMethod.invoke(bankAccount,
                        otherBankAccount, bankAccount.getBalance() + 1),
                "The 'transferTo' method must throw an IllegalArgumentException if the amount is greater than the balance!");
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass(),
                "The 'transferTo' method must throw an IllegalArgumentException if the amount is greater than the balance!");
    }

    @Test
    void task_1_transferTo_transfers_money() {
        double bABalance = bankAccount.getBalance();
        double oBABalance = otherBankAccount.getBalance();

        double amount = 1.337;
        try {
            getTransferToMethod().invoke(bankAccount, otherBankAccount, amount);
        } catch (Exception e) {
            fail("Something went wrong when testing the 'transferTo' method.\n" + e);
        }
        assertEquals(bABalance - amount, bankAccount.getBalance(),
                "The 'transferTo' method must transfer the given amount from the bank account (i.e., withdraw)!");
        assertEquals(oBABalance + amount, otherBankAccount.getBalance(),
                "The 'transferTo' method must transfer the given amount to the other bank account (i.e., deposit)!");
    }

    @Test
    void task_2_addInterest_throws_IllegalArgumentException_if_rate_is_negative() {
        Exception exception = assertThrows(Exception.class, () -> getAddInterestMethod().invoke(bankAccount, -1),
                "The 'addInterest' method must throw an IllegalArgumentException if the rate is negative!");
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass(),
                "The 'addInterest' method must throw an IllegalArgumentException if the rate is negative!");
    }

    @Test
    void task_2_addInterest_adds_interest() {
        double balance = bankAccount.getBalance();
        double rate = 0.05;
        try {
            getAddInterestMethod().invoke(bankAccount, rate);
        } catch (Exception e) {
            fail("Something went wrong when testing the 'addInterest' method.\n" + e);
        }
        assertEquals(balance + balance * rate, bankAccount.getBalance(),
                "The 'addInterest' method must add the given interest rate to the balance!");
    }

    @Test
    void task_3_getNetBalance_handles_positive_zero_and_negative_balance() throws ReflectiveOperationException {
        Method method = TestUtils.getMethod(BankAccount.class, "getNetBalance");
        BankAccount account = new BankAccount(50, 7);
        assertEquals(50.0, (double) method.invoke(account), 0.000001);
        account.withdraw(50);
        assertEquals(0.0, (double) method.invoke(account), 0.000001);
        account.withdraw(50);
        assertEquals(0.0, (double) method.invoke(account), 0.000001);
        assertEquals(-50.0, account.getBalance(), 0.000001, "getNetBalance darf den Kontostand nicht verändern.");
    }

    @Test
    void given_withdraw_allows_overdraft_but_rejects_negative_amounts() {
        BankAccount account = new BankAccount(0, 8);
        account.withdraw(0);
        assertEquals(0.0, account.getBalance());
        account.withdraw(20);
        assertEquals(-20.0, account.getBalance());
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1));
        assertEquals(-20.0, account.getBalance(), "Eine abgewiesene Abhebung verändert das Konto nicht.");
    }

    @Test
    void task_1_rejected_transfer_leaves_both_accounts_unchanged() {
        double sourceBalance = bankAccount.getBalance();
        double targetBalance = otherBankAccount.getBalance();
        assertThrows(InvocationTargetException.class,
                () -> getTransferToMethod().invoke(bankAccount, otherBankAccount, sourceBalance + 1));
        assertEquals(sourceBalance, bankAccount.getBalance());
        assertEquals(targetBalance, otherBankAccount.getBalance());
    }
}
