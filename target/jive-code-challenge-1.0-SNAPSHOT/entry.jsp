<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style>

h1 {
    font-family: times new roman;
    text-decoration: underline;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>

<s:head/>

</head>

<body>

<h1>Operating System Data</h1>
<h3>Enter the following information:</h3>
  <s:form action="data_entry">
      <s:textfield name="osName" label="OS Name" /><br>
      <s:textfield name="osVersion" label="OS Version" /><br>
      <s:textarea name="notes" label="Notes" rows="4" /><br>
      <s:submit value="Submit"/>
   </s:form>

</body>
</html>