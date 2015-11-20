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
import java.util.ArrayList;
//class with methods to manipulate data defined
public class cartData implements Serializable
{   
    //array to collect data from xml file
    private ArrayList<items> cartItems;
    
    public cartData()
    {
        cartItems = new ArrayList<items>();
    }
    //getter array
    public ArrayList<items> getItems()
    { 
        return cartItems;
    }
    //function to count the quantity of data selected
    public int getCount()
    { 
        return cartItems.size();
    }
    
    //functionn to update user selection
    public void addItem(items item)
    {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (int i = 0; i < cartItems.size(); i++)
        {
            items cartItem = cartItems.get(i);
            if (cartItem.getProduct().getCode().equals(code))
            {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        cartItems.add(item);
    }
    //function to remove user item 
    public void removeItem(items item)
    {
        String code = item.getProduct().getCode();
        for (int i = 0; i < cartItems.size(); i++)
        {
            items lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code))
            {
                items.remove(i);
                return;
            }
        }
    }
}
