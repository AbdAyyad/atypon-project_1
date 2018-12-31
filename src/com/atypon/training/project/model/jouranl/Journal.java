package com.atypon.training.project.model.jouranl;

import com.atypon.training.project.model.Identifiable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Journal implements Serializable, Comparable, Identifiable {
    private int journalId;
    private String journalName;
    private LocalDate timeStamp;

    public Journal(int journalId, String journalName, LocalDate timeStamp) {
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

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public int getId(){
        return getJournalId();
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
