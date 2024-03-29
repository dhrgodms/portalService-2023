package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatementStrategy implements StatementStrategy {
    private final User user;

    public InsertStatementStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        // query 실행 (insert 용으로 수정!!)
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (name, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement;
    }
}
