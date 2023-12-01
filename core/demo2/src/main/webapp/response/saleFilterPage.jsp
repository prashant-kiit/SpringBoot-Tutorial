<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="/filterdata">Filter:</label><br><br>
	<form action="/filterdata">
    <label for="startdate">Start Date:</label>
    <input type="date" name="startdate"><br><br>
    <label for="enddate">End Date:</label>
    <input type="date" name="enddate"><br><br>
    <input type="submit" value="Submit"><br><br>
    </form>
</body>
</html>