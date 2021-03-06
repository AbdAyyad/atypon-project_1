package com.atypon.training.project.server.model.jouranl;

import com.atypon.training.project.server.model.Identifiable;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Journal{");
        sb.append("journalId=").append(journalId);
        sb.append(", journalName='").append(journalName).append('\'');
        sb.append(", timeStamp=").append(timeStamp);
        sb.append('}');
        return sb.toString();
    }
}
