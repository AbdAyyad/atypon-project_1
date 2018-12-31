package com.atypon.training.project.model.liscene;

import com.atypon.training.project.model.Identifiable;
import com.atypon.training.project.model.content.BaseContent;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class BaseLicense implements Serializable, Comparable, Identifiable {
    private int licenseId;
    private Date timeStamp;

    public BaseLicense(int licenseId, Date timeStamp) {
        this.licenseId = licenseId;
        this.timeStamp = timeStamp;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public abstract boolean canAccessContent(BaseContent content);

    public int getId(){
        return getLicenseId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseLicense)) return false;
        BaseLicense license = (BaseLicense) o;
        return licenseId == license.licenseId &&
                timeStamp.equals(license.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseId, timeStamp);
    }
}
