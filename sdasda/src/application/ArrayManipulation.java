package application;

public class ArrayManipulation {
	
	

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
		//extend array, so edges can be done
		int [][] extarray= ArrayGen.extendArray(arr);
		//smoothing
		if(extarray.length>=3&&extarray[0].length>=3) {
			for(int i=1; i<extarray.length-1;i++) {
				for(int k=1; k<extarray[i].length-1;k++) {
					int avg=0;
					for(int p=-1; p<2; p++) {
						for(int q=-1; q<2; q++) {
							avg+=extarray[i+p][k+q];
						}
					}
					avg= (avg/9);
					extarray[i][k]= avg;
				}
			}
		}
		
		//cut extra edges off
		
		int [][] finalarray = ArrayGen.trimArray(extarray);
		
		return finalarray;
	}
	
	
	
}
