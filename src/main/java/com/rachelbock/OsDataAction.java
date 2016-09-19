package com.rachelbock;

/**
 *Action class for OS Data Collection
 */
public class OSDataAction {

    private String osName;
    private String osVersion;
    private String notes;

    public String execute() throws Exception {

        return "success";
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
