package pet.store.v3.model;

/**
 * {@link Tag} specific assertions - Generated by CustomAssertionGenerator.
 *
 * Although this class is not final to allow Soft assertions proxy, if you wish to extend it, 
 * extend {@link AbstractTagAssert} instead.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class TagAssert extends AbstractTagAssert<TagAssert, Tag> {

  /**
   * Creates a new <code>{@link TagAssert}</code> to make assertions on actual Tag.
   * @param actual the Tag we want to make assertions on.
   */
  public TagAssert(Tag actual) {
    super(actual, TagAssert.class);
  }

  /**
   * An entry point for TagAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myTag)</code> and get specific assertion with code completion.
   * @param actual the Tag we want to make assertions on.
   * @return a new <code>{@link TagAssert}</code>
   */
  @org.assertj.core.util.CheckReturnValue
  public static TagAssert assertThat(Tag actual) {
    return new TagAssert(actual);
  }
}
