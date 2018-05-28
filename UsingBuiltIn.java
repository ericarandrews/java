import javax.swing.JOptionPane;
import java.util.Scanner;
import java.text.DecimalFormat;

public class UsingBuiltIn
{
	public static void main(String args[])
	{	
		int maleButterFlies, femaleButterFlies;
		int totalButterFlies, sexRatio, ratioVariance;
		int genderDifference, matingPairs;
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("\nButterFly Estimator: \n");
		System.out.print("Enter the estimated male butterfly population: ");
		maleButterFlies = stdin.nextInt();
		System.out.print("Enter the estimated female butterfly population: ");
		femaleButterFlies = stdin.nextInt();
		
		totalButterFlies = maleButterFlies + femaleButterFlies;
		sexRatio = maleButterFlies / femaleButterFlies;
		ratioVariance = maleButterFlies % femaleButterFlies;
		genderDifference = maleButterFlies - femaleButterFlies;
		matingPairs = maleButterFlies * femaleButterFlies;
		
		if(femaleButterFlies > maleButterFlies)
		{
			genderDifference = femaleButterFlies - maleButterFlies;
		}
		
		DecimalFormat threedec = new DecimalFormat("#.000");
		double growthFactor = Math.sqrt(matingPairs);
		double ratioFactor = 0;
		
		if(sexRatio != 0)
		{
			ratioFactor = (growthFactor/sexRatio);
		}
		
		DecimalFormat onedec = new DecimalFormat("#.0");
		if(sexRatio == 0)
		{
			ratioFactor = (Math.sqrt(ratioVariance));
		}
		
		DecimalFormat zero = new DecimalFormat("0");
		double potentialPopulation = Math.pow(2, (int)ratioFactor);
		
		System.out.println("\nTotal ButterFlies: " + totalButterFlies);
		System.out.println("Sex Ratio: " + sexRatio);
		System.out.println("Variance: " + ratioVariance);
		System.out.println("Gender Difference: " + genderDifference);
		System.out.println("Mating Pairs: " + matingPairs);
		System.out.println("Growth Factor: " + (threedec.format(growthFactor)));
		System.out.println("Ratio Factor: " + (onedec.format(ratioFactor)));
		System.out.println("Potential Population: " + (zero.format(potentialPopulation)));
		
//		String malePopulation = JOptionPane.showInputDialog("Enter the estimated male butterfly population: ");
//		maleButterFlies = Integer.parseInt(malePopulation);
//		String femalePopulation = JOptionPane.showInputDialog("Enter the estimated female butterfly population: ");
//		femaleButterFlies = Integer.parseInt(femalePopulation);
//		
//		JOptionPane.showMessageDialog(null, "\nTotal Butterflies: " + totalButterFlies);
//		JOptionPane.showMessageDialog(null, "\nSex Ratio: " + sexRatio);
//		JOptionPane.showMessageDialog(null, "\nVariance: " + ratioVariance);
//		JOptionPane.showMessageDialog(null, "\nGender Difference: " + genderDifference);
//		JOptionPane.showMessageDialog(null, "\nMating Pairs: " + matingPairs);
//		JOptionPane.showMessageDialog(null, "\nGrowth Factor: " + (threedec.format(growthFactor)));
//		JOptionPane.showMessageDialog(null, "\nRatio Factor: " + (onedec.format(ratioFactor)));
//		JOptionPane.showMessageDialog(null, "\nPotential Population: " + (zero.format(potentialPopulation)));
		
		
		//First run: Enter values 50 and 15; Output should be 65, 3, 5, 35, 750, 27.386, 9.1, and 512. 
		//Second run: Enter values 1 and 10; Output should be 11, 0, 1, 9, 10, 3.162, 1.0, and 2. 
		//Third run: Enter values 10 and 1; Output should be 11, 10, 0, 9, 10, 3.162, .3 and 1.      
	}
}

