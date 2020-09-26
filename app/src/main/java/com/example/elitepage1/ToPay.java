package com.example.elitepage1;
//moodle_class
public class ToPay {

    private int id;
    private String amount, reference, date, time;
    private long started, finished;



    public ToPay(String amount, String reference, String date, String time, long started, long finished) {
        this.amount = amount;
        this.reference = reference;
        this.date = date;
        this.time = time;
        this.started = started;
        this.finished = finished;
    }

    public ToPay(int id, String amount, String reference, String date, String time, long started, long finished) {
        this.id = id;
        this.amount = amount;
        this.reference = reference;
        this.date = date;
        this.time = time;
        this.started = started;
        this.finished = finished;
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

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }

    public ToPay() {
    }


}


