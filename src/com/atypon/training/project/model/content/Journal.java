package com.atypon.training.project.model.content;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Journal implements Serializable, Comparable {
    private int journalId;
    private String journalName;
    private Date timeStamp;

    public Journal(int journalId, String journalName, Date timeStamp) {
        this.journalId = journalId;
        this.journalName = journalName;
        this.timeStamp = timeStamp;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public int getJournalId() {
        return journalId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    @Override
    public int compareTo(Object o) {
        Journal journal = (Journal) o;
        return Integer.compare(getJournalId(), journal.getJournalId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return journalId == journal.journalId &&
                journalName.equals(journal.journalName) &&
                timeStamp.equals(journal.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(journalId, journalName, timeStamp);
    }
}
