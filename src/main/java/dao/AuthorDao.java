package dao;

import models.Author;
import models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

//DAO (data access object) — один из наиболее распространенных паттернов проектирования, "Доступ к данным".
//Его смысл прост — создать в приложении слой, который отвечает только за доступ к данным, и больше ни за что.
//Достать данные из БД, обновить данные, удалить данные — и все.
public class AuthorDao {
    public Author findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Author.class, id);
    }

    public void save(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(author);
        tx1.commit();
        session.close();
    }

    public void update(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(author);
        tx1.commit();
        session.close();
    }

    public void delete(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(author);
        tx1.commit();
        session.close();
    }

    public Book findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class, id);
    }

    public List<Author> findAll() {
        List<Author> authors = (List<Author>)  HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Author").list();
        return authors;
    }
}
