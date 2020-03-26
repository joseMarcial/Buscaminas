import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buscaminas {
	
		
	public static void main (String arg[]) {
		
		int size =4;
		int size2 = 4;	
		
		String input = "*...\n....\n.*..\n....";
		
		String [] arrays =input.split("\n");
			
		
		char [][] array = new char [size][size2];
		for (int x=0 ; x<arrays.length ; x++ ) {
			System.out.println(arrays[x] );
			array[x]= arrays[x].toCharArray();
		}
		
		for (char[] arr : array ) {
		System.out.println(Arrays.toString(arr));
		}
		
		List<String> bombs = new ArrayList<>();
		
		for (int x = 0; x < size; x++) {

			for (int j = 0; j < size2; j++) {
				if (array[x][j] == '*') {
					System.out.println("yes");
					bombs.add(String.valueOf(x)+String.valueOf(j));
				}
			}
		}
		
		for (int x = 0; x < size; x++) {

			for (int j = 0; j < size2; j++) {
				if (array[x][j] == '.') {
					System.out.println("yes");
					List<String> sPoints = generateSP( x , j);
					int counter = 48;
					for (String sp  : sPoints ) {
						if (bombs.contains(sp)) {
						counter++;
						}
					}
					System.out.println(counter);
					array[x][j]= (char) counter;
				}
			}
		}
		
		
		for (char[] arr : array ) {
			System.out.println(Arrays.toString(arr));
			}
		
		
		
		
	}

	private static List<String> generateSP(int x, int y) {
		List<String> sp = new ArrayList<>();
		sp.add(new String (String.valueOf(x-1)+String.valueOf(y-1)));
		sp.add(new String (String.valueOf(x-1)+String.valueOf(y)));
		sp.add(new String (String.valueOf(x-1)+String.valueOf(y+1)));
		sp.add(new String (String.valueOf(x)+String.valueOf(y-1)));
		sp.add(new String (String.valueOf(x)+String.valueOf(y+1)));
		sp.add(new String (String.valueOf(x+1)+String.valueOf(y-1)));
		sp.add(new String (String.valueOf(x+1)+String.valueOf(y)));
		sp.add(new String (String.valueOf(x+1)+String.valueOf(y+1)));
		
		return sp;
		
	}
	
	
	
	

}
