/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

/**
 *
 * @author Florian
 */
class Cheque {
    
    private IAccount payAccount;
    private IAccount takeAccount;
    private int cents;
    final private String bankName;

    public Cheque(IAccount payAccount, IAccount takeAccount, int cents) {
        this.payAccount = payAccount;
        this.takeAccount = takeAccount;
        this.cents = cents;
        this.bankName = "FF_Bank";
    }

    public IAccount getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(IAccount payAccount) {
        this.payAccount = payAccount;
    }

    public IAccount getTakeAccount() {
        return takeAccount;
    }

    public void setTakeAccount(IAccount takeAccount) {
        this.takeAccount = takeAccount;
    }

    public int getPayment() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    @Override
    public String toString() {
        return "Cheque{" + "payAccount=" + payAccount + ", takeAccount=" + takeAccount + ", cents=" + cents + ", bankName=" + bankName + '}';
    }    
}
