/*
 * Spring Security 6+ APP
 * Spring Boot 3+ Spring Security 6+ example
 *
 * The version of the OpenAPI document: 0.0.1-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package localhost.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * RegisterRequest
 */
@JsonPropertyOrder({
  RegisterRequest.JSON_PROPERTY_FIRSTNAME,
  RegisterRequest.JSON_PROPERTY_LASTNAME,
  RegisterRequest.JSON_PROPERTY_EMAIL,
  RegisterRequest.JSON_PROPERTY_PASSWORD,
  RegisterRequest.JSON_PROPERTY_ROLE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-01-28T12:48:20.235073900+04:00[Asia/Dubai]", comments = "Generator version: 7.11.0")
public class RegisterRequest {
  public static final String JSON_PROPERTY_FIRSTNAME = "firstname";
  @jakarta.annotation.Nonnull
  private String firstname;

  public static final String JSON_PROPERTY_LASTNAME = "lastname";
  @jakarta.annotation.Nonnull
  private String lastname;

  public static final String JSON_PROPERTY_EMAIL = "email";
  @jakarta.annotation.Nonnull
  private String email;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  @jakarta.annotation.Nonnull
  private String password;

  /**
   * Gets or Sets role
   */
  public enum RoleEnum {
    ADMIN(String.valueOf("ADMIN")),
    
    USER(String.valueOf("USER"));

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ROLE = "role";
  @jakarta.annotation.Nonnull
  private RoleEnum role;

  public RegisterRequest() {
  }

  public RegisterRequest firstname(@jakarta.annotation.Nonnull String firstname) {
    
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_FIRSTNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFirstname() {
    return firstname;
  }


  @JsonProperty(JSON_PROPERTY_FIRSTNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFirstname(@jakarta.annotation.Nonnull String firstname) {
    this.firstname = firstname;
  }

  public RegisterRequest lastname(@jakarta.annotation.Nonnull String lastname) {
    
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LASTNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastname() {
    return lastname;
  }


  @JsonProperty(JSON_PROPERTY_LASTNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastname(@jakarta.annotation.Nonnull String lastname) {
    this.lastname = lastname;
  }

  public RegisterRequest email(@jakarta.annotation.Nonnull String email) {
    
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEmail(@jakarta.annotation.Nonnull String email) {
    this.email = email;
  }

  public RegisterRequest password(@jakarta.annotation.Nonnull String password) {
    
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPassword() {
    return password;
  }


  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPassword(@jakarta.annotation.Nonnull String password) {
    this.password = password;
  }

  public RegisterRequest role(@jakarta.annotation.Nonnull RoleEnum role) {
    
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public RoleEnum getRole() {
    return role;
  }


  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRole(@jakarta.annotation.Nonnull RoleEnum role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterRequest registerRequest = (RegisterRequest) o;
    return Objects.equals(this.firstname, registerRequest.firstname) &&
        Objects.equals(this.lastname, registerRequest.lastname) &&
        Objects.equals(this.email, registerRequest.email) &&
        Objects.equals(this.password, registerRequest.password) &&
        Objects.equals(this.role, registerRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, email, password, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterRequest {\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

