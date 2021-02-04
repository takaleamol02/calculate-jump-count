/*
This java program will calculate no. of jumps theif has to take to cross no. of walss and escape

Every time he jumps, he slides down by climbdDown meter. Basically his effective jump would be (climbUp - climbDown) 

E.g. Suppose he is capable of jumping 10 meter and slides down by 1 meter. If the height of wall is 10 meter, he will jump in one go because he is capable of jumping 10 meters. But if height of wall is 11 meters then he has to take 2 jumps because in first jump he will slide down by 1 meter it means he has jumped 9 meters and he will jump one more time to cross remaining 2 meters 9+2 = 11.
*/

import java.util.Scanner;

public class CalculateJumpCount { 
       
    //This function will calculate no. of jumps theif has to take
    public static int jumpcount(int climbUp, int climbDown, int noOfWalls, 
                                  int wallHeights[]) 
    { 
        int jump_count = 0; 
       
        for (int i = 0; i < noOfWalls; i++) { 
            
            /*If wall height is equal or less to his jump capability, then he will cross in one jump only
            */
            if (wallHeights[i] <= climbUp) { 
                jump_count++; 
                continue;
            } 
       
            /* This code section will be executed when wall height is greater than his jump capability */
            int height = wallHeights[i]; 
            
            while (height > climbUp) 
            { 
                jump_count++; 
                
                //Here after making first jump, he will slide down by climbDown meters. 
                height = height - (climbUp - climbDown); 
            } 
            
            /*If remaining height is less than or equal to his jumping capability he will jump in one go again.*/
            jump_count++; 
        } 
        return jump_count; 
    } 
       
    /*driver function*/
    public static void main(String args[]) 
    { 
        int climbUp, climbDown, noOfWalls, jump_count = 0;
        
        try {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Enter the number of theif's jumping capability in meters: ");
	        
	        climbUp = scanner.nextInt();
	        
	        System.out.println("Enter the number of meters theif will slide down : ");
	        
	        climbDown =  scanner.nextInt();
	        
	        System.out.println("Enter of no. of walls : ");
	        
	        noOfWalls =  scanner.nextInt();
	        
	        int wallHeights[] = new int[noOfWalls]; 
	        
	        System.out.println("Enter wall heights : ");
	        
	        for( int i = 0 ; i < noOfWalls ; i++ )
	            wallHeights[i] = scanner.nextInt();
	        
	        jump_count = jumpcount(climbUp, climbDown, noOfWalls, wallHeights);
	        
        }catch(Exception e){
        	System.out.println("Entered inputs are not correct, restart program and please enter input in numbers only");
        	System.exit(0);
        }
               
        System.out.println("No. of jums theif has to take to escape from jail : "+ jump_count);
         
    } 
} 