package com.pringlebeaver.pcp.world.storage.loot;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.ILootCondition;

public class ForageLootContext{
    private final Random random;
    private final float luck;
    private final ServerWorld world;
    private final Function<ResourceLocation, LootTable> lootTableManager;
    private final Set<LootTable> lootTables = Sets.newLinkedHashSet();
    private final Function<ResourceLocation, ILootCondition> field_227499_f_;
    private final Set<ILootCondition> conditions = Sets.newLinkedHashSet();
    private final Map<LootParameter<?>, Object> parameters;
    private final Map<ResourceLocation, net.minecraft.world.storage.loot.LootContext.IDynamicDropProvider> field_216037_g;

    private ForageLootContext(Random rand, float luckIn, ServerWorld worldIn, Function<ResourceLocation, LootTable> lootTableManagerIn, Function<ResourceLocation, ILootCondition> p_i225885_5_, Map<LootParameter<?>, Object> parametersIn, Map<ResourceLocation, net.minecraft.world.storage.loot.LootContext.IDynamicDropProvider> conditionsIn) {
        this.random = rand;
        this.luck = luckIn;
        this.world = worldIn;
        this.lootTableManager = lootTableManagerIn;
        this.field_227499_f_ = p_i225885_5_;
        this.parameters = ImmutableMap.copyOf(parametersIn);
        this.field_216037_g = ImmutableMap.copyOf(conditionsIn);
    }

}