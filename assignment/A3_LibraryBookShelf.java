import java.util.Arrays;

/**
 * Week 11 Assignment 3 - The Library Book Shelf (insertion sort, prints after each book is placed)
 */
public class A3_LibraryBookShelf {

    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int newBook = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];   // move bigger books one place right
                j--;
            }
            books[j + 1] = newBook;        // drop the new book into the gap
            System.out.println("After placing " + newBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        shelf(new int[]{30, 10, 40, 20});
        System.out.println();
        System.out.println("My own test:");
        shelf(new int[]{5, 4, 3, 2, 1});
    }
}
