<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <label for="/add">Add:</label><br><br>
	<form action="/adddata">
    <label for="dateOfSale">Sale:</label>
    <input type="date" name="dateOfSale"><br><br>
    <label for="seller">Seller:</label>
    <input type="text" name="seller"><br><br>
    <label for="buyer">Buyer:</label>
    <input type="text" name="buyer"><br><br>
    <input type="submit" value="Submit">
    </form>
</body>
</html>