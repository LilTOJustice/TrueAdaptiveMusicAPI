package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.EmptyTriggerArguments
import kotlin.reflect.typeOf

@Suppress("UNUSED")
abstract class BasicPredicateType(typeName: String)
    : StaticPredicateType<EmptyTriggerArguments>(typeName, typeOf<EmptyTriggerArguments>()) {
    final override val argDescriptions: Map<String, String>
        get() = super.argDescriptions
    final override val argDisplayNames: Map<String, String>
        get() = super.argDisplayNames

    abstract fun test(): Boolean

    final override fun test(arguments: EmptyTriggerArguments): Boolean {
        return test()
    }
}