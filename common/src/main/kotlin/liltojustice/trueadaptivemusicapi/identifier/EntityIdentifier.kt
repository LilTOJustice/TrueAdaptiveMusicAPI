package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.world.entity.Entity
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class EntityIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("entity")
    }

    fun matches(entity: Entity): Boolean {
        return BuiltInRegistries.ENTITY_TYPE.tags.toList().firstOrNull { it.key().location == id }?.let {
            entity.type.`is`(it)
        } ?: (BuiltInRegistries.ENTITY_TYPE.getValue(id) == entity.type)
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return BuiltInRegistries.ENTITY_TYPE.registryKeySet().map { it.location() }.toList() +
                    BuiltInRegistries.ENTITY_TYPE.tags.toList().map { it.key().location }.toList()
        }
    }
}