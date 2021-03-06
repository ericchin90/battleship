/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author dmitryigoshin
 */
public class Map {
    private int[][] map;
    private int width;
    private int height;

  Map(int x, int y)
  {
      map = new int[x][y];
      height = y;
      width = x;
      //JOptionPane.showMessageDialog(null, width + " " + height);
  }


  void LoadFromFile(String filename)
  {
        String inLine;
        File inFile;
        StringTokenizer st;
            try {
            inFile = new File(filename);
            BufferedReader fIn = new BufferedReader(new FileReader(inFile));
            for(int i = 0; i < height; i++)
            {
                inLine = fIn.readLine();
                st = new StringTokenizer(inLine);
                for (int j = 0; j < width; j++)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
  }

  void SaveToFile(String filename)
  {
     PrintWriter pw;
        try {
            pw = new PrintWriter(filename);
            for (int i = 0; i < width; i++)
            {
                for (int j = 0; j < height; j++)
                pw.write(map[i][j] + " ");
                pw.println();
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file" + e.getMessage());
        }

  }

  void PrintOut()
  {
      int i, j;
     
          for (j = 0; j < height; j++) {
        	  for (i = 0; i < width; i++)
              {
              System.out.print(map[j][i] + " ");
              }
          System.out.println();
          }
  }

  int[][] GetMap()
  {
      return map;
  }


  void SetMap(int[][] newmap)
  {
      try
      {
          map = newmap;
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
  }

  int getCell(int x, int y)
  {
      return map[x][y];
  }

  void setCell(int x, int y, int value)
  {
      map[x][y] = value;
  }

  int getWidth()
  {
      return width;
  }

  int getHeight()
  {
     return height;
  }


}
