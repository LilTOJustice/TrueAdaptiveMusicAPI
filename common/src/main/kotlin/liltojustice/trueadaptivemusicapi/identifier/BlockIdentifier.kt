package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.world.level.block.state.BlockState
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class BlockIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("block")
    }

    fun matches(block: BlockState): Boolean {
        return BuiltInRegistries.BLOCK.tagNames.toList().firstOrNull { it.location == id }?.let {
            block.`is`(it)
        } ?: (BuiltInRegistries.BLOCK[id] == block.block)
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return BuiltInRegistries.BLOCK.registryKeySet().toList().map { it.location() } +
                    BuiltInRegistries.BLOCK.tagNames.toList().map { it.location }.filter { it.namespace != "c" }.toList()
        }
    }
}