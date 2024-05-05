package org.example;

import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Query
//        List<Author> authors = QueryUtil.findAllAuthor(session);
//        for (Author author : authors) {
//            System.out.println(author);
//        }

//        // Insert
//        Author newAuthor = new Author("New Author", "1234 Main St", "http://www.newauthor.com");
//        QueryUtil.addAuthor(session, newAuthor);

        session.getTransaction().commit();
        session.close();

        System.out.println("Author queried");
    }
}