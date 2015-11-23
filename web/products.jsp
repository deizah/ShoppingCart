  <%-- 
    Document   : products
    Created on : Nov 23, 2015, 8:48:56 AM
    Author     : Tess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart System</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Fashion Products</h1>

<table cellpadding="5" border=1>

  <tr valign="bottom">
    <td align="left"><b>Description</b></td>
    <td align="left"><b>Price</b></td>
    <td align="left"></td>
  </tr>

  <tr valign="top">
    <td>Gucci Handbag</td>
    <td>Ksh 4500</td>
    <td><a href="<c:url value='/cart?productCode=8601' />">
        Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>Rolex Time Piece</td>
    <td>Ksh 3000</td>
    <td><a href="<c:url value='/cart?productCode=pf01' />">
        Add To Cart</a></td>
  </tr>
  
  <tr valign="top">
    <td>Jimmy Choo Shoes</td>
    <td>Ksh 3500</td>
    <td><a href="<c:url value='/cart?productCode=pf02' />">
        Add To Cart</a></td>
  </tr>

  
  <tr valign="top">
    <td>Calvin Klein Jacket</td>
    <td>Ksh 5000</td>
    <td><a href="<c:url value='/cart?productCode=jr01' />">
        Add To Cart</a></td>
  </tr>

</table>

</body>
</html> 

