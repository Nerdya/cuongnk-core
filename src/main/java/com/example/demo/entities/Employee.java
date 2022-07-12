package com.example.demo.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;

/**
 * @author cuongnk
 * @created_date 12/07/2022
 */
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;

}
