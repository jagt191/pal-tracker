package io.pivotal.pal.tracker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry implements Serializable {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
        this.id = 1L;
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = i;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = i;
        this.id = timeEntryId;
    }

    public TimeEntry() {

    }

    public TimeEntry(Long id, TimeEntry any) {
        this.id = id;
        this.hours = any.getHours();
        this.date = any.getDate();
        this.userId = any.getUserId();
        this.projectId = any.getProjectId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return getProjectId() == timeEntry.getProjectId() &&
                getUserId() == timeEntry.getUserId() &&
                getHours() == timeEntry.getHours() &&
                getDate().equals(timeEntry.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getUserId(), getDate(), getHours());
    }
}
