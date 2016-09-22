package com.rachelbock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * Test on database connection.
 */
public class DatabaseConnectionTest {


    @Before
    public void setUp() throws Exception {
        if (System.getenv("DATABASE_NAME") == null) {
            throw new IllegalStateException("Environment variable DATABASE_NAME should be set before running tests");
        }
        try(Connection connection = ConnectionPool.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute("TRUNCATE os_data");
        }

    }

    /**
     * Tests OSDataDao methods to set Data and get Data from the jive_challenge_test database.
     */
    @Test
    public void testConnection() throws Exception {

        //First tests that one OS Data object can be added and retrieved from the database.
        OSDataDAO osDataDAO = new OSDataDAO();
        String osName1 = "Windows";
        String osVersion1 = "8.0";
        String notes1 = "New Version Available";
        OSData osData1 = new OSData(osName1, osVersion1, notes1);

        osDataDAO.setOSData(osData1);

        List<OSData> osDataList1 = osDataDAO.getOSData();
        OSData firstItemList1 = osDataList1.get(0);

        Assert.assertTrue(osDataList1.size() == 1);
        Assert.assertTrue(firstItemList1.getOsName().equals(osName1));
        Assert.assertTrue(firstItemList1.getOsVersion().equals(osVersion1));
        Assert.assertTrue(firstItemList1.getNotes().equals(notes1));

        //Second tests that adding another object will not overwrite the first one but that both will be in the database.
        String osName2 = "Mac";
        String osVersion2 = "OSX 10.7";
        String notes2 = "Latest Version";

        OSData osData2 = new OSData(osName2, osVersion2, notes2);
        osDataDAO.setOSData(osData2);

        List<OSData> osDataList2 = osDataDAO.getOSData();
        OSData firstItemList2 = osDataList2.get(0);
        OSData secondItemList2 = osDataList2.get(1);

        Assert.assertTrue(osDataList2.size() == 2);
        Assert.assertTrue(firstItemList2.getOsName().equals(osName1));
        Assert.assertTrue(secondItemList2.getOsName().equals(osName2));
    }
}
