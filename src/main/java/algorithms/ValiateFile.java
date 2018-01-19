package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValiateFile {

    private boolean isFileValid(String filename)
    {
        BufferedReader br;
        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line;
            int size = 0, lines = 0;
            while ((line = br.readLine()) != null)
            {
                line = line.trim();
                if (isComment(line))
                    continue ;
                line = removeComment(line);
                if (isNumber(line))
                {
                    if (size > 0)
                        return (false);
                    size = Integer.parseInt(line);
                    if (size < 2)
                        return (false);
                }
                else
                {
                    lines++;
                    if (size > 0 && lines <= size)
                    {
                        String[] items = line.split("\\s+");
                        if (items.length != size)
                            return (false);
                        for (String str : items)
                        {
                            if (isNumber(str) == false)
                                return (false);
                        }
                    }
                    else
                        return (false);
                }
            }
            if (lines != size)
                return (false);
            return (true);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
        return (true);
    }


    public static boolean isComment(String line)
    {
        if (line.charAt(0) == '#')
            return (true);
        else
            return (false);
    }

    public static boolean isNumber(String line)
    {
        for (char c : line.toCharArray())
        {
            if (Character.isDigit(c) == false)
                return (false);
        }
        return (true);
    }

    public static String removeComment(String line)
    {
        line = line.split("#")[0];
        return (line);
    }
}