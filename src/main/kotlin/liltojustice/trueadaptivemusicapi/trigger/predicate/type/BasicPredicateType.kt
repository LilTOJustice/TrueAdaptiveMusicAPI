package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.EmptyTriggerArguments

@Suppress("UNUSED")
abstract class BasicPredicateType(typeName: String): StaticPredicateType<EmptyTriggerArguments>(typeName) {
    final override val argDescriptions: Map<String, String>
        get() = super.argDescriptions
    final override val argDisplayNames: Map<String, String>
        get() = super.argDisplayNames

    abstract fun validate(): Boolean

    final override fun validatePredicate(arguments: EmptyTriggerArguments): Boolean {
        return validate()
    }
}