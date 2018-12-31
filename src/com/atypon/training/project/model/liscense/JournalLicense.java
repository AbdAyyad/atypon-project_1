package com.atypon.training.project.model.liscene;

import com.atypon.training.project.model.content.BaseContent;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JournalLicense extends BaseLicense implements Serializable, Comparable {
    private int journalId;

    public JournalLicense(int licenseId, Date timeStamp, int journalId) {
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
}
