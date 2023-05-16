package com.mist.portal.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity(name = "Students")
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentEntity {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private int roll;
    private String name;
    private String password;
}
