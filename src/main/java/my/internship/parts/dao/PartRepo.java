package my.internship.parts.dao;


import my.internship.parts.model.Parts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.List;

//Репозиторий получающий данные из таблицы
@org.springframework.stereotype.Repository
public class PartRepo {

    String userName = "root";
    String password = "root";
    String connectionURL = "jdbc:mysql://localhost:3306/parts";

    @Autowired
    private SessionFactory sessionFactory;

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    @Transactional
    public List<Parts> GetParts() {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            return (List<Parts>) session.createSQLQuery("select * FROM parts").addEntity(Parts.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}