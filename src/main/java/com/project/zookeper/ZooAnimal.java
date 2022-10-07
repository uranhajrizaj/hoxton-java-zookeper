package com.project.zookeper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZooAnimal")
public class ZooAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String name;
    public String species;
    public String origin;
    public Boolean isHungry;

    public ZooAnimal(){

    }
}
