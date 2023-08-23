package mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigNumber_KJH {

	private static byte[] sort(byte[] arr) {

		int left = 0;
		int right = arr.length - 1;

		// 배열의 요소들을 뒤집어서 출력
		while (left < right) {
			byte temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
		return arr;
	}

	private static byte[] sum(byte[] arr1, byte[] arr2) {
		int maxLength = Math.max(arr1.length, arr2.length);
		byte[] result = new byte[maxLength];

		int carry = 0; // 다음 자릿수로의 올림을 저장

		for (int i = 0; i < maxLength; i++) {
			int sum = carry; // 이전 자릿수에서의 올림을 더해줌

			if (i < arr1.length) {
				sum += arr1[i];
			}

			if (i < arr2.length) {
				sum += arr2[i];
			}

			carry = sum / 10; // 다음 자릿수로의 올림 계산
			sum %= 10; // 10을 나눈 나머지 저장

			result[i] = (byte) sum;
		}

		if (carry > 0) {
			result[maxLength] = (byte) carry;
		}
		return result;
	}
	
	private static void printArr(byte[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("BigNumber.txt"));

			String line = br.readLine();
			String[] numbers = line.split(" "); // 공백을 기준으로 분리된 숫자들

			if (numbers.length != 2) {
				System.out.println("File format error: Expected two numbers separated by a space.");
				br.close();
				return;
			}

			int num1 = Integer.parseInt(numbers[0]);
			int num2 = Integer.parseInt(numbers[1]);

			br.close();

			// 분리된 숫자들 출력 (테스트용)
			System.out.println("num1: " + num1);// num1: 12345
			System.out.println("num2: " + num2);// num2: 6789

			// 정수를 문자열로 변환하여 각 자리 숫자를 분리
			String numberStr1 = Integer.toString(num1);
			String numberStr2 = Integer.toString(num2);

			byte[] byteArray1 = new byte[numberStr1.length()];
			byte[] byteArray2 = new byte[numberStr2.length()];

			// 문자열을 순회하며 각 숫자를 byte 배열로 저장
			for (int i = 0; i < numberStr1.length(); i++) {
				byteArray1[i] = (byte) (numberStr1.charAt(i) - '0');// 문자 '0'은 아스키코드 48이며, 문자 '1'은 아스키코드 49
			}

			for (int i = 0; i < numberStr2.length(); i++) {
				byteArray2[i] = (byte) (numberStr2.charAt(i) - '0');
			}

			sort(byteArray1);
			sort(byteArray2);

			printArr(byteArray1);// 5 4 3 2 1
			printArr(byteArray2);// 9 8 7 6
			
			byte[] result = sum(byteArray1, byteArray2);
			
			printArr(result);// 4 3 1 9 1
			sort(result);
			System.out.println("=".repeat(10));
			printArr(result);// 1 9 1 3 4
			System.out.println("=".repeat(10));

		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error parsing numbers from the file.");
			e.printStackTrace();
		}

	}

}
