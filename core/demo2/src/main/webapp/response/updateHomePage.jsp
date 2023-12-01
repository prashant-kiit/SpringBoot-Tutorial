<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="/updatedata">Update:</label><br><br>
	<form action="/updatedata">
	<label for="startdate">SaleID:</label>
	<input type="number" name="saleId"><br><br>
    <label for="buyer">Buyer:</label>
    <input type="text" name="buyer"><br><br>
    <label for="seller">Seller:</label>
    <input type="text" name="seller"><br><br>
    <input type="submit" value="Submit"><br><br>
    </form>
</body>
</html>