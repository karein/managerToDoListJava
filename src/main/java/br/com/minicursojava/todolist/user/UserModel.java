package br.com.minicursojava.todolist.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {

  @Id
  private UUID id;

  private String name;
  private String username;
  private String password;
}
