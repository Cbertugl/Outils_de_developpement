
package example;

import com.opencsv.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import org.apache.commons.lang.WordUtils;

public class Hello {
    public static void main(String[] args) {
        String  message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
                                + " : " + WordUtils.capitalizeFully(message));
        
        int monmax = 0;
        int x;
        String[] nbstr;
        String[] nb;
        try
        {
            CSVReader reader = new CSVReader(new FileReader("data.csv"));
            try
            {
                List<String[]>myEntries = reader.readAll();

                for(int i=0; i<myEntries.size(); i++)
                {
                    System.out.println("Ligne:"+i);
                    nbstr=myEntries.get(i);
                    //parcourt
                    nb=nbstr[0].split(";");
                    for(int k=0; k<nb.length; k++)
                    {
                        x = Integer.parseInt(nb[k]);
                        System.out.println("Nombre lu:"+x);
                        if(monmax == 0 || x>monmax)
                        {
                            monmax=x;
                        } 
                    }
                }    
            System.out.println("Le max:"+monmax);
            }
            catch (IOException e)
            {
                System.out.println("Erreur: IOException");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Erreur: FileNotFoundException");
        }
    } 
}
        