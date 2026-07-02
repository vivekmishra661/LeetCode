package com.test.newz.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Atm {


    static void main() {
        Atm atm = new Atm();
        //atm.deposit(new int[]{});
        atm.deposit(new int[]{0,0,1,2,1});
        atm.withdraw(600);
        atm.deposit(new int[]{0,1,0,1,1});
        atm.withdraw(600);

    }


    int[] bankNotes;

    int[] noteTypes = new int[]{20, 50, 100, 200, 500};

    public Atm() {
        bankNotes = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            bankNotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {


        boolean isWithdrawable = false;
        List<AtomicInteger> notes = new ArrayList<>(5);
        for (int i = 0; i < 5; i++)
            notes.add(new AtomicInteger(0));
        for (int i = 4; i >= 0; i--) {
            if (bankNotes[i] == 0) continue;
            isWithdrawable = withdrawNote(amount, noteTypes[i], bankNotes[i], notes.get(i));
            if (isWithdrawable) {
                amount = amount - notes.get(i).get() * noteTypes[i];
            } else {
                break;
            }

        }
        if (isWithdrawable && amount == 0) {
            for (int i = 0; i < 5; i++) {
                this.bankNotes[i] -= notes.get(i).get();
            }
            return notes.stream().mapToInt(AtomicInteger::get).toArray();
        } else {
            return new int[]{-1};
        }
    }

    private boolean withdrawNote(int amount, int noteType, int currentNotes, AtomicInteger notesSelected) {
        if (amount >= noteType) {
            int notesRequired = amount / noteType;
            if(currentNotes>= notesRequired) {
                notesSelected.set(notesRequired);
            }else{
                notesSelected.set(currentNotes);
            }
        }
        return true;
    }


}
