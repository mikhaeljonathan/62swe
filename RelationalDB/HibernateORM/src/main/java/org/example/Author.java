package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "URL")
    private String url;

    // Constructors
    public Author() {
    }

    public Author(String name, String address, String url) {
        this.name = name;
        this.address = address;
        this.url = url;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // toString method for printing
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
