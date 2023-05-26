package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    private final Integer id;

    public DeleteStatementStrategy(Integer id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        // query 실행
        PreparedStatement preparedStatement = connection.prepareStatement("delete from userinfo where id = ? ");
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
