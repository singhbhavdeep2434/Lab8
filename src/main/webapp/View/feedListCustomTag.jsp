<%@ taglib uri="http://bhavdeep.com/feed" prefix="f" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Feed List - Custom Tag</title>
</head>
<body>
    <h1>Feed Entries</h1>
    <f:feedList feeds="${feeds}" />
</body>
</html>
