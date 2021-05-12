package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "impresario")
public class Impresario {

    @Id
    @SequenceGenerator(name = "impresario_sequence", sequenceName = "impresario_sequence", initialValue = 13)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "impresario_sequence")
    private Long id_impresario;

    private String full_name;

    private int age;

    private String gender;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "impresarios")
    private final Set<Artist> artists = new HashSet<>();

    public Long getId_impresario() {
        return id_impresario;
    }

    public void setId_impresario(Long id_impresario) {
        this.id_impresario = id_impresario;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Impresario{" +
                "full_name='" + full_name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
