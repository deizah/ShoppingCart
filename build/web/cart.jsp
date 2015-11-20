<%-- 
    Document   : cart
    Created on : Nov 19, 2015, 12:00:41 PM
    Author     : Tess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Shopping Cart</title>
</head>
<body>
<%--
table to display shopping cart data 
--%>
<h1>Shopping Cart</h1>

<table border="1" cellpadding="5">
	<tr>
		<th>Quantity</th>
		<th>Description</th>
		<th>Price</th>
		<th>Amount</th>
		<th></th>
	</tr>
        <%--
for loop to get and display products user ha selected
--%>
	<c:forEach var="item" items="${cart.items}">
		<tr valign="top">
			<td>
			<form action="<c:url value='/cart' />">
			    <input type="hidden" name="productCode" 
			           value="${item.product.code}"> 
				<input type="text" size="2" name="quantity" 
				       value="${item.quantity}"> 
				<input type="submit" value="Update">
			</form>
			</td>
			<td>${item.product.description}</td>
			<td>${item.product.price}</td>
			<td>${item.total}</td>
			<td>
			<form action="<c:url value='/cart' />"><input type="hidden"
				name="productCode" value="${item.product.code}"> <input
				type="hidden" name="quantity" value="0"> <input
				type="submit" value="Remove Item"></form>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3">
		<p><b>To change the quantity</b>, enter the new quantity and click
		on the Update button.</p>
		</td>
	</tr>
</table>

<br>

<form action="<c:url value='/index.jsp' />" method="post"><input
	type="submit" value="Continue Shopping"></form>

<form action="<c:url value='/checkout.jsp' />" method="post"><input
	type="submit" value="Checkout"></form>

</body>
</html>
