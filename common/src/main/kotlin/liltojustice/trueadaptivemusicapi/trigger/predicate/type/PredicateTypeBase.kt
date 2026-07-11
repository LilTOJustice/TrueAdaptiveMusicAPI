package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.trigger.TriggerTypeBase

interface PredicateTypeBase: TriggerTypeBase {
    val tickRate: Int

    fun testBase(arguments: TriggerArguments, state: TriggerState): Boolean
}