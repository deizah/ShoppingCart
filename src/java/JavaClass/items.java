/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author Tess
 */

import java.io.Serializable;
import java.text.NumberFormat;

// class to define product variables
public class items implements Serializable
{
    private products product;
    private int quantity;
    
    public items() {}
    //setter for class products, it changes the value of variable
    public void setProducts(products p)
    {
        product = p;
    }
    //methods that gets current value as selected
    public products getProduct()
    { 
        return product;
    }
    
    //setter and getter for variable quantity
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getTotal()
    { 
        double total = product.getPrice() * quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}

