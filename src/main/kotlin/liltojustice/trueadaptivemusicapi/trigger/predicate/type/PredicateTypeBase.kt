package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.trigger.TriggerTypeBase

interface PredicateTypeBase: TriggerTypeBase {
    fun validate(arguments: TriggerArguments, state: TriggerState): Boolean
}