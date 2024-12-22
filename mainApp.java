package Dom.BookProject;

import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		while (choice != 8) {
			System.out.println("|--MyBookSystem--|");
			System.out.println();
			System.out.println("ch1:Add Book");
			System.out.println("ch2:Display Book");
			System.out.println("ch3:Delete Book");
			System.out.println("ch4:sort Book By Price");
			System.out.println("ch5:Sort Book By Rating");
			System.out.println("ch6:Serch Book By Id");
			System.out.println("ch7:Update Book");
			System.out.println("ch8: Exit");
			choice = input.nextInt();
			switch (choice) {
			case 1: {

				System.out.println("Enter book id");
				int bid = input.nextInt();
				input.nextLine();
				System.out.println("Enter book name");
				String bname = input.nextLine();
				System.out.println("Enter price");
				double price = input.nextDouble();
				input.nextLine();
				System.out.println("Enter author name");
				String Aname = input.nextLine();
				System.out.println("Eneter Rating");
				float rating = input.nextFloat();
				BookOperations.addBook(bid, bname, Aname, price, rating);
				break;
			}
			case 2: {
				BookOperations.Display_Book();
				break;
			}
			case 3: {
				System.out.println("Enter the book id you wann delete ");
				int Bookid = input.nextInt();
				BookOperations.DeleteBook(Bookid);
				break;
			}
			case 4: {
				BookOperations.SortBookByPrice();
				break;
			}
			case 5: {
				BookOperations.SortByrating();
				break;
			}
			case 6: {
				System.out.println("Enter id Of the book you wann serch");
				int bid = input.nextInt();
				BookOperations.SerchBook(bid);
				break;
			}
			case 7: {
				System.out.println("Enter Book id you wann Update");
				int bid = input.nextInt();
				BookOperations.UpdateBook(bid);
				break;
			}
			case 8: {
				BookOperations.connection();
				System.out.println("Thankyou !!");
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}

		}
		System.out.println("!-Exit Successfully-!");
		input.close();
	}
}
