package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.world.entity.Entity

@Suppress("UNUSED")
class EntityIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("entity")
    }

    fun matches(entity: Entity): Boolean {
        return BuiltInRegistries.ENTITY_TYPE.tags.toList().firstOrNull { it.key().location == id }?.let {
            entity.type.`is`(it)
        } ?: (BuiltInRegistries.ENTITY_TYPE.getValue(id) == entity.type)
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return BuiltInRegistries.ENTITY_TYPE.keySet().toList() +
                    BuiltInRegistries.ENTITY_TYPE.tags.map { it.key().location }.toList()
        }
    }
}