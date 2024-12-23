package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    private int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (rollbackVersion >= currentVersion) {
            return false;
        }

        Iterator<Map.Entry<Integer, String>> iterator = versionHistoryMap.entrySet().iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (found) {
                iterator.remove();
            }
            if (entry.getKey().equals(rollbackVersion)) {
                found = true;
            }
        }
        if(found) currentVersion = rollbackVersion;

        return found;
    }
}
