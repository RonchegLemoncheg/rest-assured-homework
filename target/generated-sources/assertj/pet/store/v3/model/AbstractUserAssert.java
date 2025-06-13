package pet.store.v3.model;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.Objects;

/**
 * Abstract base class for {@link User} specific assertions - Generated by CustomAssertionGenerator.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public abstract class AbstractUserAssert<S extends AbstractUserAssert<S, A>, A extends User> extends AbstractObjectAssert<S, A> {

  /**
   * Creates a new <code>{@link AbstractUserAssert}</code> to make assertions on actual User.
   * @param actual the User we want to make assertions on.
   */
  protected AbstractUserAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual User's email is equal to the given one.
   * @param email the given email to compare the actual User's email to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's email is not equal to the given one.
   */
  public S hasEmail(String email) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting email of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualEmail = actual.getEmail();
    if (!Objects.areEqual(actualEmail, email)) {
      failWithMessage(assertjErrorMessage, actual, email, actualEmail);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's firstName is equal to the given one.
   * @param firstName the given firstName to compare the actual User's firstName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's firstName is not equal to the given one.
   */
  public S hasFirstName(String firstName) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting firstName of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualFirstName = actual.getFirstName();
    if (!Objects.areEqual(actualFirstName, firstName)) {
      failWithMessage(assertjErrorMessage, actual, firstName, actualFirstName);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's id is equal to the given one.
   * @param id the given id to compare the actual User's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's id is not equal to the given one.
   */
  public S hasId(Long id) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting id of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    Long actualId = actual.getId();
    if (!Objects.areEqual(actualId, id)) {
      failWithMessage(assertjErrorMessage, actual, id, actualId);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's lastName is equal to the given one.
   * @param lastName the given lastName to compare the actual User's lastName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's lastName is not equal to the given one.
   */
  public S hasLastName(String lastName) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting lastName of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualLastName = actual.getLastName();
    if (!Objects.areEqual(actualLastName, lastName)) {
      failWithMessage(assertjErrorMessage, actual, lastName, actualLastName);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's password is equal to the given one.
   * @param password the given password to compare the actual User's password to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's password is not equal to the given one.
   */
  public S hasPassword(String password) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting password of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualPassword = actual.getPassword();
    if (!Objects.areEqual(actualPassword, password)) {
      failWithMessage(assertjErrorMessage, actual, password, actualPassword);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's phone is equal to the given one.
   * @param phone the given phone to compare the actual User's phone to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's phone is not equal to the given one.
   */
  public S hasPhone(String phone) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting phone of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualPhone = actual.getPhone();
    if (!Objects.areEqual(actualPhone, phone)) {
      failWithMessage(assertjErrorMessage, actual, phone, actualPhone);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's userStatus is equal to the given one.
   * @param userStatus the given userStatus to compare the actual User's userStatus to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's userStatus is not equal to the given one.
   */
  public S hasUserStatus(Integer userStatus) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting userStatus of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    Integer actualUserStatus = actual.getUserStatus();
    if (!Objects.areEqual(actualUserStatus, userStatus)) {
      failWithMessage(assertjErrorMessage, actual, userStatus, actualUserStatus);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual User's username is equal to the given one.
   * @param username the given username to compare the actual User's username to.
   * @return this assertion object.
   * @throws AssertionError - if the actual User's username is not equal to the given one.
   */
  public S hasUsername(String username) {
    // check that actual User we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting username of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualUsername = actual.getUsername();
    if (!Objects.areEqual(actualUsername, username)) {
      failWithMessage(assertjErrorMessage, actual, username, actualUsername);
    }

    // return the current assertion for method chaining
    return myself;
  }

}
