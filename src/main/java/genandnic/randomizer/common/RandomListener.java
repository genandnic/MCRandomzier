package genandnic.randomizer.common;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RandomListener {

	// @SubscribeEvent
	// public void onChunkUnload(ChunkEvent.Unload event) {
	//
	// for (ClassInheritanceMultiMap<Entity> entity : event.getChunk().getEntityLists()) {
	//
	// }
	//
	// }

	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event) {

		removeRandomEntities(event.getEntity());

	}

	private void removeRandomEntities(Entity entity) {

		if (entity.removeTag("random"))
			entity.world.removeEntityDangerously(entity);

	}
}
