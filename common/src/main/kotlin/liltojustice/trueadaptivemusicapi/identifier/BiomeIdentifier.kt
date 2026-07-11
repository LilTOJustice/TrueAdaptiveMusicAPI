package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.core.Holder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biome
import kotlin.jvm.optionals.getOrNull

@Suppress("UNUSED")
class BiomeIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("biome")
    }

    fun matches(biome: Holder<Biome>): Boolean {
        val registry = getBiomeRegistry() ?: return false
        return registry.tagNames.toList().firstOrNull { it.location == id }?.let {
            biome.`is`(it)
        } ?: (registry[id] == biome.value())
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            val registry = getBiomeRegistry() ?: return emptyList()

            return registry.registryKeySet().toList().map { it.location() } +
                    registry.tagNames.toList().map { it.location }.filter { it.namespace != "c" }.toList()
        }

        private fun getBiomeRegistry(): Registry<Biome>? {
            return Minecraft.getInstance().level
                ?.registryAccess()
                ?.registry(Registries.BIOME)
                ?.getOrNull()
        }
    }
}