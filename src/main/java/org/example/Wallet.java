package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Wallet {

    String ownerName;
    double uangCash;
    ArrayList<String> ListKartu;

    public Wallet(String ownerName, double uangCash, ArrayList<String> listKartu) {
        this.ownerName = ownerName;
        this.uangCash = uangCash;
        this.ListKartu = listKartu;
    }

    public void withdraw (double amount) throws InsufficientFundsException {
        if (this.uangCash < amount ){
//            throw  new Error("someting");
            throw new InsufficientFundsException(amount, uangCash);
        }
        uangCash -= amount;
    }

    public void deposit (double amount){
        this.uangCash = this.uangCash + amount;
    }

    public void  addCard(String idCard){
        this.ListKartu.add(idCard);
    }

    public void  removeCard(String idCard){
        this.ListKartu.remove(idCard);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getUangCash() {
        return uangCash;
    }

    public void setUangCash(double uangCash) {
        this.uangCash = uangCash;
    }

    public ArrayList<String> getListKartu() {
        return ListKartu;
    }

    public void setListKartu(ArrayList<String> listKartu) {
        ListKartu = listKartu;
    }
}