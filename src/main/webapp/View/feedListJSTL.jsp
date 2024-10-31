<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Feed List - JSTL</title>
</head>
<body>
    <h1>Feed Entries</h1>
    <c:forEach var="feed" items="${feeds}">
        <h2>${feed.title}</h2>
        <p>${feed.description}</p>
        <small>${feed.date}</small>
        <hr />
    </c:forEach>
</body>
</html>


