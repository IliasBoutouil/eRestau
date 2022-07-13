package com.example.eRestaurant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EClient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private Set<ECommand> commands= new HashSet<>();
    public  EClient(String fullName)
    {
        this.fullName=fullName;
    }
}
