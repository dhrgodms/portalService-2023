package kr.ac.jejunu.user;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class UserDao {
    private final ConnectionMaker connectionMaker = new ConnectionMaker() {
        @Override
        public Connection getConnection() throws ClassNotFoundException, SQLException {
            return null;
        }

        @Override
        public Connection getConnection(String s, String jeju, String jejupw) {
            return null;
        }
    };

    public User findById(Long id) throws ClassNotFoundException, SQLException {
        // 데이터 어디에 있나? Mysql
        // jdbc driver 클래스 로딩
        // 커넥션 맺고
        Connection connection = connectionMaker.getConnection("jdbc:mysql://192.168.151.175/jeju", "jeju", "jejupw");
        // sql 만들고
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, password from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        // sql 실행
        //결과 실행하면
        ResultSet resultSet = preparedStatement.executeQuery();
        // 결과를 user에 잘 매핑하고요
        // 커서를 이동해서 결과를 매핑
        resultSet.next(); // 커서 이동하고
        User user = new User(); // 데이터 access
        User.setId(resultSet.getLong("id"));
        User.setName(resultSet.getString("name"));
        User.setPassword(resultSet.getString("password"));
        // 자원을 해지 (close 안해주면 캐시에 저장하고 있는 경우에 메모리 낭비하므로 명시적으로 해지하는 것이 필요하다)
        resultSet.close();
        preparedStatement.close();
        connection.close();
        // 결과를 리턴
        return user;
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        // localhost jeju => jeju/jejupw => userinfo
        // jdbc driver 클래스 로딩
        // 커넥션 맺고
        Connection connection = connectionMaker.getConnection("jdbc:mysql://192.168.151.175/jeju", "jeju", "jejupw");
        // sql 쿼리 만들고
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, password from userinfo values(?,?)",
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        // sql 실행
        //결과 실행하면
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        // 결과를 user에 잘 매핑하고요
        // 커서를 이동해서 결과를 매핑
        resultSet.next(); // 커서 이동하고
        User.setId(resultSet.getLong(1));
        // 자원을 해지 (close 안해주면 캐시에 저장하고 있는 경우에 메모리 낭비하므로 명시적으로 해지하는 것이 필요하다)
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }


    // 다른 오브젝트도 사용가능
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://192.168.151.175/jeju", "jeju", "jejupw");
    }
}