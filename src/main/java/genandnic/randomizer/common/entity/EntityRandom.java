package genandnic.randomizer.common.entity;

import genandnic.randomizer.utility.EntityUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityRandom extends EntityLiving {

	public static final String NAME = "random";

	public EntityRandom(World world) {
		super(world);
	}

	@Override
	public void onEntityUpdate() {

		Entity randomEntity = EntityList.createEntityByIDFromName(EntityUtil.getRandomEntity(), this.world);
		if (randomEntity == null || !randomEntity.isNonBoss())
			return;

		// System.out.println(randomEntity.getName());

		randomEntity.setPosition(this.posX, this.posY, this.posZ);
		this.world.spawnEntity(randomEntity);
		randomEntity.addTag("random");

		this.setDead();
	}

}
