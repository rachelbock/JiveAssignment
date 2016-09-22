package com.rachelbock;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;


/**
 * Tests that validation is handled appropriately on entry page
 */
public class EntryValidationTest extends StrutsTestCase {

    @Test
    public void testValidationPass() throws Exception{
        request.setParameter("osName", "OS Name");
        request.setParameter("osVersion", "OS Version");
        request.setParameter("notes", "Notes");

        ActionProxy actionProxy = getActionProxy("/data_entry.action");
        ActionSupport action = (ActionSupport) actionProxy.getAction();

        assertNotNull("Action is null", action);

        String result = actionProxy.execute();

        assertEquals("The execute method did not return " + ActionSupport.SUCCESS, ActionSupport.SUCCESS, result);
    }

    @Test
    public void testValidationFailNoName() throws Exception{
        request.setParameter("osVersion", "OS Version");
        request.setParameter("notes", "notes");

        ActionProxy actionProxy = getActionProxy("/data_entry.action");

        ActionSupport action = (ActionSupport) actionProxy.getAction() ;

        assertNotNull("Action is null", action);

        String result = actionProxy.execute();

        assertEquals("The execute method did not return " + ActionSupport.INPUT, ActionSupport.INPUT, result);
    }

    @Test
    public void testValidationFailNoVersion() throws Exception{

    }

    @Test
    public void testValidationNoNameAndVersion() throws Exception{

    }
}
