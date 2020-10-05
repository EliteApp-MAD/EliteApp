package com.example.elitepage1;
//moodle_class
public class ToPay {

    private int id;
    private String amount, reference, date, time;




    public ToPay(String amount, String reference, String date, String time) {
        this.amount = amount;
        this.reference = reference;
        this.date = date;
        this.time = time;

    }

    public ToPay(int id, String amount, String reference, String date, String time) {
        this.id = id;
        this.amount = amount;
        this.reference = reference;
        this.date = date;
        this.time = time;

    }


  //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public ToPay() {
    }


}


