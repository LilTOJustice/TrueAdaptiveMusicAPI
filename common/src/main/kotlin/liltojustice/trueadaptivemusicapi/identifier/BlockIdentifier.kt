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
        return BuiltInRegistries.BLOCK.tags.toList().firstOrNull { it.key().location == id }?.let {
            block.`is`(it.key())
        } ?: (BuiltInRegistries.BLOCK.getValue(id) == block.block)
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return BuiltInRegistries.BLOCK.registryKeySet().toList().map { it.location() } +
                    BuiltInRegistries.BLOCK.tags.toList().map { it.key().location }.filter { it.namespace != "c" }.toList()
        }
    }
}