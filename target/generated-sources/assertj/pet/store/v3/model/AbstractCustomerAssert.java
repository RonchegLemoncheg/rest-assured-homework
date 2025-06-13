package pet.store.v3.model;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * Abstract base class for {@link Customer} specific assertions - Generated by CustomAssertionGenerator.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public abstract class AbstractCustomerAssert<S extends AbstractCustomerAssert<S, A>, A extends Customer> extends AbstractObjectAssert<S, A> {

  /**
   * Creates a new <code>{@link AbstractCustomerAssert}</code> to make assertions on actual Customer.
   * @param actual the Customer we want to make assertions on.
   */
  protected AbstractCustomerAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual Customer's address contains the given Address elements.
   * @param address the given elements that should be contained in actual Customer's address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address does not contain all given Address elements.
   */
  public S hasAddress(Address... address) {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // check that given Address varargs is not null.
    if (address == null) failWithMessage("Expecting address parameter not to be null.");

    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getAddress(), address);

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Customer's address contains the given Address elements in Collection.
   * @param address the given elements that should be contained in actual Customer's address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address does not contain all given Address elements.
   */
  public S hasAddress(java.util.Collection<? extends Address> address) {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // check that given Address collection is not null.
    if (address == null) {
      failWithMessage("Expecting address parameter not to be null.");
      return myself; // to fool Eclipse "Null pointer access" warning on toArray.
    }

    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getAddress(), address.toArray());

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Customer's address contains <b>only</b> the given Address elements and nothing else in whatever order.
   * @param address the given elements that should be contained in actual Customer's address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address does not contain all given Address elements.
   */
  public S hasOnlyAddress(Address... address) {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // check that given Address varargs is not null.
    if (address == null) failWithMessage("Expecting address parameter not to be null.");

    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getAddress(), address);

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Customer's address contains <b>only</b> the given Address elements in Collection and nothing else in whatever order.
   * @param address the given elements that should be contained in actual Customer's address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address does not contain all given Address elements.
   */
  public S hasOnlyAddress(java.util.Collection<? extends Address> address) {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // check that given Address collection is not null.
    if (address == null) {
      failWithMessage("Expecting address parameter not to be null.");
      return myself; // to fool Eclipse "Null pointer access" warning on toArray.
    }

    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getAddress(), address.toArray());

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Customer's address does not contain the given Address elements.
   *
   * @param address the given elements that should not be in actual Customer's address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address contains any given Address elements.
   */
  public S doesNotHaveAddress(Address... address) {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // check that given Address varargs is not null.
    if (address == null) failWithMessage("Expecting address parameter not to be null.");

    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getAddress(), address);

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Customer's address does not contain the given Address elements in Collection.
   *
   * @param address the given elements that should not be in actual Customer's address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address contains any given Address elements.
   */
  public S doesNotHaveAddress(java.util.Collection<? extends Address> address) {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // check that given Address collection is not null.
    if (address == null) {
      failWithMessage("Expecting address parameter not to be null.");
      return myself; // to fool Eclipse "Null pointer access" warning on toArray.
    }

    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getAddress(), address.toArray());

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Customer has no address.
   * @return this assertion object.
   * @throws AssertionError if the actual Customer's address is not empty.
   */
  public S hasNoAddress() {
    // check that actual Customer we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have address but had :\n  <%s>";

    // check
    if (actual.getAddress().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getAddress());
    }

    // return the current assertion for method chaining
    return myself;
  }


  /**
   * Verifies that the actual Customer's id is equal to the given one.
   * @param id the given id to compare the actual Customer's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Customer's id is not equal to the given one.
   */
  public S hasId(Long id) {
    // check that actual Customer we want to make assertions on is not null.
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
   * Verifies that the actual Customer's username is equal to the given one.
   * @param username the given username to compare the actual Customer's username to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Customer's username is not equal to the given one.
   */
  public S hasUsername(String username) {
    // check that actual Customer we want to make assertions on is not null.
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
