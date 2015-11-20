/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlet;

/**
 *
 * @author Tess
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import JavaClass.*;
import info.*;

public class cartSerlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException
    {
        String productCode = request.getParameter("productCode");
        String quantityString = request.getParameter("quantity");
        
        HttpSession session = request.getSession();       
        cartData cart = (cartData) session.getAttribute("cart");
        if (cart == null)
            cart = new cartData();

        //if the user enters a negative or invalid quantity,
        //the quantity is automatically reset to 1.
        int quantity = 1;
        try
        {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0)
                quantity = 1;
        }
        catch(NumberFormatException nfe)
        {
            quantity = 1;
        }

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("WEB-INF/products.txt");
        products product = infoIO.getProduct(productCode, path);

        items lineItem = new items();
        lineItem.setProducts(product);
        lineItem.setQuantity(quantity);
        if (quantity > 0)
            cart.addItem(lineItem);
        else if (quantity == 0)
            cart.removeItem(lineItem);

        session.setAttribute("cart", cart);
        String url = "/cart.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
