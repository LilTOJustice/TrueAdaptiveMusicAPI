package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.Holder
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.world.item.Item
import kotlin.jvm.optionals.getOrNull

@Suppress("UNUSED")
class ItemIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("item")
    }

    fun matches(item: Holder<Item>): Boolean {
        val registry = getItemRegistry() ?: return false

        return registry[id].getOrNull()?.let {
            item.`is`(it.key())
        } ?: registry.tags.toList().firstOrNull { it.key().location == id }?.key()?.let {
            item.`is`(it)
        } ?: false
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            val registry = getItemRegistry() ?: return emptyList()

            return registry.keySet().toList() +
                    registry.tags.map { it.key().location }.filter { it.namespace != "c" }.toList()
        }

        private fun getItemRegistry(): Registry<Item>? {
            return Minecraft.getInstance().level
                ?.registryAccess()
                ?.lookup(Registries.ITEM)
                ?.getOrNull()
        }
    }
}