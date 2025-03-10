package ch.tutteli.atrium.api.infix.en_GB

import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.creating.PleaseUseReplacementException
import ch.tutteli.atrium.logic.*
import java.math.BigDecimal

/**
 * Deprecated as it would compare the subject against [expected] including scale
 * -- many developers are not aware of that.
 *
 * Use [toEqualNumerically] if you expect that the following assertion holds:
 * ```
 * expect(BigDecimal("10").toBe(BigDecimal("10.0"))
 * ```
 * However, if you expect it to be wrong (because `BigDecimal.scale` differ), then use [toEqualIncludingScale].
 *
 * @since 0.17.0
 */
@Deprecated(
    "Use `toEqualNumerically` if you expect that the following assertion holds:\n" +
        "`expect(BigDecimal(\"10\")).toBe(BigDecimal(\"10.0\"))`\n" +
        "However, if you expect it to be wrong (because `BigDecimal.scale` differ), then use `toEqualIncludingScale`.",
    ReplaceWith("toEqualNumerically(expected) or toEqualIncludingScale(expected)")
)
@Suppress("UNUSED_PARAMETER", "UnusedReceiverParameter")
infix fun <T : BigDecimal> Expect<T>.toEqual(expected: T): Nothing =
    throw PleaseUseReplacementException(
        "BigDecimal.equals() compares also BigDecimal.scale, which you might not be aware of.\n" +
            "If you know it and want that `scale` is included in the comparison, then use `toEqualIncludingScale`."
    )

/**
 * Deprecated as it would compare the subject against [expected] including scale
 * -- many developers are not aware of that.
 *
 * Use [toEqualNumerically] if you expect that the following assertion holds:
 * ```
 * expect(BigDecimal("10").toBe(BigDecimal("10.0"))
 * ```
 * However, if you expect it to be wrong (because `BigDecimal.scale` differ), then use [toEqualIncludingScale].
 *
 * @since 0.17.0
 */
//TODO rename to toEqualNullable with 2.0.0
@JvmName("toBeNullable")
@Deprecated(
    "Use `toEqualNumerically` if you expect that the following assertion holds:\n" +
        "`expect(BigDecimal(\"10\")).toBe(BigDecimal(\"10.0\"))`\n" +
        "However, if you expect it to be wrong (because `BigDecimal.scale` differ), then use `toEqualIncludingScale`.",
    ReplaceWith("toEqualNumerically(expected) or toEqualIncludingScale(expected)")
)
@Suppress("UNUSED_PARAMETER", "UnusedReceiverParameter")
infix fun <T : BigDecimal?> Expect<T>.toEqual(expected: T): Nothing =
    throw PleaseUseReplacementException(
        "BigDecimal.equals() compares also BigDecimal.scale, which you might not be aware of.\n" +
            "If you know it and want that `scale` is included in the comparison, then use `toEqualIncludingScale`."
    )

/**
 * Expects that the subject of `this` expectation (a [BigDecimal]) is `null`.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.infix.en_GB.samples.BigDecimalExpectationSamples.toEqualNull
 *
 * @since 0.17.0
 */
//TODO rename to toEqualNul with 2.0.0
@JvmName("toBeNull")
infix fun <T : BigDecimal> Expect<T?>.toEqual(expected: Nothing?): Expect<T?> =
    _logicAppend { toBe(expected) }

/**
 * Deprecated as it would compare the subject against [expected] including scale
 * -- many developers are not aware of that.
 *
 * Use [isNotNumericallyEqualTo] if you expect that the following assertion is wrong:
 * ```
 * expect(BigDecimal("10").notToBe(BigDecimal("10.0"))
 * ```
 * However, if you expect it to be wrong (because `BigDecimal.scale` differ), then use [notToEqualIncludingScale].
 *
 * @since 0.17.0
 */
@Deprecated(
    "Use `notToEqualNumerically` if you expect that the following assertion is wrong:\n" +
        "`expect(BigDecimal(\"10\")).notToBe(BigDecimal(\"10.0\"))`\n" +
        "However, if you expect it to hold (because `BigDecimal.scale` differ), then use `notToEqualIncludingScale`.",
    ReplaceWith("notToEqualNumerically(expected) or notToEqualIncludingScale(expected)")
)
@Suppress("UNUSED_PARAMETER", "UnusedReceiverParameter")
infix fun <T : BigDecimal?> Expect<T>.notToEqual(expected: T): Nothing =
    throw PleaseUseReplacementException(
        "BigDecimal.equals() compares also BigDecimal.scale, which you might not be aware of.\n" +
            "If you know it and want that `scale` is included in the comparison, then use `notToEqualIncludingScale`."
    )

/**
 * Expects that the subject of `this` expectation (a [BigDecimal]) is not `null`.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.infix.en_GB.samples.BigDecimalExpectationSamples.notToEqualNull
 *
 * @since 1.1.0
 */
@JvmName("notToEqualNull")
infix fun <T : BigDecimal> Expect<T?>.notToEqual(expected: Nothing?): Expect<T> =
    _logicAppend { notToBe(expected) }._logic.changeSubject.unreported { it!! }


/**
 * Expects that the subject of `this` expectation (a [BigDecimal]) is numerically equal to [expected].
 *
 * By numerically is meant that it will not compare [BigDecimal.scale] (or in other words,
 * it uses `compareTo(expected) == 0`)
 *
 * Most of the time you want to use this function instead of [toEqualIncludingScale] because
 * [toEqualIncludingScale] compares [BigDecimal.scale].
 * Following the two functions compared:
 * - `expect(BigDecimal("10")).toEqualIncludingScale(BigDecimal("10.0"))` does not hold.
 * - `expect(BigDecimal("10")).toEqualNumerically(BigDecimal("10.0"))` holds.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.infix.en_GB.samples.BigDecimalExpectationSamples.toEqualNumerically
 *
 * @since 0.17.0
 */
infix fun <T : BigDecimal> Expect<T>.toEqualNumerically(expected: T): Expect<T> =
    _logicAppend { isNumericallyEqualTo(expected) }

/**
 * Expects that the subject of `this` expectation (a [BigDecimal]) is not numerically equal to [expected].
 *
 * By numerically is meant that it will not compare [BigDecimal.scale] (or in other words,
 * it uses `compareTo(expected) != 0`)
 *
 * Most of the time you want to use this function instead of [notToEqualIncludingScale] because
 * [notToEqualIncludingScale] compares [BigDecimal.scale].
 * Following the two functions compared:
 * - `expect(BigDecimal("10")).notToEqualIncludingScale(BigDecimal("10.0"))` holds.
 * - `expect(BigDecimal("10")).notToEqualNumerically(BigDecimal("10.0"))`  does not hold.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.infix.en_GB.samples.BigDecimalExpectationSamples.notToEqualNumerically
 *
 * @since 0.17.0
 */
infix fun <T : BigDecimal> Expect<T>.notToEqualNumerically(expected: T): Expect<T> =
    _logicAppend { isNotNumericallyEqualTo(expected) }


/**
 * Expects that the subject of `this` expectation (a [BigDecimal]) is equal to [expected] including [BigDecimal.scale].
 *
 * Most of the time you want to use [toEqualNumerically] which does not compare [BigDecimal.scale]
 * in contrast to this function.
 * Following the two functions compared:
 * - `expect(BigDecimal("10")).toEqualIncludingScale(BigDecimal("10.0"))` does not hold.
 * - `expect(BigDecimal("10")).toEqualNumerically(BigDecimal("10.0"))` holds.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.infix.en_GB.samples.BigDecimalExpectationSamples.toEqualIncludingScale
 *
 * @since 0.17.0
 */
infix fun <T : BigDecimal> Expect<T>.toEqualIncludingScale(expected: T): Expect<T> =
    _logicAppend { isEqualIncludingScale(expected, Expect<T>::toEqualNumerically.name) }

/**
 * Expects that the subject of `this` expectation (a [BigDecimal]) is not equal to [expected] including [BigDecimal.scale].
 *
 * Most of the time you want to use [notToEqualNumerically] which does not compare [BigDecimal.scale]
 * in contrast to this function.
 * Following the two functions compared:
 * - `expect(BigDecimal("10")).notToEqualIncludingScale(BigDecimal("10.0"))` holds.
 * - `expect(BigDecimal("10")).notToEqualNumerically(BigDecimal("10.0"))`  does not hold.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.infix.en_GB.samples.BigDecimalExpectationSamples.notToEqualIncludingScale
 *
 * @since 0.17.0
 */
infix fun <T : BigDecimal> Expect<T>.notToEqualIncludingScale(expected: T): Expect<T> =
    _logicAppend { isNotEqualIncludingScale(expected) }
