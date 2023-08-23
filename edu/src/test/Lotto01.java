package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto01 {
    public static void main(String[] args) {
        int numberOfTickets = 10; // 생성할 복권의 개수

        for (int i = 1; i <= numberOfTickets; i++) {
            List<Integer> ticketNumbers = generateTicketNumbers(5); // 5개의 숫자를 가진 복권 생성
            List<Integer> winningNumbers = generateTicketNumbers(5); // 5개의 숫자를 가진 당첨 번호 생성

            System.out.println("복권 " + i + ": " + ticketNumbers);
            System.out.println("당첨 번호: " + winningNumbers);

            int matchingNumbers = countMatchingNumbers(ticketNumbers, winningNumbers);
            System.out.println("일치하는 숫자 수: " + matchingNumbers);
            System.out.println();
        }
    }

    // n개의 숫자를 가진 복권 생성
    public static List<Integer> generateTicketNumbers(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // 숫자 섞기
        return numbers.subList(0, n);
    }

    // 복권과 당첨 번호에서 일치하는 숫자 수 계산
    public static int countMatchingNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
