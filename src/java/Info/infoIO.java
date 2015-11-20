/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

/**
 *
 * @author Tess
 */
import java.io.*;
import java.util.*;

import JavaClass.*;

//exception handler to catch any error incase of errors
public class infoIO
{
    public static products getProduct(String code, String filepath)
    {
        try
        {
            File file = new File(filepath);
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String productCode = t.nextToken();
                if (code.equalsIgnoreCase(productCode))
                {
                    String description = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    products p = new products();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<products> getProducts(String filepath)
    {
        ArrayList<products> products = new ArrayList<products>();
        File file = new File(filepath);
        try
        {
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);
                products p = new products();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}