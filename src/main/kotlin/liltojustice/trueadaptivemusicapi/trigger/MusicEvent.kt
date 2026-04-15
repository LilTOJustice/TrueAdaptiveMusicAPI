package liltojustice.trueadaptivemusicapi.trigger

@Suppress("UNUSED")
abstract class MusicEvent: MusicTrigger() {
    open fun validate(vararg eventArgs: Any?): Boolean {
        return true
    }

    companion object: MusicEventCompanion

    interface MusicEventCompanion: MusicTriggerCompanion
}