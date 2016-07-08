package test1;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by lenovo on 2016/6/16.
 */
public class ScannerTest {

    @Test
    public void show(){
        // junittest不支持Scanner对象，只能在main方法中打印
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s);
    }
}
