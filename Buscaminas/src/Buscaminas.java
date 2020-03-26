import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buscaminas {
	
		
	public static void main (String arg[]) {
		
		
		//reading the values from imput 
		int size =2;
		int size2 = 4;	
		
		String input = "*...\n....";
		
		String [] arrays =input.split("\n");
			
		// creating the arrays
		char [][] array = new char [size][size2];
		for (int x=0 ; x<arrays.length ; x++ ) {
			//System.out.println(arrays[x] );
			array[x]= arrays[x].toCharArray();
		}
		
		// solution 
		
		
//		for (char[] arr : array ) {
//		System.out.println(Arrays.toString(arr));
//		}
//		
//		List<String> bombs = new ArrayList<>();
		
		for (int x = 0; x < size; x++) {

			for (int j = 0; j < size2; j++) {
//				if (array[x][j] == '*') {
//					System.out.println("yes");
//					//bombs.add(String.valueOf(x)+String.valueOf(j));
//				}
				
				if (array[x][j] == '.') {
					//System.out.println("yes");
					List<String> sPoints = generateSP( x , j);
					int counter = 48;
					for (String sp  : sPoints ) {
						if (isvalid(sp,size, size2) && array[Character.getNumericValue(sp.charAt(0))][Character.getNumericValue(sp.charAt(1))]=='*') {
						counter++;
						}
					}
					//System.out.println(counter);
					array[x][j]= (char) counter;
				}
				
				
			}
		}
		

		
		for (char[] arr : array ) {
			System.out.println(Arrays.toString(arr));
			}
		
		
		
		
	}

	private static boolean isvalid(String sp, int size, int size2) {
		if	(sp.contains("-")) {
			return false;
		}
		if (Character.getNumericValue(sp.charAt(0)) >= size){
			return false;
		}
		if (Character.getNumericValue(sp.charAt(1)) >= size2){
			return false;
		}
		
		
		return true;
	}

	//Generate a list of surrounding points
	private static List<String> generateSP(int x, int y) {
		
		List<String> sp = new ArrayList<>();
		sp.add(String.valueOf(x-1)+String.valueOf(y-1));
		sp.add(String.valueOf(x-1)+String.valueOf(y));
		sp.add(String.valueOf(x-1)+String.valueOf(y+1));
		sp.add(String.valueOf(x)+String.valueOf(y-1));
		sp.add(String.valueOf(x)+String.valueOf(y+1));
		sp.add(String.valueOf(x+1)+String.valueOf(y-1));
		sp.add(String.valueOf(x+1)+String.valueOf(y));
		sp.add(String.valueOf(x+1)+String.valueOf(y+1));
		
		return sp;
		
	}
	
	
	
	

}
