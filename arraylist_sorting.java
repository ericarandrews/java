

public class arraylist_sorting {
	
	public static void selectionSort(int [] array)
	{
		int startScan, index, minIndex, minValue;
		System.out.println("testing");
		
		for (startScan = 0; startScan < (array.length-1); startScan++)
		{
			minIndex = startScan;
			minValue = array[startScan];
			for(index = startScan + 1; index < array.length; index++)
			{
				if(array[index] < minValue)
				{
					minValue = array[index];
					minIndex = index;
				}
			}
			array[minIndex] = array[startScan];
			array[startScan] = minValue;
			
		}
	}
	

}