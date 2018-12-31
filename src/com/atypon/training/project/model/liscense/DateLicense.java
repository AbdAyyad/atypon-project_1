package com.atypon.training.project.model.liscene;

import com.atypon.training.project.model.content.BaseContent;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DateLicense extends BaseLicense implements Serializable,Comparable {
    private Date endDate;

    public DateLicense(int licenseId, Date timeStamp, Date endDate) {
        super(licenseId, timeStamp);
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean canAccessContent(BaseContent content) {
        Date date = new Date();
        return date.compareTo(getEndDate()) < 1;
    }

    @Override
    public int compareTo(Object o) {
        DateLicense dateLicense = (DateLicense) o;
        return Integer.compare(getLicenseId(), dateLicense.getLicenseId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DateLicense that = (DateLicense) o;
        return endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), endDate);
    }
}
