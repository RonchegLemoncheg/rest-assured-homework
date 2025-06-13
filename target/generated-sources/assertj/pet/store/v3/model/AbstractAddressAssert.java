package pet.store.v3.model;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.Objects;

/**
 * Abstract base class for {@link Address} specific assertions - Generated by CustomAssertionGenerator.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public abstract class AbstractAddressAssert<S extends AbstractAddressAssert<S, A>, A extends Address> extends AbstractObjectAssert<S, A> {

  /**
   * Creates a new <code>{@link AbstractAddressAssert}</code> to make assertions on actual Address.
   * @param actual the Address we want to make assertions on.
   */
  protected AbstractAddressAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual Address's city is equal to the given one.
   * @param city the given city to compare the actual Address's city to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Address's city is not equal to the given one.
   */
  public S hasCity(String city) {
    // check that actual Address we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting city of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualCity = actual.getCity();
    if (!Objects.areEqual(actualCity, city)) {
      failWithMessage(assertjErrorMessage, actual, city, actualCity);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Address's state is equal to the given one.
   * @param state the given state to compare the actual Address's state to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Address's state is not equal to the given one.
   */
  public S hasState(String state) {
    // check that actual Address we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting state of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualState = actual.getState();
    if (!Objects.areEqual(actualState, state)) {
      failWithMessage(assertjErrorMessage, actual, state, actualState);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Address's street is equal to the given one.
   * @param street the given street to compare the actual Address's street to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Address's street is not equal to the given one.
   */
  public S hasStreet(String street) {
    // check that actual Address we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting street of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualStreet = actual.getStreet();
    if (!Objects.areEqual(actualStreet, street)) {
      failWithMessage(assertjErrorMessage, actual, street, actualStreet);
    }

    // return the current assertion for method chaining
    return myself;
  }

  /**
   * Verifies that the actual Address's zip is equal to the given one.
   * @param zip the given zip to compare the actual Address's zip to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Address's zip is not equal to the given one.
   */
  public S hasZip(String zip) {
    // check that actual Address we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting zip of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

    // null safe check
    String actualZip = actual.getZip();
    if (!Objects.areEqual(actualZip, zip)) {
      failWithMessage(assertjErrorMessage, actual, zip, actualZip);
    }

    // return the current assertion for method chaining
    return myself;
  }

}
