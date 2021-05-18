package ch.tutteli.atrium.api.infix.en_GB

import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.logic.utils.mapArguments
import ch.tutteli.atrium.specs.*
import ch.tutteli.atrium.specs.integration.mfun2
import org.spekframework.spek2.Spek
import kotlin.jvm.JvmName
import ch.tutteli.atrium.api.infix.en_GB.MapContainsInAnyOrderOnlyKeyValueExpectationsSpec.Companion as C

class MapContainsInAnyOrderOnlyKeyValueExpectationsSpec : Spek({
    include(BuilderSpec)
    include(ShortcutSpec)
}) {

    object BuilderSpec : ch.tutteli.atrium.specs.integration.MapToContainInAnyOrderOnlyKeyValueExpectationsSpec(
        containsKeyValue_s to C::containsKeyValues,
        (containsKeyValue_s to C::containsKeyValuesNullable).withNullableSuffix(),
        "[Atrium][Builder] "
    )

    object ShortcutSpec : ch.tutteli.atrium.specs.integration.MapToContainInAnyOrderOnlyKeyValueExpectationsSpec(
        mfun2<String, Int, Expect<Int>.() -> Unit>(C::containsOnly),
        mfun2<String?, Int?, (Expect<Int>.() -> Unit)?>(C::containsOnly).withNullableSuffix(),
        "[Atrium][Shortcut] "
    )

    companion object : MapContainsSpecBase() {
        val containsKeyValue_s = "$contains $filler $inAnyOrder $butOnly $keyValue/$keyValue"

        private fun containsKeyValues(
            expect: Expect<Map<out String, Int>>,
            a: Pair<String, Expect<Int>.() -> Unit>,
            aX: Array<out Pair<String, Expect<Int>.() -> Unit>>
        ) = mapArguments(a, aX).to { keyValue(it.first, it.second) }.let { (first, others) ->
            if (others.isEmpty()) expect contains o inAny order but only entry first
            else expect contains o inAny order but only the keyValues(first, *others)
        }

        private fun containsKeyValuesNullable(
            expect: Expect<Map<out String?, Int?>>,
            a: Pair<String?, (Expect<Int>.() -> Unit)?>,
            aX: Array<out Pair<String?, (Expect<Int>.() -> Unit)?>>
        ) = mapArguments(a, aX).to { keyValue(it.first, it.second) }.let { (first, others) ->
            if (others.isEmpty()) expect contains o inAny order but only entry first
            else expect contains o inAny order but only the keyValues(first, *others)
        }

        private fun containsOnly(
            expect: Expect<Map<out String, Int>>,
            a: Pair<String, Expect<Int>.() -> Unit>,
            aX: Array<out Pair<String, Expect<Int>.() -> Unit>>
        ) = mapArguments(a, aX).to { keyValue(it.first, it.second) }.let { (first, others) ->
            if (others.isEmpty()) expect containsOnly first
            else expect containsOnly keyValues(first, *others)
        }

        @JvmName("containsInAnyOrderOnlyNullable")
        private fun containsOnly(
            expect: Expect<Map<out String?, Int?>>,
            a: Pair<String?, (Expect<Int>.() -> Unit)?>,
            aX: Array<out Pair<String?, (Expect<Int>.() -> Unit)?>>
        ) = mapArguments(a, aX).to { keyValue(it.first, it.second) }.let { (first, others) ->
            if (others.isEmpty()) expect containsOnly first
            else expect containsOnly keyValues(first, *others)
        }
    }

    @Suppress("unused", "UNUSED_VALUE")
    private fun ambiguityTest() {
        var map: Expect<Map<Number, CharSequence>> = notImplemented()
        var subMap: Expect<LinkedHashMap<out Number, String>> = notImplemented()
        var nKeyMap: Expect<Map<Number?, CharSequence>> = notImplemented()
        var nValueMap: Expect<Map<Number, CharSequence?>> = notImplemented()
        var nKeyValueMap: Expect<Map<Number?, CharSequence?>> = notImplemented()
        var ronKeyValueMap: Expect<Map<out Number?, CharSequence?>> = notImplemented()
        var starMap: Expect<Map<*, *>> = notImplemented()

        map = map contains o inAny order but only entry keyValue(1) { this toEqual "a" }
        subMap = subMap contains o inAny order but only entry keyValue(1) { this toEqual "a" }
        nKeyMap = nKeyMap contains o inAny order but only entry keyValue(1) { this toEqual "a" }
        nValueMap = nValueMap contains o inAny order but only entry keyValue(1) { this toEqual "a" }
        nKeyValueMap = nKeyValueMap contains o inAny order but only entry keyValue(1) { this toEqual "a" }
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only entry keyValue(1) { this toEqual "a" }
        starMap = starMap contains o inAny order but only entry keyValue(1) { this toEqual "a" }

        map = map contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })
        subMap = subMap contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })
        nKeyMap = nKeyMap contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })
        nValueMap = nValueMap contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })
        nKeyValueMap = nKeyValueMap contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })
        starMap = starMap contains o inAny order but only the keyValues(keyValue(1) { this toEqual "a" })

        map = map contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        subMap = subMap contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        nKeyMap = nKeyMap contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        nValueMap = nValueMap contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        nKeyValueMap = nKeyValueMap contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        starMap = starMap contains o inAny order but only the keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )

        nKeyMap = nKeyMap contains o inAny order but only entry keyValue(null) { this toEqual "a" }
        nKeyMap = nKeyMap contains o inAny order but only entry keyValue(null) { this toEqual "a" }
        nValueMap = nValueMap contains o inAny order but only entry keyValue(1.2, null)
        nKeyValueMap = nKeyValueMap contains o inAny order but only entry keyValue(null) { this toEqual "a" }
        nKeyValueMap = nKeyValueMap contains o inAny order but only entry keyValue(null, null)
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only entry keyValue(null) { this toEqual "a" }
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only entry keyValue(null, null)
        starMap = starMap contains o inAny order but only entry keyValue(null) { this toEqual "a" }
        starMap = starMap contains o inAny order but only entry keyValue(null, null)

        nKeyMap = nKeyMap contains o inAny order but only the keyValues(keyValue(null) { this toEqual "a" })
        nKeyValueMap = nKeyValueMap contains o inAny order but only the keyValues(keyValue(null) { this toEqual "a" })
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only the keyValues(keyValue(null) { this toEqual "a" })
        starMap = starMap contains o inAny order but only the keyValues(keyValue(null) { this toEqual "a" })

        nKeyMap = nKeyMap contains o inAny order but only the keyValues(keyValue(null) { this toEqual "a" })
        nValueMap = nValueMap contains o inAny order but only the keyValues(keyValue(1, null), keyValue(1) { this toEqual "a" })
        nKeyValueMap = nKeyValueMap contains o inAny order but only the keyValues(
            keyValue(null) { this toEqual "a" },
            keyValue(null, null),
            keyValue(1, null)
        )
        ronKeyValueMap = ronKeyValueMap contains o inAny order but only the keyValues(
            keyValue(null) { this toEqual "a" },
            keyValue(null, null),
            keyValue(1, null)
        )
        starMap = starMap contains o inAny order but only the keyValues(
            keyValue(null) { this toEqual "a" },
            keyValue(null, null),
            keyValue(1, null)
        )


        /// ------------- shortcuts -----------------------------------------------------------------

        map = map containsOnly keyValue(1) { this toEqual "a" }
        subMap = subMap containsOnly keyValue(1) { this toEqual "a" }
        nKeyMap = nKeyMap containsOnly keyValue(1) { this toEqual "a" }
        nValueMap = nValueMap containsOnly keyValue(1) { this toEqual "a" }
        nKeyValueMap = nKeyValueMap containsOnly keyValue(1) { this toEqual "a" }
        ronKeyValueMap = ronKeyValueMap containsOnly keyValue(1) { this toEqual "a" }
        starMap = starMap containsOnly keyValue(1) { this toEqual "a" }

        map = map containsOnly keyValues(keyValue(1) { this toEqual "a" })
        subMap = subMap containsOnly keyValues(keyValue(1) { this toEqual "a" })
        nKeyMap = nKeyMap containsOnly keyValues(keyValue(1) { this toEqual "a" })
        nValueMap = nValueMap containsOnly keyValues(keyValue(1) { this toEqual "a" })
        nKeyValueMap = nKeyValueMap containsOnly keyValues(keyValue(1) { this toEqual "a" })
        ronKeyValueMap = ronKeyValueMap containsOnly keyValues(keyValue(1) { this toEqual "a" })
        starMap = starMap containsOnly keyValues(keyValue(1) { this toEqual "a" })

        map = map containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        subMap = subMap containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        nKeyMap = nKeyMap containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        nValueMap = nValueMap containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        nKeyValueMap = nKeyValueMap containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        ronKeyValueMap = ronKeyValueMap containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )
        starMap = starMap containsOnly keyValues(
            keyValue(1 as Number) { this toEqual "a" },
            keyValue(1.2) { this toEqual "b" }
        )

        nKeyMap = nKeyMap containsOnly keyValue(null) { this toEqual "a" }
        nValueMap = nValueMap containsOnly keyValue(1.2, null)
        nKeyValueMap = nKeyValueMap containsOnly keyValue(null) { this toEqual "a" }
        nKeyValueMap = nKeyValueMap containsOnly keyValue(null, null)
        ronKeyValueMap = ronKeyValueMap containsOnly keyValue(null) { this toEqual "a" }
        ronKeyValueMap = ronKeyValueMap containsOnly keyValue(null, null)
        starMap = starMap containsOnly keyValue(null) { this toEqual "a" }
        starMap = starMap containsOnly keyValue(null, null)

        nKeyMap = nKeyMap containsOnly keyValues(keyValue(null) { this toEqual "a" })
        nKeyValueMap = nKeyValueMap containsOnly keyValues(keyValue(null) { this toEqual "a" })
        ronKeyValueMap = ronKeyValueMap containsOnly keyValues(keyValue(null) { this toEqual "a" })
        starMap = starMap containsOnly keyValues(keyValue(null) { this toEqual "a" })

        nKeyMap = nKeyMap containsOnly keyValues(keyValue(null) { this toEqual "a" })
        nValueMap = nValueMap containsOnly keyValues(keyValue(1, null), keyValue(1) { this toEqual "a" })
        nKeyValueMap = nKeyValueMap containsOnly keyValues(
            keyValue(null) { this toEqual "a" },
            keyValue(null, null),
            keyValue(1, null)
        )
        ronKeyValueMap = ronKeyValueMap containsOnly keyValues(
            keyValue(null) { this toEqual "a" },
            keyValue(null, null),
            keyValue(1, null)
        )
        starMap = starMap containsOnly keyValues(
            keyValue(null) { this toEqual "a" },
            keyValue(null, null),
            keyValue(1, null)
        )
    }
}
