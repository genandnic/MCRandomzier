package genandnic.randomizer;

import genandnic.randomizer.common.CommonProxy;
import genandnic.randomizer.common.RandomListener;
import genandnic.randomizer.common.entity.EntityRandom;
import genandnic.randomizer.utility.EntityUtil;
import genandnic.randomizer.utility.RandomUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = MCRandomizer.MODID, name = MCRandomizer.NAME, version = MCRandomizer.VERSION)
public class MCRandomizer {

	@Instance
	public static MCRandomizer instance;

	public static final String MODID = "mcrandomizer";
	public static final String NAME = "MCRandomizer";
	public static final String VERSION = "1.12.2-1.0";

	public static final String CLIENT_PROXY = "genandnic.randomizer.client.ClientProxy";
	public static final String SERVER_PROXY = "genandnic.randomizer.common.CommonProxy";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		int id = 0;
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, EntityRandom.NAME), EntityRandom.class, EntityRandom.NAME, id++, MCRandomizer.instance, 0, 1, false,
				RandomUtil.rgbColor(16, 16, 24), RandomUtil.rgbColor(60, 48, 86));

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(new RandomListener());

		// EntityRegistry.registerModEntity(new ResourceLocation(MCRandomizer.MODID, EntityConcussionCreeper.NAME), EntityConcussionCreeper.class,
		// EntityConcussionCreeper.NAME, id++,
		// MCRandomizer.instance, 10, 1, false, 5576214, 15721297);

		proxy.init(event);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		EntityUtil.populateLists();
		proxy.postInit(event);

	}

}
