package com.rachelbock;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 *Action class for OS Data Collection and Display. Handles collecting data from form and provides method for getting
 * the data back out.
 */
public class OsDataAction extends ActionSupport {

    private String osName;
    private String osVersion;
    private String notes;
    private OSDataDAO osDataDAO = new OSDataDAO();


    /**
     * Method called from struts.xml when the Submit button on the main entry page is selected. It returns a string
     * which launches the results page.
     * Method also captures the three data fields from the entry page and adds the data to the database.
     * @return - string used as key for launching results.jsp from struts.xml
     * @throws Exception
     */
    public String execute() throws Exception {

        OSData osData = new OSData(getOsName(), getOsVersion(), getNotes());
        osDataDAO.setOSData(osData);

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

    /**
     * List of OSData retrieved from the database.
     * @return List of OSData to populate results page
     */
    public List<OSData> getOsDataList() {
        return osDataDAO.getOSData();
    }

    /**
     * Method to validate that required fields are not left blank.
     */
    public void validate() {
        if (osName == null || osName.trim().length() == 0) {
            addFieldError("osName", "OS Name is required");
        }

        if (osName == null || osVersion.trim().length() == 0){
            addFieldError("osVersion", "OS Version is required");
        }
    }
}
