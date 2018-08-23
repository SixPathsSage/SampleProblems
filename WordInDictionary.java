package edu.hiddenleafvillage;

public class WordInDictionary {

	String[] dictionary = {"chennai", "covai", "madurai", "dubai"};
	public static void main(String[] args) {
		WordInDictionary wd = new WordInDictionary();
		String res = wd.getWords("c*i");
		System.out.println(res);
	}
	
	public String getWords(String text)
	{
		String op = "";
		boolean isStarEncountered = false;
		for (int i = 0; i < dictionary.length; i++) {
			String dWord = dictionary[i];
			int a = 0;
			int b = 0;
			if(op.length() > 0)
			{
				op += " ";
			}
			while(a < text.length() && b < dWord.length())
			{
				if(!isStarEncountered && text.charAt(a) == '*')
				{
					isStarEncountered = true;
					a++;
				}
				else if(text.charAt(a) == dWord.charAt(b))
				{
					isStarEncountered = false;
					op += text.charAt(a) + "";
					a++;
					b ++;
				}
				else if(isStarEncountered)
				{
					op += dWord.charAt(b) + "";
					b++;
				}
				else
				{
					break;
				}
			}
		}
		
		return op;
	}

}
