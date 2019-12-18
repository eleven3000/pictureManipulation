package application;

public class ArrayGen {
	
	
	public static MyRGB[][] fillRGB(int size){
		MyRGB[][] array = new MyRGB[size][size];
		for(int i= 0; i< array.length;i++) {
			for(int k= 0; k < array[i].length; k++) {
				array[i][k] = new MyRGB((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
			}
		}
		return array;
	}
	
	
	
	
	public static int[][] randomSquareArray(int size) {
		return fillArray(255, new int[size][size]);
	}
	private static int[][] fillArray(int upperBound, int[][] array) {
		for(int i= 0; i< array.length;i++) {
			for(int k= 0; k < array[i].length; k++) {
				array[i][k] =(int) (Math.random()*upperBound);
			}
		}
		return array;
	}
	
	
	public static int[][] extendArray(int[][] array){
		int[][] newarray = new int[array.length+2][array.length+2];
		
		//copy middle part
		for(int i= 0; i< array.length;i++) {
			for(int k= 0; k < array[i].length; k++) {
				newarray[i+1][k+1] = array[i][k];
			}
		}
		//fill edges
		for(int k= 1; k<array.length+1; k++) {
			newarray[0][k] = array[0][k-1];
		}
		for(int k= 1; k<array.length+1; k++) {
			newarray[newarray.length-1][k] = array[array.length-1][k-1];
		}
		for(int i= 1; i<array.length+1; i++) {
			newarray[i][0] = array[i-1][0];
		}
		for(int i= 1; i<array.length+1; i++) {
			newarray[i-1][newarray.length-1] = array[i-1][array.length-1];
		}
		//fill corners
		newarray[0][0] = (newarray[1][0] +newarray[0][1])/2;
		newarray[newarray.length-1][0] = (newarray[newarray.length-2][0] +newarray[newarray.length-1][1])/2;
		newarray[0][newarray.length-1] = (newarray[1][newarray.length-1] +newarray[0][newarray.length-2])/2;
		newarray[newarray.length-1][newarray.length-1] = (newarray[newarray.length-1][newarray.length-2] +newarray[newarray.length-2][newarray.length-1])/2;
		
		//return
		return newarray;
		
	}
	
	public static int[][] trimArray(int[][] array){
		int[][] trimarray = new int[array.length-2][array.length-2];
		
		for(int i= 0; i< array.length-2;i++) {
			for(int k= 0; k < array[i].length-2; k++) {
				trimarray[i][k] = array[i+1][k+1];
			}
		}
		return trimarray;
	}
	
	public static void printArray(int[][] array) {
		String output="";
		for(int i= 0; i< array.length;i++) {
			for(int k= 0; k < array[i].length; k++) {
				output= output+"["+array[i][k]+"] ";
			}
			output= output +"\n";
		}
		System.out.println(output);
	}
	public static void printArray(MyRGB[][] array) {
		String output="";
		for(int i= 0; i< array.length;i++) {
			for(int k= 0; k < array[i].length; k++) {
				output= output+"[("+array[i][k].getR()+"), ("+array[i][k].getG()+"), ("+array[i][k].getB()+")] ";
			}
			output= output +"\n";
		}
		System.out.println(output);
	}
}
