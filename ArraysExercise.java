import java.util.Scanner;

public class ArraysExercise
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		boolean menu = true;
		boolean check1 = false;
		boolean check2 = false;
		int menuOption = 0;	
		int[] array1 = new int[1];
		int[] array2 = new int[1];
		
		while (menu)
		{
			System.out.println("             ");
			System.out.println("----Menu:----");
			System.out.println("1. Create array one.");
			System.out.println("2. Create array two");
			System.out.println("3. Create and print sum of the arrays (third array).");
			System.out.println("4. Create and print ordered array. ");
			System.out.println("5. Exit");
			System.out.println("Type the number of the option you want to proceed with.");
			menuOption = input.nextInt();
			
			switch (menuOption)
			{
				case 1:
					System.out.println("---Create array 1:---");
					array1 = createArray(input);
					System.out.println("---First array created succesfully.---");
					check1 = true;
				break;
				
				case 2:
					System.out.println("---Create array 2:---");
					array2 = createArray(input);
					System.out.println("---Secund array created succesfully.---");
					check2 = true;
				break;
				
				case 3:
					if (check1 & check2)
					{
						sum(input, array1, array2);
					}
					else 
					{
						System.out.println("---You first need to create the two arrays.---");
					}
				break;
				
				case 4:
					if (check1 & check2)
					{
						orderedArrayGenerator(input, array1, array2);
					}
					else 
					{
						System.out.println("---You first need to create the two arrays.---");
					}
				break;
				default:
				if (menuOption == 5)
				{
					menu = false;
					System.out.println("Closing program...");
				}
				else 
				{
					System.out.println("Invalid option, please type a valid one");
				}
			}
		}		
	}

	public static int[] createArray(Scanner input)
	{
		boolean intValid = false;
		int arraySize = 0;
		int numberToCheck = 0;
		System.out.println("Type the size of the array");
		arraySize = input.nextInt();
		int[] array = new int[arraySize];
		for (int cont = 0; cont<arraySize ; cont++ )
		{
			intValid = false;
			while (intValid == false)
			{
				System.out.println("Type a number from 0 to 9 to include in array 1 position #" + cont);
				numberToCheck = input.nextInt();
				if (numberToCheck >=0 & numberToCheck<=9)
				{
					array[cont] = numberToCheck;
					intValid = true;
				}	
				else 
				{
					System.out.println("Please type a valid number.");
				}
			}
		}
		return array;
	}
	
	public static void sum(Scanner input, int[] array1, int[] array2)
	{
		String stringArray1 = "";
		String array1PositionValue = "";
		String stringArray2 = "";
		String array2PositionValue = "";
		String stringArray3 = "";
		int entArray1 = 0;
		int entArray2 = 0;
		int entArray3 = 0;
		int array3Length = 0;
		for (int cont = 0 ; cont<(array1.length) ; cont++)
		{
			array1PositionValue = Integer.toString(array1[cont]);
			stringArray1 = stringArray1 + array1PositionValue;
		}
		for (int cont = 0 ; cont<(array2.length) ; cont++)
		{
			array2PositionValue = Integer.toString(array2[cont]);
			stringArray2 = stringArray2 + array2PositionValue;
		}
		entArray1 = Integer.parseInt(stringArray1);
		entArray2 = Integer.parseInt(stringArray2);
		entArray3 = entArray1 + entArray2;//Resultado de la suma 
				
		stringArray3 = Integer.toString(entArray3);
		
		array3Length = stringArray3.length();
		int[] array3 = new int[array3Length];
		
		System.out.println("---The result of your sum expressed as an array is: --- ");		
		for (int cont = 0 ; cont<array3Length ; cont++)
		{
			array3[cont] = Character.getNumericValue(stringArray3.charAt(cont));
			System.out.printf(" " + array3[cont] + " ");
		}		
	}
	
	public static void orderedArrayGenerator(Scanner input, int[] array1, int[] array2)
	{
		int counter = 0;
		int numberCounter = 0;
		int startPositionSave = 0;
		int[] array4 = new int[(array1.length+array2.length)];
		for (counter = 0; counter < 10; counter++) //Ciclo para buscar los numeros de 0 a 9
		{
			for (int cont = 0 ; cont<array1.length ; cont++)//Cuenta el numero de aparaciones de un valor en el array1
			{
				if (array1[cont]==counter)		
				{
					numberCounter++;
				}
			}			
			for (int cont = 0 ; cont<array2.length ; cont++)//Cuenta el numero de aparaciones de un valor en el array2
			{
				if (array2[cont]==counter)		
				{
					numberCounter++;
				}				
			}
			for (int cont = (startPositionSave); cont < (startPositionSave + numberCounter); cont++)// Agrega el numero las veces que aparece en el arreglo 4.
			{
				if (startPositionSave == (startPositionSave+numberCounter))	{}
				else 
				{
					array4[cont] = counter;
				}
			}
				
			if (numberCounter > 0)//Evita que se pierda el guardado de la posicion en el arreglo.
			{
				startPositionSave = numberCounter + startPositionSave; //Se le suma la posicion ya guardada anteriormente.
			}
			numberCounter = 0;			
		}
		
		System.out.println("---The ordered array is: --- ");
		for (int cont = 0 ; cont<array4.length ; cont++)
		{
			System.out.printf(" " + array4[cont] + " ");
		}		 
	}
}