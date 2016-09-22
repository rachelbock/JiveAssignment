<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style>

h1 {
   font-family: times new roman;
   text-decoration: underline;

}

table {
    font-family: times new roman;
    border-collapse: collapse;
    table-layout: fixed;

}

th, td {
    border: 1px solid #000000;
    text-align: left;
    padding: 10px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<title>OS Data Results</title>
</head>
<body>

<a href="entry.jsp">Back to Entry Page</a>

	<h1>OS Data:</h1>

    <table style="width:100%">
      <tr>
        <th>OS Name</th>
        <th>OS Version</th>
        <th>Notes</th>
      </tr>
      <s:iterator  value="osDataList">
      <tr>
        <td><s:property value="osName"/></td>
        <td><s:property value="osVersion"/></td>
        <td><s:property value="notes"/></td>
      </tr>
      </s:iterator>
     </table>


</body>

</html>