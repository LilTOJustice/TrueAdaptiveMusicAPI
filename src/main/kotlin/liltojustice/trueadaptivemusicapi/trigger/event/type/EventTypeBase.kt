package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.trigger.TriggerTypeBase
import liltojustice.trueadaptivemusicapi.trigger.event.input.EventInput

interface EventTypeBase: TriggerTypeBase {
    fun validate(arguments: TriggerArguments, state: TriggerState, input: EventInput): Boolean
}