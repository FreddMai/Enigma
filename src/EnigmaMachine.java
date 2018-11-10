import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EnigmaMachine {

	public static void main(String[] args) {
		
		initEnigma();
		
	}
	
	public static void initEnigma() {
		
		Scanner sc = new Scanner(System.in);
		String rot1, rot2, rot3, plug, ringSet1, ringSet2, ringSet3, ringOff1, ringOff2, ringOff3, decryptWord;
		int tmp = 0, rotor1, rotor2, rotor3;
		PlugBoard plugBoard;
		
		System.out.println("Welcome to the Enigma M3.");
		System.out.println("Please choose which three rotors you would like to use: (1-5)");
		
		do{
			System.out.println("Please choose the first rotor:");
			rot1 = sc.nextLine();
			try {
			tmp = Integer.parseInt(rot1);
			} catch (NumberFormatException e) {
				System.out.println("Not a good choise, I'll take rotor 1 for you.");
				rotor1 = 1;
				tmp = 1;
				continue;
				}
			rotor1 = tmp;
			
		}while(tmp < 0 || tmp > 5);
		
		tmp = 0;
		
		do{
			System.out.println("Please choose the second rotor: (should be different than the first one)");
			rot2 = sc.nextLine();
			try {
			tmp = Integer.parseInt(rot2);
		} catch (NumberFormatException e) {
			System.out.println("Not a good choise, I'll take rotor 2 for you.");
			rotor2 = 2;
			tmp = 2;
			continue;
			}
		rotor2 = tmp;
			
		}while(tmp < 0 || tmp > 5 || tmp == Integer.parseInt(rot1));
		
		tmp = 0;
		
		do{
			System.out.println("Please choose the third rotor: (should be different than the first and the second)");
			rot3 = sc.nextLine();
			try {
			tmp = Integer.parseInt(rot3);
		} catch (NumberFormatException e) {
			System.out.println("Not a good choise, I'll take rotor 3 for you.");
			rotor3 = 3;
			tmp = 3;
			continue;
			}
		rotor3 = tmp;
			
		}while(tmp < 0 || tmp > 5 || tmp == Integer.parseInt(rot2) || tmp == Integer.parseInt(rot1));
		
		tmp = 0;
		
		System.out.println("Please choose the ring setting: (A-Z)");
		
		do{
			System.out.println("Please choose the ring setting for the first rotor:");
			ringSet1 = sc.nextLine();
			
		}while(ringSet1.charAt(0) < 'A' || ringSet1.charAt(0) > 'Z' || ringSet1.length() != 1);
		
		do{
			System.out.println("Please choose the ring setting for the second rotor:");
			ringSet2 = sc.nextLine();
			
		}while(ringSet1.charAt(0) < 'A' || ringSet2.charAt(0) > 'Z' || ringSet2.length() != 1);
		
		do{
			System.out.println("Please choose the ring setting for the third rotor:");
			ringSet3 = sc.nextLine();
			
		}while(ringSet3.charAt(0) < 'A' || ringSet3.charAt(0) > 'Z' || ringSet3.length() != 1);
		
		System.out.println("Please choose the ring offsets: (A-Z)");
		
		do{
			System.out.println("Please choose the ring offset for the first rotor:");
			ringOff1 = sc.nextLine();
			
		}while(ringOff1.charAt(0) < 'A' || ringOff1.charAt(0) > 'Z' || ringOff1.length() != 1);
		
		do{
			System.out.println("Please choose the ring offset for the second rotor:");
			ringOff2 = sc.nextLine();
			
		}while(ringOff1.charAt(0) < 'A' || ringOff2.charAt(0) > 'Z' || ringOff2.length() != 1);
		
		do{
			System.out.println("Please choose the ring offset for the third rotor:");
			ringOff3 = sc.nextLine();
			
		}while(ringOff3.charAt(0) < 'A' || ringOff3.charAt(0) > 'Z' || ringOff3.length() != 1);
		
		Rotor rotors[] = new Rotor[3];
		
		if(rotor1 == 1) {
			
			rotors[0] = new Rotor(letterToIndex(ringOff1.charAt(0)), letterToIndex(ringSet1.charAt(0)), makeList("EKMFLGDQVZNTOWYHXUSPAIBRCJ"), 17);
			
		}
		
		else if(rotor2 == 1) {
			
			rotors[1] = new Rotor(letterToIndex(ringOff2.charAt(0)), letterToIndex(ringSet2.charAt(0)), makeList("EKMFLGDQVZNTOWYHXUSPAIBRCJ"), 17);
			
		}
		
		else if(rotor3 == 1) {
			
			rotors[2] = new Rotor(letterToIndex(ringOff3.charAt(0)), letterToIndex(ringSet3.charAt(0)), makeList("EKMFLGDQVZNTOWYHXUSPAIBRCJ"), 17);
			
		}
		
		if(rotor1 == 2) {
			
			rotors[0] = new Rotor(letterToIndex(ringOff1.charAt(0)), letterToIndex(ringSet1.charAt(0)), makeList("AJDKSIRUXBLHWTMCQGZNPYFVOE"), 5);
			
		}
		
		else if(rotor2 == 2) {
			
			rotors[1] = new Rotor(letterToIndex(ringOff2.charAt(0)), letterToIndex(ringSet2.charAt(0)), makeList("AJDKSIRUXBLHWTMCQGZNPYFVOE"), 5);
			
		}
		
		else if(rotor3 == 2) {
			
			rotors[2] = new Rotor(letterToIndex(ringOff3.charAt(0)), letterToIndex(ringSet3.charAt(0)), makeList("AJDKSIRUXBLHWTMCQGZNPYFVOE"), 5);
			
		}
		
		if(rotor1 == 3) {
			
			rotors[0] = new Rotor(letterToIndex(ringOff1.charAt(0)), letterToIndex(ringSet1.charAt(0)), makeList("BDFHJLCPRTXVZNYEIWGAKMUSQO"), 22);
			
		}
		
		else if(rotor2 == 3) {
			
			rotors[1] = new Rotor(letterToIndex(ringOff2.charAt(0)), letterToIndex(ringSet2.charAt(0)), makeList("BDFHJLCPRTXVZNYEIWGAKMUSQO"), 22);
			
		}
		
		else if(rotor1 == 3) {
			
			rotors[2] = new Rotor(letterToIndex(ringOff3.charAt(0)), letterToIndex(ringSet3.charAt(0)), makeList("BDFHJLCPRTXVZNYEIWGAKMUSQO"), 22);
			
		}
		
		if(rotor1 == 4) {
			
			rotors[0] = new Rotor(letterToIndex(ringOff1.charAt(0)), letterToIndex(ringSet1.charAt(0)), makeList("SOVPZJAYQUIRHXLNFTGKDCMWB"), 10);
			
		}
		
		else if(rotor2 == 4) {
			
			rotors[1] = new Rotor(letterToIndex(ringOff2.charAt(0)), letterToIndex(ringSet2.charAt(0)), makeList("SOVPZJAYQUIRHXLNFTGKDCMWB"), 10);
			
		}
		
		else if(rotor3 == 4) {
			
			rotors[2] = new Rotor(letterToIndex(ringOff3.charAt(0)), letterToIndex(ringSet3.charAt(0)), makeList("SOVPZJAYQUIRHXLNFTGKDCMWB"), 10);
			
		}
		
		if(rotor1 == 5) {
			
			rotors[0] = new Rotor(letterToIndex(ringOff1.charAt(0)), letterToIndex(ringSet1.charAt(0)), makeList("VZBRGITYUPSDNHLXAWMJQOFECK"), 26);
			
		}
		
		else if(rotor2 == 5) {
			
			rotors[1] = new Rotor(letterToIndex(ringOff2.charAt(0)), letterToIndex(ringSet2.charAt(0)), makeList("VZBRGITYUPSDNHLXAWMJQOFECK"), 26);
			
		}
		
		else if(rotor3 == 5) {
			
			rotors[2] = new Rotor(letterToIndex(ringOff3.charAt(0)), letterToIndex(ringSet3.charAt(0)), makeList("VZBRGITYUPSDNHLXAWMJQOFECK"), 26);
			
		}
		
		do{
			System.out.println("Please choose your plugboard:");
			plug = sc.nextLine();
			
		}while(!checkPlug(plug));
		
		plugBoard = new PlugBoard(makeList(plug));
		
		/*Rotor rotr1 = new Rotor(19, 19, makeList("EKMFLGDQVZNTOWYHXUSPAIBRCJ"), 17);
		Rotor rotr2 = new Rotor(3, 19, makeList("AJDKSIRUXBLHWTMCQGZNPYFVOE"), 5);
		Rotor rotr3 = new Rotor(9, 6, makeList("BDFHJLCPRTXVZNYEIWGAKMUSQO"), 22);
		Rotor rotr4 = new Rotor(14, 24, makeList("ESOVPZJAYQUIRHXLNFTGKDCMWB"), 10);
		Rotor rotr5 = new Rotor(15, 9, makeList("VZBRGITYUPSDNHLXAWMJQOFECK"), 26);*/
		
		Reflector reflector = new Reflector(makeList("YRUHQSLDPXNGOKMIEBFZCWVJAT"));
		
		//plugBoard = new PlugBoard(makeList("ZU HL CQ WM OA PY EB TR DN VI"));

		/*Rotor rotors[] = new Rotor[3];
		rotors[0] = rotr2;
		rotors[1] = rotr5;
		rotors[2] = rotr4;*/
		
		System.out.println("Please choose the word you would like to decrypt:");
		decryptWord = sc.nextLine();
		
		Enigma enigmaMachine = new Enigma(rotors, reflector, plugBoard);
		
		System.out.println("The decrypted word: " + enigmaMachine.encryptOrDecrypt(makeList(decryptWord)));
		
	}
	
	public static List<Character> makeList(String str){
		
		List<Character> list = new ArrayList<Character>();

		if(str.length() == 0) {
			return list;
		
		}
		
		for(char c: str.toCharArray())
			list.add(c);
		return list;
		
	}
	
    public static int letterToIndex(char letter){
    	
        return (int) (Character.toUpperCase(letter)) - (int)('A');
        
    }
    
    public static boolean checkPlug(String str) {
    	
    	if(!checkLetrAndSpace(str) || !checkDupl(str))
    		return false;
    		
    	str = str.replaceAll("\\s", "");
    	if(str.length() > 20)
    		return false;
    	
    	char[] tmpStr = str.toCharArray();
    	for(char c: tmpStr) {
    		
    		if(!Character.isLetter(c) || !Character.isUpperCase(c))
    			return false;
    		
    	}
    	
    	return true;
    	
    }
    
    public static boolean checkLetrAndSpace(String str) {
    	
    	int count = 0;
    	for(int i = 0; i < str.length(); i++) {
    		
    		if(str.charAt(i) != ' ')
    			count++;
    		
    		if((str.charAt(i) == ' ' || i == str.length() - 1 || i == 1) && (count != 2))
    			return false;
    		
    		if(str.charAt(i) == ' ')
    			count = 0;
    		
    	}
    	
    	return true;
    	
    }
    
    public static boolean checkDupl(String str) {
    	
    	int flag = 0;
    	for(int i = 0; i < str.length(); i++) {
    		
    		int index = str.charAt(i) - 'A';
    		if((flag & (1 << index)) > 0)
    			return false;
    		
    		flag = flag | (1 << index);
    		
    	}
    	
    	return true;
    	
    }

}
