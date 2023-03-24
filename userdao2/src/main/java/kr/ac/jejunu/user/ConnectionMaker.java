package kr.ac.jejunu.user;


import java.sql.Connection;
import java.sql.SQLException;

// 자바에서 의존성은 new 다!
public interface ConnectionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException;

    Connection getConnection(String s, String jeju, String jejupw);
}
