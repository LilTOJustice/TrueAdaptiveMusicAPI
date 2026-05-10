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
        return Registries.BLOCK.streamTags().toList().firstOrNull { it.tag.id == id }?.let {
            block.isIn(it.tag)
        } ?: (Registries.BLOCK[id] == block.block)
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return Registries.BLOCK.keys.toList().map { it.value } +
                    Registries.BLOCK.streamTags().toList().map { it.tag.id }.filter { it?.namespace != "c" }.toList()
        }
    }
}