@file:Suppress("DEPRECATION")
package ch.tutteli.atrium.translations

import ch.tutteli.atrium.assertions.DescriptiveAssertion
import ch.tutteli.atrium.reporting.translating.StringBasedTranslatable

/**
 * Contains the [DescriptiveAssertion.description]s of the expectation functions which are applicable to [Any].
 */
@Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
enum class DescriptionAnyExpectation(override val value: String) : StringBasedTranslatable {
    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    TO_EQUAL("entspricht"),

    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    NOT_TO_EQUAL("entspricht nicht"),

    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    TO_BE_AN_INSTANCE_OF("ist eine Instanz vom Typ"),

    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    TO_BE_THE_INSTANCE("ist dieselbe Instanz wie"),

    /** @since 1.1.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    NOT_TO_EQUAL_NULL_TO_BE_AN_INSTANCE_OF("entsprich nicht: null sondern ist eine Instanz vom Typ"),

    /** @since 1.1.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    NOT_TO_BE_AN_INSTANCE_OF("ist nicht eine Instanz vom Typ"),

    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    NOT_TO_BE_THE_INSTANCE("ist nicht dieselbe Instanz wie"),

    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    NOT_TO_EQUAL_ONE_IN("entspricht keinem in"),

    /** @since 0.18.0 */
    @Deprecated("Switch to atrium-translations-en_GB, this module will be removed with Atrium 1.3")
    BECAUSE("denn"),
}
