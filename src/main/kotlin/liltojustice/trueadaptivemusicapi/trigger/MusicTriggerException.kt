package liltojustice.trueadaptivemusicapi.trigger

import liltojustice.trueadaptivemusicapi.TrueAdaptiveMusicException

internal class MusicTriggerException(message: String? = null, inner: Exception? = null)
    : TrueAdaptiveMusicException(message, inner)