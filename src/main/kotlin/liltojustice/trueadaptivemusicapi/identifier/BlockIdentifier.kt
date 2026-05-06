package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.state.BlockState
import kotlin.jvm.optionals.getOrNull

@Suppress("UNUSED")
class BlockIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("block")
    }

    fun matches(block: BlockState): Boolean {
        return BuiltInRegistries.BLOCK[id].getOrNull()?.let {
            block.`is`(it)
        } ?: BuiltInRegistries.BLOCK.tags.toList().firstOrNull { it.key().location == id }?.key()?.let {
            block.`is`(it)
        } ?: false
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return BuiltInRegistries.BLOCK.keySet().toList() +
                    BuiltInRegistries.BLOCK.tags.map { it.key().location }.toList()
        }
    }
}