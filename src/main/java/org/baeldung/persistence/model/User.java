package org.baeldung.persistence.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String tel;

    @Column(length = 60)
    private String password;

    private boolean enabled;

    private boolean isUsing2FA;

    private String secret;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
                .append(lastName).append(", email=").append(email).append(", password=").append(password)
                .append(", enabled=").append(enabled).append(", isUsing2FA=")
                .append(isUsing2FA).append(", secret=").append(secret).append(", roles=").append(roles).append("]");
        return builder.toString();
    }

}