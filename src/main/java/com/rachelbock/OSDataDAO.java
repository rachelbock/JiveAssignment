package com.rachelbock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods for interacting with the MySQL database
 */
public class OSDataDAO {

    public static final String SET_DATA_QUERY = "INSERT INTO os_data (os_name, os_version, notes) \n" +
            "VALUES (?, ?, ?)";

    public static final String GET_DATA_QUERY = "SELECT * FROM os_data";

    /**
     * Method to insert an OSData object into the database.
     */
    public void setOSData(OSData osData) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SET_DATA_QUERY)
        ) {

            stmt.setString(1, osData.getOsName());
            stmt.setString(2, osData.getOsVersion());
            stmt.setString(3, osData.getNotes());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to retrieve all of the OSData from the database and store in a list.
     */
    public List<OSData> getOSData() {
        List<OSData> osDataList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(GET_DATA_QUERY);
        ) {

            while (resultSet.next()) {
                OSData osData = new OSData(
                        resultSet.getString("os_name"),
                        resultSet.getString("os_version"),
                        resultSet.getString("notes")
                );
                osDataList.add(osData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return osDataList;
    }

}
