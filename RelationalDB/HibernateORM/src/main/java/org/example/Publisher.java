package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "URL")
    private String url;

    // Constructors
    public Publisher() {
    }

    public Publisher(String name, String address, String phone, String url) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        setUrl(url); // Ensure URL validation on setting
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        // Validate URL format
        if (url != null && (url.startsWith("http://") || url.startsWith("https://"))) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("URL must start with http:// or https://");
        }
    }

    // toString method for printing
    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
