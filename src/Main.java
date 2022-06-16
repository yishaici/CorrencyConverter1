import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        String loopFlag = "Y";
        ArrayList<Double> list = new ArrayList<>();
        String filePath = "C:\\Users\\yishai cinnamon\\Downloads\\Players.csv";

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Welcome to currency converter");
        while (loopFlag.equals("Y")) {
            FileOutputStream writeData = new FileOutputStream("output1.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            System.out.println("Please choose an option 1/2: ");
            System.out.println("1: Dollars to Shekels");
            System.out.println("2: Shekels to Dollars");
            int input1 = scanner1.nextInt();
            try {
                if ( input1 != 1 &&  input1 != 2){
                    throw new Exception("Wrong input");
                }
            }catch (Exception e) {
                System.out.println("you need to choose an option 1/2 - Please try again");
                break;
            }
            System.out.println("pleas enter amount to convert");
            double input = scanner2.nextDouble();
            Coin coin;
            if (input1 == 1) {
                coin = CoinFactory.getCoinInstance(Coins.USD);
            } else {
                coin = CoinFactory.getCoinInstance(Coins.ILS);
            }
            double value = coin.calculate(input);
            // add to list
            list.add(value);
            writeStream.writeObject(list);
            writeStream.flush();
            Files.writeString(Paths.get(filePath),"hello world");
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
//                        System.out.println(content);
            System.out.println("Y/N");
            loopFlag = scanner3.next();
            try {
                if (!"Y".equals(loopFlag) && !"N".equals(loopFlag) ){
                    throw new Exception("Wrong input");
                }
            }catch (Exception e) {
                System.out.println("you need to choose an option Y/N - Please try again");
                break;
            }
            if  (loopFlag.equals("N")){
                System.out.println("Thanks for using our currency converter! ");
                System.out.println("your results is: " + "\n" +list);
                writeStream.close();
//                 System.out.println("μουν".getBytes("UTF-8").toString());
            }



        }}}
