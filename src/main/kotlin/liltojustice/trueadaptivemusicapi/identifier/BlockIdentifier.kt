package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.block.BlockState
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

@Suppress("UNUSED")
class BlockIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toTranslationKey("block")
    }

    fun matches(block: BlockState): Boolean {
        return Registries.BLOCK.streamTags().toList().firstOrNull { it.id == id }?.let {
            block.isIn(it)
        } ?: (Registries.BLOCK[id] == block)
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return Registries.BLOCK.keys.toList().map { it.value } +
                    Registries.BLOCK.streamTags().toList().map { it.id }.filter { it?.namespace != "c" }.toList()
        }
    }
}