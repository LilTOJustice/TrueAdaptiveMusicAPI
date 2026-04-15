package liltojustice.trueadaptivemusicapi.trigger

@Suppress("UNUSED")
abstract class MusicPredicate: MusicTrigger() {
    protected abstract fun test(): Boolean

    open fun getTickRate(): Int {
        return 1
    }

    companion object: MusicPredicateCompanion

    interface MusicPredicateCompanion: MusicTriggerCompanion
}