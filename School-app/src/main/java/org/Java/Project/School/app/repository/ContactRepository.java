package org.Java.Project.School.app.repository;

import org.Java.Project.School.app.models.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public  int saveMessage(Contacts contact){

        String sql = "INSERT INTO CONTACT_MSG(NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS,"
                +"CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),
                contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreateAt(),
                contact.getCreateBy());
    }
}
