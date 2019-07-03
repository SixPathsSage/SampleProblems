package edu.hiddenleafvillage;

public class StaircaseProblem {

	static int[] array = {1,2,3};
	public static void main(String[] args) {
		System.out.println(new StaircaseProblem().getSteps(5));
	}
	
	public int getSteps(int steps)
	{
		int total = 0;
		if(steps < 0)
		{
			return 0;
		}
		else if(steps == 0 || steps == 1)
		{
			return 1;
		}
		else 
		{
			for (int i = 0; i < array.length; i++) {
				total += getSteps(steps-array[i]);
			}
		}
		return total;
	}

}
