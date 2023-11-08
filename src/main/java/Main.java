import models.Author;
import models.Book;
import services.AuthorService;

import java.sql.SQLException;

public class Main {
        public static void main(String[] args) throws SQLException {

            AuthorService authorService = new AuthorService();
            Author author = new Author("Анна","Ахматова");
            authorService.saveAuthor(author);
            Book lirycs = new Book("Лирика", 224);
            lirycs.setAuthor(author);
            author.addBook(lirycs);
            Book requiem = new Book ("Реквием", 72);
            requiem.setAuthor(author);
            author.addBook(requiem);
            authorService.updateAuthor(author);

            for (int i =0; i< author.getBooks().size(); i++){
                System.out.println(author.getBooks().get(i));
            }
            System.out.println(lirycs.getAuthor());
        }
}
