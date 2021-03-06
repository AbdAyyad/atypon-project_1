package com.atypon.training.project.server.model.liscense;

import com.atypon.training.project.server.model.content.BaseContent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class JournalLicense extends BaseLicense implements Serializable, Comparable {
    private int journalId;

    public JournalLicense(int licenseId, LocalDate timeStamp, int journalId) {
        super(licenseId, timeStamp);
        this.journalId = journalId;
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    @Override
    public boolean canAccessContent(BaseContent content) {
        return content.getJournalId() == getJournalId();
    }

    @Override
    public int compareTo(Object o) {
        JournalLicense journalLicense = (JournalLicense) o;
        return Integer.compare(getLicenseId(), journalLicense.getLicenseId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JournalLicense that = (JournalLicense) o;
        return journalId == that.journalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), journalId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JournalLicense.class.getSimpleName() + "[", "]")
                .add("licenseId=" + getLicenseId())
                .add("timeStamp=" + getTimeStamp())
                .add("journalId=" + journalId)
                .toString();
    }
}
