package com.infoshareacademy.zieloni.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "selectAllStatistics", query = "from Statistic"),
        @NamedQuery(name = "getStatisticsByLogin", query = "from Statistic s  where s.user.login=:login"),
        @NamedQuery(name = "updateStatistic", query = "update Statistic s set s.editUserCounter = s.editUserCounter+1  where  s.user.id=:id")
})

public class Statistic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column
    private int editUserCounter;

}
