package dev.cathers.incidentapi.incident;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "INCIDENTS")
@EntityListeners(AuditingEntityListener.class)
public class Incident {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "AREA", nullable = false)
  private String area;
  @Column(name = "DATE", nullable = false)
  String date;
  @Column(name = "TIME", nullable = false)
  String time;
  @Column(name = "TYPE", nullable = false)
  private String type;
  @Column(name = "ADDRESS", nullable = false)
  private String address;
  @Column(name = "LOCATION", nullable = false)
  private String location;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
