package hiber.mvc.web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @NotEmpty(message = "Name should not be Empty")
   @Size(min = 2, max = 50, message = "Name should between 2 and 50 characters")
   @Column(name = "name")
   private String name;

   @Min(value = 0, message = "Age should be greater than 0")
   @Column(name = "age")
   private int age;

   @NotEmpty(message = "Email should not be Empty")
   @Email(message = "Email should be valid")
   @Column(name = "email")
   private String email;

   public User() {
   }

   public User(String name, int age, String email) {
      this.name = name;
      this.age = age;
      this.email = email;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}
