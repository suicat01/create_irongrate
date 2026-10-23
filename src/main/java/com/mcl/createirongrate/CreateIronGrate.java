package com.mcl.createirongrate;

import com.mcl.createirongrate.block.LavaIronGrateCopperBoxBlock;
import com.mcl.createirongrate.blockentity.InfiniteLavaTankBlockEntity;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(CreateIronGrate.MOD_ID)
public class CreateIronGrate {

    public static final String MOD_ID = "create_irongrate";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);

    // 含熔岩的铁丝网铜箱：硬度与石头相近，无正确工具也不影响掉落
    public static final RegistryObject<Block> LAVA_IRON_GRATE_COPPER_BOX = BLOCKS.register(
            "lava_iron_grate_copper_box",
            () -> new LavaIronGrateCopperBoxBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .strength(3.5F, 6.0F)
                    .sound(SoundType.COPPER)));

    public static final RegistryObject<Item> LAVA_IRON_GRATE_COPPER_BOX_ITEM = ITEMS.register(
            "lava_iron_grate_copper_box",
            () -> new BlockItem(LAVA_IRON_GRATE_COPPER_BOX.get(), new Item.Properties()));

    public static final RegistryObject<BlockEntityType<InfiniteLavaTankBlockEntity>> INFINITE_LAVA_TANK_BE =
            BLOCK_ENTITIES.register("infinite_lava_tank",
                    () -> BlockEntityType.Builder
                            .of(InfiniteLavaTankBlockEntity::new, LAVA_IRON_GRATE_COPPER_BOX.get())
                            .build(null));

    public CreateIronGrate(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // 客户端设置：铁丝网铜箱使用 cutout 渲染类型，确保透明孔不写入深度、透出内层岩浆
    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() ->
                ItemBlockRenderTypes.setRenderLayer(LAVA_IRON_GRATE_COPPER_BOX.get(), RenderType.cutout()));
    }

    // 将方块放入机械动力的主创造模式物品栏
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceLocation createTab = ResourceLocation.tryParse("create:base");
        if (event.getTabKey() != null && event.getTabKey().location().equals(createTab)) {
            event.accept(LAVA_IRON_GRATE_COPPER_BOX_ITEM.get());
        }
    }
}
