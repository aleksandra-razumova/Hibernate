package services;

import dao.AuthorDao;
import models.Author;
import models.Book;

import java.util.List;
//Service — слой данных в приложении, отвечающий за выполнение бизнес-логики.
public class AuthorService {
    private AuthorDao authorsDao = new AuthorDao();

    public AuthorService() {
    }

    public Author findUser(int id) {
        return authorsDao.findById(id);
    }

    public void saveAuthor(Author author) {
        authorsDao.save(author);
    }

    public void deleteAuthor(Author author) {
        authorsDao.delete(author);
    }

    public void updateAuthor(Author author) {
        authorsDao.update(author);
    }

    public List<Author> findAllUsers() {
        return authorsDao.findAll();
    }

    public Book findBookById(int id) {
        return authorsDao.findBookById(id);
    }

}
