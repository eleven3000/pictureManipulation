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
	

	public static MyRGB[][] smoothArray(MyRGB[][] arr) {
		MyRGB[][] array=arr;
		if(array.length>=3&&array[0].length>=3) {
			for(int i=1; i<array.length-1;i++) {
				for(int k=1; k<array[i].length-1;k++) {
					int avgr=0;
					int avgg=0;
					int avgb=0;
					for(int p=-1; p<2; p++) {
						for(int q=-1; q<2; q++) {
							avgr+=array[i+p][k+q].getR();
							avgg+=array[i+p][k+q].getG();
							avgb+=array[i+p][k+q].getB();
						}
					}
					avgr= (avgr/9);
					avgg= (avgg/9);
					avgb= (avgb/9);
					array[i][k].setR(avgr);
					array[i][k].setG(avgg);
					array[i][k].setB(avgb);
				}
			}
		}
		return array;
	}
	
	
	
	public static int[][] smoothArray(int[][] arr) {
		int [][] array=arr;
		if(array.length>=3&&array[0].length>=3) {
			for(int i=1; i<array.length-1;i++) {
				for(int k=1; k<array[i].length-1;k++) {
					int avg=0;
					for(int p=-1; p<2; p++) {
						for(int q=-1; q<2; q++) {
							avg+=array[i+p][k+q];
						}
					}
					avg= (avg/9);
					array[i][k]= avg;
				}
			}
		}
		return array;
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
