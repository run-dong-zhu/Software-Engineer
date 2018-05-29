package basic;

import basic.PrimeNumbers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BasicInputOutput {

	public static void main(String[] args) throws IOException {
		String filename = "my.txt";
		
		System.out.println("Please Enter a range from 0:");
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.next());
		input.close();
		
		PrimeNumbers.findPrimeNum(num);
		String data = PrimeNumbers.primeNum.toString();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(data);
		writer.close();
	}

}
