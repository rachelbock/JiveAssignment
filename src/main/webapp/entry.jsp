<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>OS Data</title>
</head>
<body>
<h1>Operating System Data</h1>
   <form action="data_entry">
      <label for="osName">OS: </label>
      <input type="text" name="osName"/><br/>
      <label for="osVersion">OS Version: </label>
      <input type="text" name="osVersion"/><br/>
      <label for="notes">Notes: </label>
      <input type="text" name="notes"/>
      <input type="submit" value="Submit"/>
   </form>
</body>
</html>