package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> hashMap;
    private int i;
    @Override
    public TimeEntry create(TimeEntry any) {

        if (null == hashMap){
            hashMap = new HashMap<>();
            i = 0;
        }
        i = i + 1;
        Long id = Long.valueOf(i);
        TimeEntry entry = new TimeEntry(id, any);
        hashMap.put(id, entry);
        return entry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        if (null == hashMap){
            return null;
        }
        return hashMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        if (null == hashMap){
            return null;
        }
        Collection<TimeEntry> values = hashMap.values();
        return new ArrayList<TimeEntry>(values);
    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {

        if (null == hashMap || null == hashMap.get(eq)){
            return null;
        }
        TimeEntry timeEntry = new TimeEntry(eq, any);
        hashMap.put(eq, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long timeEntryId) {

        if (null == hashMap){
            return;
        }
        hashMap.remove(timeEntryId);
    }
}
