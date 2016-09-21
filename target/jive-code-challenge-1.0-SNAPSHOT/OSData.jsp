<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<body>
	<h3>All Records:</h3>
    <s:iterator  value="osDataList">
    <fieldset>
    <s:property value="osName"/><br/>
    <s:property value="osVersion"/><br/>
    <s:property value="notes"/><br/>
    </fieldset>
    </s:iterator>
</body>



</html>