package iuh.fit.se.baitap1dataresource.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String firstName;
        private String lastName;
        private String gender;
        private String email;
        private String reemail;
        private String password;
        private String birthday;

        public User() {}

        public User(String firstName, String lastName, String gender, String email,
                    String password, String birthday, String reemail) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.email = email;
            this.password = password;
            this.birthday = birthday;
            this.reemail = reemail;
        }

        // Getter & Setter chuẩn
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getReemail() { return reemail; }
        public void setReemail(String reemail) { this.reemail = reemail; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public String getBirthday() { return birthday; }
        public void setBirthday(String birthday) { this.birthday = birthday; }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }


}
