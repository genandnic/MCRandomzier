package genandnic.randomizer.utility;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class EntityUtil {

	public static final ArrayList<ResourceLocation> ENTITIES = new ArrayList<ResourceLocation>();

	public static void populateLists() {

		Class<? extends Entity> clazz;
		for (ResourceLocation resource : EntityList.getEntityNameList()) {

			clazz = EntityList.getClass(resource);
			if (clazz != null && EntityLiving.class.isAssignableFrom(clazz))
				ENTITIES.add(resource);

		}

	}

	private static Random rand = new Random();

	public static ResourceLocation getRandomEntity() {

		return ENTITIES.get(rand.nextInt(ENTITIES.size()));

	}

}
