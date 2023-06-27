package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    //    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne //멤버 입장에서는 Many고 Team입장에서는 One이기 떄문이다.
    @JoinColumn(name = "TEAM_ID")
    private Team team;


}
