package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.Holder
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import kotlin.jvm.optionals.getOrNull

@Suppress("UNUSED")
class ItemIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("item")
    }

    fun matches(item: Holder<Item>): Boolean {
        val registry = getItemRegistry() ?: return false

        return registry.tagNames.toList().firstOrNull { it.location == id }?.let {
            item.`is`(it)
        } ?: (registry[id] == item.value())
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            val registry = getItemRegistry() ?: return emptyList()

            return registry.registryKeySet().toList().map { it.location() } +
                    registry.tagNames.toList().map { it.location }.filter { it.namespace != "c" }.toList()
        }

        private fun getItemRegistry(): Registry<Item>? {
            return Minecraft.getInstance().level
                ?.registryAccess()
                ?.registry(Registries.ITEM)
                ?.getOrNull()
        }
    }
}