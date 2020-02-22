
//2458304L

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AssEx1 {
    
	
	/** read strings from file 
     * and add them to an array. Assume that in the file there is one string
     * per line.
     * @param filename
     * return array
     */
	public static String[] readFromFile(String fileName){
		ArrayList<String> temp = new ArrayList<String>();
		try{
			FileReader fr = new FileReader(fileName);
			Scanner s = new Scanner(fr);
			while(s.hasNext()){
				temp.add(s.next().trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		String[] result = (String[]) temp.toArray(new String[temp.size()]);
		return result;
	}
	
	
	/**
	 * Add all of the elements of an array of Strings
	 * to a set of strings - note repeats will disappear
	 * your set should be instantiated as a TreeSet (see lecture 1)
	 */
	public static Set<String> arrayToSet(String[] myArray){
		Set<String> set = new TreeSet<String>();
		for(String s: myArray){
			set.add(s);
		}
		return set; 
		
	}
	
	
	/** randomly re-order an array
	 * 
	 * @param origArray
	 */
	public static void jumbleArray(String[] origArray){
		List<String> list = Arrays.asList(origArray);
		Collections.shuffle(list);
		for(int i=0; i<origArray.length;i++){
			origArray[i] = list.get(i);
		}
		return; 
		
	}
	
	/** create a string consisting all of the elements in an array,
	 * one element per row.
	 * Use a for--each loop to return them in the order in which they 
	 * are stored
	 */
	public static String arrayToString(String[] stringArray){
		String result = "";
		for(String s: stringArray){
			result = result + s + "\n";
		}
		return result; //replace this with your implementation
		
	}
	
	/** create a string consisting of all of the elements in a set,
	 * one element per row.
	 * Use a for--each loop to return them in the order in which they 
	 * are stored
	 */
	public static String setToString(Set<String> stringSet){
		String result = "";
		for(String s: stringSet){
			result = result + s + "\n";
		}
		return result; //replace this with your implementation
	}
	
	
	
	/**
	 * main method - do not edit this
	 * @param args
	 */
	public static void main(String[] args){
		String fileName = args[0];
		String[] originalArray = readFromFile(fileName);
		System.out.println("the array has length " + originalArray.length + "\n");
		String[] newArray1 = originalArray.clone();
		String[] newArray2 = originalArray.clone();
		
		jumbleArray(newArray1);
		jumbleArray(newArray2);
		
		System.out.print("The original array is:\n");
		System.out.print(arrayToString(originalArray) + "\n");
		
		System.out.print("The frst jumbled array is:\n");
		System.out.print(arrayToString(newArray1) + "\n");
		System.out.print("The corresponding set is:\n");
		System.out.print(setToString(arrayToSet(newArray1))+"\n");
		
		System.out.print("The second jumbled array is:\n");
		System.out.print(arrayToString(newArray2) + "\n");
		System.out.print("The corresponding set is:\n");
		System.out.print(setToString(arrayToSet(newArray2)) + "\n");
		
		
		
		}
	
}
