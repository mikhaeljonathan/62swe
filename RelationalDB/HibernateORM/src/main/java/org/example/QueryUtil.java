package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class QueryUtil {

    public static List<Book> findAllBooks(Session session) {
        String hql = "FROM Book";
        Query<Book> query = session.createQuery(hql, Book.class);
        return query.getResultList();
    }

    public static List<Author> findAllAuthor(Session session) {
        String hql = "FROM Author";
        Query<Author> query = session.createQuery(hql, Author.class);
        return query.getResultList();
    }

    public static void addAuthor(Session session, Author author) {
        try {
            session.save(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
