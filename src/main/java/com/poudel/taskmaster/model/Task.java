package com.poudel.taskmaster.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DynamoDBTable(tableName = "task")
public class Task {
    private String id;
    private String title;
    private String description;
    private String status;
    private String assignee;

    private ArrayList<History> historyList = new ArrayList<>();

    public Task(){}

    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.status = "available";

        this.historyList.add(historyCreation(this.status));

        this.assignee = null;
    }

    public Task(String title, String description, String assignee){
        this.title = title;
        this.description = description;

        this.status = "assigned";
        this.historyList.add(historyCreation(this.status));

        this.assignee = assignee;
    }


    public History historyCreation(String update) {

        Date date = new Date();
        History history = new History(date.toString(), update );

        return history;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }


    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status= status;
    }

    @DynamoDBAttribute
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @DynamoDBAttribute
    public ArrayList<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<History> historyList) {
        this.historyList = historyList;
    }

}
