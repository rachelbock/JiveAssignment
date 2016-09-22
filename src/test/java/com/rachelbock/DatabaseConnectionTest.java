package com.rachelbock;

import org.junit.Test;

/**
 * Test of database
 */
public class DatabaseConnectionTest {
    @Test
    public void testName() throws Exception {

        System.out.println(System.getenv("DATABASE_NAME"));

    }
}
