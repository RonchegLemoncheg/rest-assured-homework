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
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SayHelloWithRoleUserAndUpdateAuthority400Response
 */
@JsonPropertyOrder({
})
@JsonTypeName("sayHelloWithRoleUserAndUpdateAuthority_400_response")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-01-28T12:48:20.235073900+04:00[Asia/Dubai]", comments = "Generator version: 7.11.0")
public class SayHelloWithRoleUserAndUpdateAuthority400Response {
  public SayHelloWithRoleUserAndUpdateAuthority400Response() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SayHelloWithRoleUserAndUpdateAuthority400Response {\n");
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

