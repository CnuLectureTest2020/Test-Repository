package hw_02;

public class HowMany {
	
	public int[] s_Alphabet = new int[26];
	public int[] b_Alphabet = new int[26];
	
	public void search(String string) {
		for(int i=0; i<string.length(); i++) {
			if((int)string.charAt(i)>=65&&(int)string.charAt(i)<=90)
				s_Alphabet[(int)string.charAt(i)-65]++;
			if((int)string.charAt(i)>=97&&(int)string.charAt(i)<=122)
				b_Alphabet[(int)string.charAt(i)-97]++;
		}
	}
	
	public void print() {
		for(int i=0; i<s_Alphabet.length; i++)
			System.out.print((char)(65+i)+":"+s_Alphabet[i]+"  ");
		System.out.println();
		for(int i=0; i<b_Alphabet.length; i++)
			System.out.print((char)(97+i)+":"+b_Alphabet[i]+"  ");
		System.out.println();
		System.out.print("가장 많이 나온 알파벳 >> ");
		max();
	}
	
	private void max() {
		int max1 = 0;
		int max2 = 0;
		
		for(int i=1; i<s_Alphabet.length; i++)
			if(s_Alphabet[max1]<s_Alphabet[i])
				max1 = i;
		for(int i=1; i<b_Alphabet.length; i++)
			if(b_Alphabet[max2]<b_Alphabet[i])
				max2 = i;
		
		if(s_Alphabet[max1]>b_Alphabet[max2])
			System.out.println((char)(65+max1)+":"+s_Alphabet[max1]);
		else
			System.out.println((char)(97+max2)+":"+b_Alphabet[max2]);
	}
	
	public static void main(String args[]) {
		HowMany hw1 = new HowMany();
		HowMany hw2 = new HowMany();		
		System.out.println("test1문장 삽입 결과 :");
		
		String string = "he United States is prepared to offer North Korea security assurances "
				+ "and bountiful private investment if it makes the strategic choice "
				+ "to give up its nuclear weapons, U.S. Secretary of State Mike Pompeo "
				+ "pledged Sunday.The U.S. price for normalization ― complete, verifiable and "
				+ "irreversible denuclearization ― is one Pyongyang has never before been "
				+ "willing to pay, seeing nuclear weapons as the ultimate guarantee of "
				+ "the regime's survival.But both countries have been on charm offensives "
				+ "ahead of the summit June 12 in Singapore between Donald Trump and "
				+ "Kim Jong Un, the first ever between a sitting US president "
				+ "and a North Korean leader. On Saturday, North Korea said it "
				+ "will destroy its nuclear test site later this month ― a gesture Trump quickly "
				+ "hailed as \"very smart and gracious.\"Pompeo, who has met "
				+ "twice with Kim, described him as well-informed and attuned to "
				+ "western media coverage, a leader \"who knows his brief\" and "
				+ "what he wants to achieve.";
		hw1.search(string);
		hw1.print();
		
		System.out.println("\ntest2문장 삽입 결과 :");
		string = "\"North Korea has a very extensive program. It won't be easy to do,"
				+ "\" Bolton said on ABC's \"This Week.\" \"They'll have to reveal all locations. "
				+ "Open inspections. The deconstruction of the nuclear weapons, I think, "
				+ "will be by the United States with perhaps assistance from others."
				+ "\"He suggested that could be done at the US nuclear weapons facilities "
				+ "at Oak Ridge, Tennessee.Bolton said the US side also will discuss not "
				+ "just North Korea's nuclear and missile programs but its chemical "
				+ "and biological weapons arsenal as well."
				+ "\"I don't think the president has stars in his eyes,\" Bolton said. "
				+ "\"What we need to see from Kim Jong Un is that he and the entire "
				+ "North Korean regime have made a strategic decision that they'll "
				+ "be better off without weapons of mass destruction.";
		hw2.search(string);
		hw2.print();
	}
}
