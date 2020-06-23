import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class DistanceFromAverage
{ public static void main (String[] args) throws IOException
  {
  int arraySize = 0;
  double[] array = {0};
  double sum = 0;
  double ave;
  double[] distance = {0};
  boolean done = false;
  
  Scanner scan = new Scanner(System.in);
  
  while(!done)
  {
   try
   {
   System.out.println("Enter the size of the array (maximum is 15):");
   arraySize = scan.nextInt();
   
   if (arraySize < 0)
     throw new NegativeArraySizeException("The arraySize is negative.");
   if (arraySize > 15)
     throw new ArraySizeTooBigException("The arraySize is too big.");
   
   done = true;
   }
  catch(InputMismatchException exception)
  {
    System.out.println("The exception message is: " + exception.getMessage());
    
    System.out.println("This is not an integer. Try again.");
    
    scan.close(); 
    scan = new Scanner(System.in);
  }
  catch(NegativeArraySizeException exception)
  {
  System.out.println("The exception message is: " + exception.getMessage());
  
  System.out.println("The size of the array is 5 by default.");
  arraySize = 5;
  
  done = true;
  }
  catch(ArraySizeTooBigException exception)
  {
  System.out.println("The exception message is: " + exception.getMessage() + "\n" + arraySize + " is too big.");
  
  System.out.println("The size of the array is 15 by default.");
  arraySize = 15;
  
  done = true;
  }
 }
    
   array = new double[arraySize];
   distance = new double[arraySize];
    
    for (int i = 0; i < arraySize; i++)
    {
      done = false;
      while(!done)
      {
        try
        {
          System.out.println("Enter floating point number for the array[" + i + "].");
          array[i] = scan.nextDouble();
          sum += array[i];
          
          done = true;
        }
        catch(InputMismatchException exception)
        {
          System.out.println("The exception message is: " + exception.getMessage() + ".");
          
          System.out.println("The value is not correct. Try again.");
          
          scan.close(); 
          scan = new Scanner(System.in);
        }
      }
    }
    
    DecimalFormat fmt = new DecimalFormat("####.#");
    
    if (arraySize != 0)
    {
      ave = sum/arraySize;
      System.out.println("The average is " + fmt.format(ave));
      
      for(int j = 0; j < arraySize; j++)
      { if (ave > array[j])
          distance[j] = ave - array[j];
        else
          distance[j] = array[j] - ave;
        System.out.println("Distance from average for " + array[j] + " is " + fmt.format(distance[j]) + ".");
      }
    }
  }
}
