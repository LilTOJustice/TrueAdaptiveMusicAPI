package liltojustice.trueadaptivemusicapi.widget

import kotlin.reflect.KParameter
import kotlin.reflect.KType

data class WidgetArg(val type: KType, val name: String?, val index: Int) {
    companion object {
        fun of(kParameter: KParameter): WidgetArg {
            return WidgetArg(kParameter.type, kParameter.name, kParameter.index)
        }
    }
}
