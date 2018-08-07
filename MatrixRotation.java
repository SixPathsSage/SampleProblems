
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Siddharth
 */


public class MatrixRotation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the m");
        int m = scanner.nextInt();
        System.out.println("Enter the n");
        int n = scanner.nextInt();
        
        int array[][] = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter the element for ["+ i + ", " + j + "]");
                array[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Matrix Before Rotation");
        print(array, m, n);
        
        new MatrixRotation().rotate(array, m, n);
        
        System.out.println("Matrix After Rotation");
        print(array, m, n);
    }
    
    public static void print(int[][] array, int m, int n)
    {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    public int[][] rotate(int[][] array, int m, int n)
    {
        int temp1, temp2;
        int row = 0, column = 0;
        
        while(row < m-1 && column < n-1)
        {
            temp1 = array[row+1][column];
            for(int i = column; i < n; i ++)
            {
                temp2 = array[row][i];
                array[row][i] = temp1;
                temp1 = temp2;
            }
            row++;
            
            for(int i = row; i < m; i ++)
            {
                temp2 = array[i][n-1];
                array[i][n-1] = temp1;
                temp1 = temp2;
            }
            n--;
            
            if(column < n)
            {
                for(int i = n-1; i >= column; i --)
                {
                    temp2 = array[m-1][i];
                    array[m-1][i] = temp1;
                    temp1 = temp2;
                }
                m--;
            }
            
            if(row < m)
            {
                for(int i = m-1; i >= row; i--)
                {
                    temp2 = array[i][column];
                    array[i][column] = temp1;
                    temp1 = temp2;
                }
                column ++;
            }
        }
        return array;
    }
    
}
