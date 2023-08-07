package mission;

import java.util.Scanner;

public class ExchangeMaster {

	private int[] bill = {50000, 10000, 5000, 1000};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Price: ");
		int price = sc.nextInt();
		
		ExchangeMaster countBill = new ExchangeMaster();
		countBill.printBillCount(price);
	}
	
	void printBillCount(int price) {
		
		for (int i = 0; i < bill.length; i++) {
			int cnt = price / bill[i];
			price %= bill[i];
			System.out.println(bill[i] + "원권: " + cnt + "장");
		}
	}
}
