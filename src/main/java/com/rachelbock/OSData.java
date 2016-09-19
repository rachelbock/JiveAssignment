package com.rachelbock;

/**
 * Object containing all OS Data elements
 */
public class OSData {

    private String osName;
    private String osVersion;
    private String notes;

    public OSData(String osName, String osVersion, String notes) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.notes = notes;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
