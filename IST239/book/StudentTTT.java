// StudentTTT.java: Student class encapsulates student information
import java.io.*;

public class StudentTTT implements Serializable {
  private String name;
  private String street;
  private String city;
  private String state;
  private String zip;

  // Specify the size of five string fields in the record
  final static int NAME_SIZE = 32;
  final static int STREET_SIZE = 32;
  final static int CITY_SIZE = 20;
  final static int STATE_SIZE = 2;
  final static int ZIP_SIZE = 5;

  // the total size of the record in bytes, a Unicode
  // character is 2 bytes size
  final static int RECORD_SIZE =
    (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

  public StudentTTT() {
  }

  /** Construct a Student with specified name, street, city, state,
     and zip
    */
  public StudentTTT(String name, String street, String city,
    String state, String zip) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  /** Return name */
  public String getName() {
    return name;
  }

  /** Return street */
  public String getStreet() {
    return street;
  }

  /** Return city */
  public String getCity() {
    return city;
  }

  /** Return state */
  public String getState() {
    return state;
  }

  /** Return zip */
  public String getZip() {
    return zip;
  }

  /** Write a student to a data output stream */
  public void writeStudent(RandomAccessFile out) throws IOException {
    FixedLengthStringIO.writeFixedLengthString(
      name, NAME_SIZE, out);
    FixedLengthStringIO.writeFixedLengthString(
      street, STREET_SIZE, out);
    FixedLengthStringIO.writeFixedLengthString(
      city, CITY_SIZE, out);
    FixedLengthStringIO.writeFixedLengthString(
      state, STATE_SIZE, out);
    FixedLengthStringIO.writeFixedLengthString(
      zip, ZIP_SIZE, out);
  }

  /** Read a student from data input stream */
  public void readStudent(RandomAccessFile in) throws IOException {
    name = FixedLengthStringIO.readFixedLengthString(
      NAME_SIZE, in);
    street = FixedLengthStringIO.readFixedLengthString(
      STREET_SIZE, in);
    city = FixedLengthStringIO.readFixedLengthString(
      CITY_SIZE, in);
    state = FixedLengthStringIO.readFixedLengthString(
      STATE_SIZE, in);
    zip = FixedLengthStringIO.readFixedLengthString(
      ZIP_SIZE, in);
  }
}
