package localhost.client.model;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.Objects;

/**
 * Abstract base class for {@link ErrorResponse} specific assertions - Generated by CustomAssertionGenerator.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public abstract class AbstractErrorResponseAssert<S extends AbstractErrorResponseAssert<S, A>, A extends ErrorResponse> extends AbstractObjectAssert<S, A> {

  /**
   * Creates a new <code>{@link AbstractErrorResponseAssert}</code> to make assertions on actual ErrorResponse.
   * @param actual the ErrorResponse we want to make assertions on.
   */
  protected AbstractErrorResponseAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual ErrorResponse's error is equal to the given one.
   * @param error the given error to compare the actual ErrorResponse's error to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ErrorResponse's error is not equal to the given one.
   */
  public S hasError(String error) {
    // check that actual ErrorResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting error of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualError = actual.getError();
    if (!Objects.areEqual(actualError, error)) {
      failWithMessage(assertjErrorMessage, actual, error, actualError);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual ErrorResponse's message is equal to the given one.
   * @param message the given message to compare the actual ErrorResponse's message to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ErrorResponse's message is not equal to the given one.
   */
  public S hasMessage(String message) {
    // check that actual ErrorResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting message of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualMessage = actual.getMessage();
    if (!Objects.areEqual(actualMessage, message)) {
      failWithMessage(assertjErrorMessage, actual, message, actualMessage);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual ErrorResponse's path is equal to the given one.
   * @param path the given path to compare the actual ErrorResponse's path to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ErrorResponse's path is not equal to the given one.
   */
  public S hasPath(String path) {
    // check that actual ErrorResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting path of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualPath = actual.getPath();
    if (!Objects.areEqual(actualPath, path)) {
      failWithMessage(assertjErrorMessage, actual, path, actualPath);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual ErrorResponse's status is equal to the given one.
   * @param status the given status to compare the actual ErrorResponse's status to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ErrorResponse's status is not equal to the given one.
   */
  public S hasStatus(Integer status) {
    // check that actual ErrorResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting status of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    Integer actualStatus = actual.getStatus();
    if (!Objects.areEqual(actualStatus, status)) {
      failWithMessage(assertjErrorMessage, actual, status, actualStatus);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual ErrorResponse's timestamp is equal to the given one.
   * @param timestamp the given timestamp to compare the actual ErrorResponse's timestamp to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ErrorResponse's timestamp is not equal to the given one.
   */
  public S hasTimestamp(java.time.OffsetDateTime timestamp) {
    // check that actual ErrorResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting timestamp of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    java.time.OffsetDateTime actualTimestamp = actual.getTimestamp();
    if (!Objects.areEqual(actualTimestamp, timestamp)) {
      failWithMessage(assertjErrorMessage, actual, timestamp, actualTimestamp);
    }

    // return the current assertion for method chaining
    return myself;
  }

}
