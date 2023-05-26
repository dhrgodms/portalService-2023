package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {
    // 메서드를 클래스 영역으로 확장해줘야 클래스 별로도 상속받아서 쓸 수 있음

    // 뭐가 들어올지 모른다  그러므로 여기서 또다시 추상화
    // 추상화 후 -> 그러나 추상화된 메서드밖에 존재하지 않는 => 인터페이스로 볼 수 있다~!
    // 인터페이스로 변경
    public Connection getConnection() throws ClassNotFoundException, SQLException;
//         mysql
//         driver 로딩
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // connection
//        return DriverManager.getConnection("jdbc:mysql://localhost/jeju", "jeju", "jejupw");
}