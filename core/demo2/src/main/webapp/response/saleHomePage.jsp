<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    WELCOME TO SALES PAGE!<br><br>
    <label for="/add">Add:</label><br><br>
	<form action="/add">
    <input type="submit" value="Submit"><br><br>
    </form>
    <label for="/list">Sales:</label><br><br>
	<form action="/list">
    <input type="submit" value="Submit"><br><br>
    </form>
    <label for="/filter">Filter:</label><br><br>
	<form action="/filter">
    <input type="submit" value="Submit"><br><br>
    </form>
    <label for="/update">Update:</label><br><br>
	<form action="/update">
    <input type="submit" value="Submit"><br><br>
    </form>
    <label for="count-javaconfig">Count:</label><br><br>
	<form action="count-javaconfig">
    <input type="submit" value="Submit"><br><br>
    </form>
	Delete:
	Add hyperlink here using Thymeleaf.
</body>
</html>