package exception;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ZeroException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n==0){
            throw new ZeroException("На ноль делить нельзя");
        }
        System.out.println(10/4);



    }

}