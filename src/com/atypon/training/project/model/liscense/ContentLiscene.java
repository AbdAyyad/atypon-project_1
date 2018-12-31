package com.atypon.training.project.model.liscene;

import com.atypon.training.project.model.content.BaseContent;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class ContentLiscene extends BaseLicense implements Serializable, Comparable {
    private Set<Integer> contentIdSet;

    public ContentLiscene(int licenseId, Date timeStamp, Set<Integer> contentIdSet) {
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
        ContentLiscene contentLiscene = (ContentLiscene) o;
        return Integer.compare(getLicenseId(), contentLiscene.getLicenseId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContentLiscene that = (ContentLiscene) o;
        return contentIdSet.equals(that.contentIdSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contentIdSet);
    }
}
