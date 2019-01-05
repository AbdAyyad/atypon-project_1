package com.atypon.training.project.server.model.liscense;

import com.atypon.training.project.server.model.content.BaseContent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class ContentLicense extends BaseLicense implements Serializable, Comparable {
    private Set<Integer> contentIdSet;

    public ContentLicense(int licenseId, LocalDate timeStamp, Set<Integer> contentIdSet) {
        super(licenseId, timeStamp);
        this.contentIdSet = contentIdSet;
    }

    public Set<Integer> getContentIdSet() {
        return new HashSet<>(contentIdSet);
    }

    @Override
    public boolean canAccessContent(BaseContent content) {
        return contentIdSet.contains(content.getContentId());
    }

    @Override
    public int compareTo(Object o) {
        ContentLicense contentLicense = (ContentLicense) o;
        return Integer.compare(getLicenseId(), contentLicense.getLicenseId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContentLicense that = (ContentLicense) o;
        return contentIdSet.equals(that.contentIdSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contentIdSet);
    }
}
