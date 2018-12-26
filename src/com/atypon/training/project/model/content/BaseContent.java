package com.atypon.training.project.model.content;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class BaseContent implements Comparable, Serializable {
    private int contentId;
    private Date timeStamp;
    private int journalId;
    private int authorId;

    public BaseContent(int contentId, Date timeStamp, int journalId, int authorId) {
        this.contentId = contentId;
        this.timeStamp = timeStamp;
        this.journalId = journalId;
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public int getContentId() {
        return contentId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseContent)) return false;
        BaseContent that = (BaseContent) o;
        return contentId == that.contentId &&
                journalId == that.journalId &&
                authorId == that.authorId &&
                timeStamp.equals(that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentId, timeStamp, journalId, authorId);
    }
}
