package com.romczaj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "call_counter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallCounterEntity {

    @Id
    private String login;
    private Long requestCount;
}
