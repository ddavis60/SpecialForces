/**Class: ToArray
 *
 * @author Danielle's Group
 * Receives a 10 letter word and a message and adds them to a large array
 */
public class ToArray
{

	private String message;
	private String tenLetterWord;
	private int rows;

	public ToArray(String tenLetterWord, String message)
	{
		this.message = message.toUpperCase();
		this.tenLetterWord = tenLetterWord;
	}

	public int getRows()
	{
		return rows;
	}

	/**Method: bigArray()
	 *
	 * @return bigArray
	 * Adds Strings to a two dimensional array
	 */
	public String[][] bigArray()
	{
		NoBlanksOrPeriod fixItJesus = new NoBlanksOrPeriod(message);
		String newMessage = fixItJesus.noSpaces();
		rows = 1 + (newMessage.length() / 10);
		String[][] bigArray = new String[rows][10];
		char[] tenWord = tenLetterWord.toCharArray();

		int count = 0;

		//Adds the 10 letter word first
		for(int i = 0; i < tenWord.length; i++)
		{
			bigArray[0][i] = Character.toString(tenWord[i]).toUpperCase();
		}

		//Adds the message
		for(int i = 1; i < rows; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				bigArray[i][j] = Character.toString(newMessage.charAt(count));
				count++;
			}
		}

		return bigArray;
	}
	// sorts characters of the first row of the array which in turn will sort the remaining characters of the row into columns.
	public String[][] sortByLetter(String array[][])
	{
		String[][] bigArray = bigArray();
		boolean pass = true;
		// first for-loop uses the first row of characters to compare to the characters of the other columns.
		for (int k = 1; k < 10 && pass; k++)
		{
			pass = false;
			//second for-loop uses the indexes compared up until the comparison of the middle two columns.
			for(int i = 0; i < 10 - k; i++)
			{

				if(bigArray[0][i].compareTo(bigArray[0][i+1]) > 0)
				{
					String[][] temp = new String[rows][1];
					// Uses created temp array to sort characters and put them in the right position in bigArray
					for(int j = 0; j < rows; j++)
					{
						temp[j][0] = bigArray[j][i];
						bigArray[j][i] = bigArray[j][i+1];
						bigArray[j][i+1] = temp[j][0];
					}
					pass = true;
				}
			}
		}
		return bigArray;
	}
	//
	public String toString(String[][] array)
	{
		String message = "";
		String spacedMessage = "";
		//
		for (int i = 0; i < 10; i++)
		{
			for(int j = 1; j < rows; j++)
			{
				message += array[j][i];
			}
		}
		// Adding Spaces to the message every five charcters and returns the meesage.
		for(int i = 0; i < message.length(); i = i + 5)
		{
			spacedMessage += message.substring(i, i + 5) + " ";
		}

		return spacedMessage;
	}

	/** Method: printArray
	 * @parm String[][] array
	 *
	 * prints the contents of the multidimensional array
	 */
	public static void printArray(String[][] array)
	{
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
