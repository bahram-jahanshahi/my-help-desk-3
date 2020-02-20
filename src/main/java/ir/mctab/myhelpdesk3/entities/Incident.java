package ir.mctab.myhelpdesk3.entities;

import ir.mctab.myhelpdesk3.entities.security.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issue;

    private String description;

    private Date createDate;

    @ManyToOne
    private User submitBy;

    private String status;
}
