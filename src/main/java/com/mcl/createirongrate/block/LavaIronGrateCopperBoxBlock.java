package com.mcl.createirongrate.block;

import com.mcl.createirongrate.CreateIronGrate;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LavaIronGrateCopperBoxBlock extends Block implements EntityBlock, IWrenchable {

    public LavaIronGrateCopperBoxBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CreateIronGrate.INFINITE_LAVA_TANK_BE.get().create(pos, state);
    }

    // 机械动力扳手：右键直接快捷拆卸（复用 Create 内置的潜行拆卸逻辑，含破坏事件、掉落与音效）
    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        return onSneakWrenched(state, context);
    }
}
