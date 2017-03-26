package model;

import javax.persistence.*;

/**
 * Created by ud on 18/3/17.
 */

@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private  String lastName;

    @Column(name = "SECTION")
    private String section;


    /*
    * One to One Mapping unidirectional
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn*/

    /**
     * OneToOne Mapping Bidirectional
     */

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Address address;

    public Student(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (getFirstName() != null ? !getFirstName().equals(student.getFirstName()) : student.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(student.getLastName()) : student.getLastName() != null)
            return false;
        return getSection() != null ? getSection().equals(student.getSection()) : student.getSection() == null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section='" + section + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getSection() != null ? getSection().hashCode() : 0);
        return result;
    }
}
