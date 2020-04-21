package com.lambton.androidcapstoneapp;

public class ListItem {

    private String batchName;
    private String client;
    private String submitted_by;
    private String due_date;

    public ListItem(String batchName, String client, String submitted_by, String due_date) {
        this.batchName = batchName;
        this.client = client;
        this.submitted_by = submitted_by;
        this.due_date = due_date;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSubmitted_by() {
        return submitted_by;
    }

    public void setSubmitted_by(String submitted_by) {
        this.submitted_by = submitted_by;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}
