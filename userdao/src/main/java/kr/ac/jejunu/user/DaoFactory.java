package kr.ac.jejunu.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration // Bean을 정의한다는 의미의 configuration annotation
public class DaoFactory {

    //환경변수로 dependency를 받음 -> 모든 dependency를 제거했다
    @Value("${db.classname}") // 환경변수 받음
    private String className;
    @Value("${db.url}") // 환경변수 받음
    private String url;
    @Value("${db.username}") // 환경변수 받음
    private String username;
    @Value("${db.password}") // 환경변수 받음
    private String password;

    @Bean // new 를 해주는 (dependency를 담아서 객체를 반환해주는 것) 인스턴스
    public UserDao userDao() throws ClassNotFoundException {
        UserDao userDao = new UserDao(dataSource());
        return userDao;

    }
    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
