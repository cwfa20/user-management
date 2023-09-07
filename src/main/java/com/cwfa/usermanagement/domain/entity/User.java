package com.cwfa.usermanagement.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @Column
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private LocalDate subscriptionDate;
    @Column
    private Integer articlesRead;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && dateOfBirth.equals(user.dateOfBirth) && subscriptionDate.equals(user.subscriptionDate) && articlesRead.equals(user.articlesRead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, dateOfBirth, subscriptionDate, articlesRead);
    }
}
