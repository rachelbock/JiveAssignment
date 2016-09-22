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

h3 {
    font-family: times new roman;
}
</style>
<title>OS Data Entry</title>
<s:head/>
</head>
<body>

<h1>Operating System Data</h1>
<h3>Enter the following information:</h3>
  <s:form action="data_entry">
      <s:textfield name="osName" label="OS Name" />
      <s:textfield name="osVersion" label="OS Version" />
      <s:textarea name="notes" label="Notes" rows="4" />
      <s:submit value="Submit"/>
   </s:form>

</body>
</html>