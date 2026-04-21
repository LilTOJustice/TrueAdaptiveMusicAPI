package liltojustice.trueadaptivemusicapi.trigger

import liltojustice.trueadaptivemusicapi.TrueAdaptiveMusicException

internal class TriggerTypeException(message: String? = null, inner: Exception? = null)
    : TrueAdaptiveMusicException(message, inner)