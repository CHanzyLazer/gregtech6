/**
 * Copyright (c) 2022 GregTech-6 Team
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregapi.old;

import gregapi.GT_API;
import gregapi.render.BlockTextureDefault;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.render.IconContainerCopied;
import gregapi.util.UT;
import gregtechCH.data.CS_CH;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import static gregapi.data.CS.*;

public class Textures {
	public enum BlockIcons implements IIconContainer, Runnable {
		  VOID, RENDERING_ERROR
		, LOGISTICS_WIRE, LOGISTICS_WIRE_OVERLAY, FIBER_WIRE, FIBER_WIRE_OVERLAY, PIPE_RESTRICTOR, PIPE_RESTRICTOR_TINY, PIPE_RESTRICTOR_SMALL, PIPE_RESTRICTOR_MEDIUM, PIPE_RESTRICTOR_LARGE, PIPE_RESTRICTOR_HUGE
		, INSULATION_BUNDLED, INSULATION_PRIVATE, INSULATION_FULL, INSULATION_TINY, INSULATION_SMALL, INSULATION_MEDIUM, INSULATION_LARGE, INSULATION_HUGE
		, ASPHALT, CONCRETE, CONCRETE_REINFORCED, CFOAM_FRESH, CFOAM_HARDENED, CFOAM_FRESH_OWNED, CFOAM_HARDENED_OWNED, GLASS_CLEAR, CRATE, COIN, COIN_SIDE, COIN_TOP, COIN_BOTTOM
		, FLUID_SPRING, GREG_O_LANTERN
		
		, ZPM_TOP, ZPM_SIDES, ZPM_BOTTOM
		, ANEUTRONIC_FUSION_TOP, ANEUTRONIC_FUSION_SIDES, ANEUTRONIC_FUSION_BOTTOM
		, DUCT_TAPE
		
		, MUD, CLAY_BROWN, TURF, CLAY_RED, CLAY_YELLOW, CLAY_BLUE, CLAY_WHITE
		, SAND_MAGNETITE, SAND_BASALT_MAGNETITE, SAND_GRANITE_MAGNETITE
		
		, PATH_TOP, PATH_SIDE, PATH_SLAB
		, GRASSBLOCK_TOP_MEDIUM , GRASSBLOCK_TOP_LIGHT , GRASSBLOCK_TOP_DARK , GRASSBLOCK_TOP_NORMAL
		, GRASSBLOCK_SIDE_MEDIUM, GRASSBLOCK_SIDE_LIGHT, GRASSBLOCK_SIDE_DARK, GRASSBLOCK_SIDE_NORMAL
		// GTCH
		, ARROW_UP, ARROW_DOWN, ARROW_LEFT, ARROW_RIGHT
		, ARROW2_UP, ARROW2_DOWN, ARROW2_LEFT, ARROW2_RIGHT
		, ARROW3_UP, ARROW3_DOWN, ARROW3_LEFT, ARROW3_RIGHT
		, INSULATION_AROUND, INSULATION_QUADRUPLE, INSULATION_NONUPLE
		// GTCH
		, AXLE_CLOCKWISE_FAST, AXLE_COUNTERCLOCKWISE_FAST, AXLE_DOWN_FAST, AXLE_UP_FAST, AXLE_LEFT_FAST, AXLE_RIGHT_FAST

		, AXLE, AXLE_CLOCKWISE, AXLE_COUNTERCLOCKWISE, AXLE_VERTICAL, AXLE_DOWN, AXLE_UP, AXLE_HORIZONTAL, AXLE_LEFT, AXLE_RIGHT
		, GEAR, GEAR_CLOCKWISE, GEAR_COUNTERCLOCKWISE, GEARBOX, GEARBOX_AXLE
		, PISTON_IDLE, PISTON_MOVING
		, MACHINE, PLATE, HATCH
		
		, LONG_DIST_WIRE_EV, LONG_DIST_WIRE_IV, LONG_DIST_WIRE_LuV, LONG_DIST_WIRE_ZPM, LONG_DIST_WIRE_UV
		, LONG_DIST_PIPE_ITEM
		, LONG_DIST_PIPE_FLUID
		
		, RAIL_STRAIGHT_ALUMINIUM
		, RAIL_STRAIGHT_MAGNALIUM
		, RAIL_STRAIGHT_BRONZE
		, RAIL_STRAIGHT_IRON
		, RAIL_STRAIGHT_STAINLESSSTEEL
		, RAIL_STRAIGHT_STEEL
		, RAIL_STRAIGHT_TITANIUM
		, RAIL_STRAIGHT_TUNGSTEN
		, RAIL_STRAIGHT_TUNGSTENCARBIDE
		, RAIL_STRAIGHT_TUNGSTENSTEEL
		, RAIL_STRAIGHT_ADAMANTIUM
		
		, RAIL_TURNED_ALUMINIUM
		, RAIL_TURNED_MAGNALIUM
		, RAIL_TURNED_BRONZE
		, RAIL_TURNED_IRON
		, RAIL_TURNED_STAINLESSSTEEL
		, RAIL_TURNED_STEEL
		, RAIL_TURNED_TITANIUM
		, RAIL_TURNED_TUNGSTEN
		, RAIL_TURNED_TUNGSTENCARBIDE
		, RAIL_TURNED_TUNGSTENSTEEL
		, RAIL_TURNED_ADAMANTIUM
		
		, RAIL_BOOSTER_ALUMINIUM
		, RAIL_BOOSTER_MAGNALIUM
		, RAIL_BOOSTER_BRONZE
		, RAIL_BOOSTER_IRON
		, RAIL_BOOSTER_STAINLESSSTEEL
		, RAIL_BOOSTER_STEEL
		, RAIL_BOOSTER_TITANIUM
		, RAIL_BOOSTER_TUNGSTEN
		, RAIL_BOOSTER_TUNGSTENCARBIDE
		, RAIL_BOOSTER_TUNGSTENSTEEL
		, RAIL_BOOSTER_ADAMANTIUM
		
		, RAIL_BOOSTER_ACTIVE_ALUMINIUM
		, RAIL_BOOSTER_ACTIVE_MAGNALIUM
		, RAIL_BOOSTER_ACTIVE_BRONZE
		, RAIL_BOOSTER_ACTIVE_IRON
		, RAIL_BOOSTER_ACTIVE_STAINLESSSTEEL
		, RAIL_BOOSTER_ACTIVE_STEEL
		, RAIL_BOOSTER_ACTIVE_TITANIUM
		, RAIL_BOOSTER_ACTIVE_TUNGSTEN
		, RAIL_BOOSTER_ACTIVE_TUNGSTENCARBIDE
		, RAIL_BOOSTER_ACTIVE_TUNGSTENSTEEL
		, RAIL_BOOSTER_ACTIVE_ADAMANTIUM
		
		, RAIL_DETECTOR_ALUMINIUM
		, RAIL_DETECTOR_MAGNALIUM
		, RAIL_DETECTOR_BRONZE
		, RAIL_DETECTOR_IRON
		, RAIL_DETECTOR_STAINLESSSTEEL
		, RAIL_DETECTOR_STEEL
		, RAIL_DETECTOR_TITANIUM
		, RAIL_DETECTOR_TUNGSTEN
		, RAIL_DETECTOR_TUNGSTENCARBIDE
		, RAIL_DETECTOR_TUNGSTENSTEEL
		, RAIL_DETECTOR_ADAMANTIUM
		
		, RAIL_DETECTOR_ACTIVE_ALUMINIUM
		, RAIL_DETECTOR_ACTIVE_MAGNALIUM
		, RAIL_DETECTOR_ACTIVE_BRONZE
		, RAIL_DETECTOR_ACTIVE_IRON
		, RAIL_DETECTOR_ACTIVE_STAINLESSSTEEL
		, RAIL_DETECTOR_ACTIVE_STEEL
		, RAIL_DETECTOR_ACTIVE_TITANIUM
		, RAIL_DETECTOR_ACTIVE_TUNGSTEN
		, RAIL_DETECTOR_ACTIVE_TUNGSTENCARBIDE
		, RAIL_DETECTOR_ACTIVE_TUNGSTENSTEEL
		, RAIL_DETECTOR_ACTIVE_ADAMANTIUM
		
		, SAPLING_SMALL_RUBBER, SAPLING_SMALL_MAPLE, SAPLING_SMALL_WILLOW, SAPLING_SMALL_BLUEMAHOE, SAPLING_SMALL_HAZEL, SAPLING_SMALL_COCONUT, SAPLING_SMALL_CINNAMON, SAPLING_SMALL_RAINBOWOOD, SAPLING_SMALL_BLUESPRUCE  
		, SAPLING_LARGE_RUBBER, SAPLING_LARGE_MAPLE, SAPLING_LARGE_WILLOW, SAPLING_LARGE_BLUEMAHOE, SAPLING_LARGE_HAZEL, SAPLING_LARGE_COCONUT, SAPLING_LARGE_CINNAMON, SAPLING_LARGE_RAINBOWOOD, SAPLING_LARGE_BLUESPRUCE  
		, LEAVES_RUBBER       , LEAVES_MAPLE       , LEAVES_WILLOW       , LEAVES_BLUEMAHOE       , LEAVES_HAZEL       , LEAVES_COCONUT       , LEAVES_CINNAMON       , LEAVES_RAINBOWOOD       , LEAVES_BLUESPRUCE         
		, LEAVES_OPAQUE_RUBBER, LEAVES_OPAQUE_MAPLE, LEAVES_OPAQUE_WILLOW, LEAVES_OPAQUE_BLUEMAHOE, LEAVES_OPAQUE_HAZEL, LEAVES_OPAQUE_COCONUT, LEAVES_OPAQUE_CINNAMON, LEAVES_OPAQUE_RAINBOWOOD, LEAVES_OPAQUE_BLUESPRUCE  
		, PLANKS_RUBBER       , PLANKS_MAPLE       , PLANKS_WILLOW       , PLANKS_BLUEMAHOE       , PLANKS_HAZEL       , PLANKS_COCONUT       , PLANKS_CINNAMON       , PLANKS_RAINBOWOOD       , PLANKS_BLUESPRUCE         
		, LOG_SIDE_RUBBER     , LOG_SIDE_MAPLE     , LOG_SIDE_WILLOW     , LOG_SIDE_BLUEMAHOE     , LOG_SIDE_HAZEL     , LOG_SIDE_COCONUT     , LOG_SIDE_CINNAMON     , LOG_SIDE_RAINBOWOOD     , LOG_SIDE_BLUESPRUCE       
		, LOG_TOP_RUBBER      , LOG_TOP_MAPLE      , LOG_TOP_WILLOW      , LOG_TOP_BLUEMAHOE      , LOG_TOP_HAZEL      , LOG_TOP_COCONUT      , LOG_TOP_CINNAMON      , LOG_TOP_RAINBOWOOD      , LOG_TOP_BLUESPRUCE        
		, BEAM_SIDE_RUBBER    , BEAM_SIDE_MAPLE    , BEAM_SIDE_WILLOW    , BEAM_SIDE_BLUEMAHOE    , BEAM_SIDE_HAZEL    , BEAM_SIDE_COCONUT    , BEAM_SIDE_CINNAMON    , BEAM_SIDE_RAINBOWOOD    , BEAM_SIDE_BLUESPRUCE      
		, BEAM_TOP_RUBBER     , BEAM_TOP_MAPLE     , BEAM_TOP_WILLOW     , BEAM_TOP_BLUEMAHOE     , BEAM_TOP_HAZEL     , BEAM_TOP_COCONUT     , BEAM_TOP_CINNAMON     , BEAM_TOP_RAINBOWOOD     , BEAM_TOP_BLUESPRUCE       
		
		, BEAM_SIDE_OAK, BEAM_SIDE_SPRUCE, BEAM_SIDE_BIRCH, BEAM_SIDE_JUNGLE, BEAM_SIDE_ACACIA, BEAM_SIDE_DARKOAK, BEAM_SIDE_RUBBERWOOD, BEAM_SIDE_WOOD, BEAM_SIDE_GREATWOOD, BEAM_SIDE_SILVERWOOD, BEAM_SIDE_SKYROOT, BEAM_SIDE_DARKWOOD
		, BEAM_TOP_OAK , BEAM_TOP_SPRUCE , BEAM_TOP_BIRCH , BEAM_TOP_JUNGLE , BEAM_TOP_ACACIA , BEAM_TOP_DARKOAK , BEAM_TOP_RUBBERWOOD , BEAM_TOP_WOOD , BEAM_TOP_GREATWOOD , BEAM_TOP_SILVERWOOD , BEAM_TOP_SKYROOT , BEAM_TOP_DARKWOOD 
		, LOG_SIDE_DRY , LOG_SIDE_ROTTEN , LOG_SIDE_MOSSY , LOG_SIDE_FROZEN
		, LOG_TOP_DRY  , LOG_TOP_ROTTEN  , LOG_TOP_MOSSY  , LOG_TOP_FROZEN
		
		, GRASS_SIDE, GRASS_SIDE_DRY, GRASS_SIDE_MOLDY, GRASS_SIDE_ROTTEN
		, GRASS_TOP , GRASS_TOP_DRY , GRASS_TOP_MOLDY , GRASS_TOP_ROTTEN
		, RYE_SIDE  , OAT_SIDE      , BARLEY_SIDE     , RICE_SIDE
		, RYE_TOP   , OAT_TOP       , BARLEY_TOP      , RICE_TOP
		
		, LEAVES_MAPLE_YELLOW, LEAVES_OPAQUE_MAPLE_YELLOW, LEAVES_MAPLE_ORANGE, LEAVES_OPAQUE_MAPLE_ORANGE, LEAVES_MAPLE_RED, LEAVES_OPAQUE_MAPLE_RED, LEAVES_MAPLE_BROWN, LEAVES_OPAQUE_MAPLE_BROWN, LEAVES_BLUESPRUCE_XMAS, LEAVES_OPAQUE_BLUESPRUCE_XMAS, PLANKS_COMPRESSED, PLANKS_WOOD, PLANKS_TREATED, PLANKS_DRY, PLANKS_ROTTEN, PLANKS_MOSSY, PLANKS_FROZEN, LOG_HOLE_RUBBER, LOG_RESIN_RUBBER, LOG_HOLE_MAPLE, LOG_SAP_MAPLE, LOG_HOLE_RAINBOWOOD, LOG_SAP_RAINBOWOOD
		
		, FLOWER_ALTERED_ANDESITE_BUCKWHEAT, FLOWER_CROSBY_BUCKWHEAT, FLOWER_SAGEBRUSH, FLOWER_FOUR_WING_SALTBUSH, FLOWER_DESERT_TRUMPET, FLOWER_ALPINE_CATCHFLY, FLOWER_COPPER_PLANT, FLOWER_VIOLA_CALAMINARIA, FLOWER_THLASPI_LERESCHIANUM, FLOWER_PRINCE_S_PLUME, FLOWER_TUFTED_EVENING_PRIMROSE, FLOWER_THOMPSONS_LOCOWEED, FLOWER_NARCISSUS_SHELDONIA, FLOWER_ORECHID, FLOWER_PANDANUS_CANDELABRUM, FLOWER_HEXALILY, FLOWER_TUNGSTUS
		, GLOWTUS_BLACK, GLOWTUS_RED, GLOWTUS_GREEN, GLOWTUS_BROWN, GLOWTUS_BLUE, GLOWTUS_PURPLE, GLOWTUS_CYAN, GLOWTUS_LIGHT_GRAY, GLOWTUS_GRAY, GLOWTUS_PINK, GLOWTUS_LIME, GLOWTUS_YELLOW, GLOWTUS_LIGHT_BLUE, GLOWTUS_MAGENTA, GLOWTUS_ORANGE, GLOWTUS_WHITE
		
		, ORE_ANTHRACITE, ORE_LIGNITE, ORE_SALT, ORE_ROCKSALT, ORE_BAUXITE, ORE_OIL, ORE_GYPSUM, ORE_MILKYQUARTZ, ORE_NETHERQUARTZ
		, ORE_SULFUR, ORE_APATITE, ORE_RUBY, ORE_AMBER, ORE_AMETHYST, ORE_GALENA, ORE_TETRAHEDRITE, ORE_CASSITERITE, ORE_SHELDONITE, ORE_PENTLANDITE, ORE_SCHEELITE, ORE_RUTILE, ORE_BASTNASITE, ORE_GRAPHITE, ORE_PITCHBLENDE, ORE_BORAX
		
		, CRYSTAL_ORE_ARSENOPYRITE, CRYSTAL_ORE_CHALCOPYRITE, CRYSTAL_ORE_CINNABAR, CRYSTAL_ORE_COBALTITE, CRYSTAL_ORE_GALENA, CRYSTAL_ORE_KESTERITE, CRYSTAL_ORE_MOLYBDENITE, CRYSTAL_ORE_PYRITE, CRYSTAL_ORE_SPHALERITE, CRYSTAL_ORE_STANNITE, CRYSTAL_ORE_STIBNITE, CRYSTAL_ORE_TETRAHEDRITE
		;
		
		protected IIcon mIcon;
		
		@Override public IIcon getIcon(int aRenderPass) {return mIcon;}
		
		private BlockIcons() {
			if (GT_API.sBlockIconload != null) GT_API.sBlockIconload.add(this);
		}
		
		@Override
		public void run() {
			mIcon = GT_API.sBlockIcons.registerIcon(RES_PATH_BLOCK + "iconsets/" + this);
		}
		
		@Override
		public ResourceLocation getTextureFile() {
			return TextureMap.locationBlocksTexture;
		}
		
		public static final IIconContainer[]
		BALES_GRASS = {
			GRASS_TOP,
			GRASS_SIDE,
			GRASS_TOP_DRY,
			GRASS_SIDE_DRY,
			GRASS_TOP_MOLDY,
			GRASS_SIDE_MOLDY,
			GRASS_TOP_ROTTEN,
			GRASS_SIDE_ROTTEN,
		},
		BALES_CROP = {
			RYE_TOP,
			RYE_SIDE,
			OAT_TOP,
			OAT_SIDE,
			BARLEY_TOP,
			BARLEY_SIDE,
			RICE_TOP,
			RICE_SIDE,
		},
		LOGS_1 = {
			LOG_TOP_DRY,
			LOG_SIDE_DRY,
			LOG_TOP_ROTTEN,
			LOG_SIDE_ROTTEN,
			LOG_TOP_MOSSY,
			LOG_SIDE_MOSSY,
			LOG_TOP_FROZEN,
			LOG_SIDE_FROZEN,
		},
		LOGS_A = {
			LOG_TOP_RUBBER,
			LOG_SIDE_RUBBER,
			LOG_TOP_MAPLE,
			LOG_SIDE_MAPLE,
			LOG_TOP_WILLOW,
			LOG_SIDE_WILLOW,
			LOG_TOP_BLUEMAHOE,
			LOG_SIDE_BLUEMAHOE,
		},
		LOGS_B = {
			LOG_TOP_HAZEL,
			LOG_SIDE_HAZEL,
			LOG_TOP_CINNAMON,
			LOG_SIDE_CINNAMON,
			LOG_TOP_COCONUT,
			LOG_SIDE_COCONUT,
			LOG_TOP_RAINBOWOOD,
			LOG_SIDE_RAINBOWOOD,
		},
		LOGS_C = {
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
		},
		LOGS_D = {
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
			LOG_TOP_BLUESPRUCE,
			LOG_SIDE_BLUESPRUCE,
		},
		BEAMS_1 = {
			BEAM_TOP_OAK,
			BEAM_SIDE_OAK,
			BEAM_TOP_SPRUCE,
			BEAM_SIDE_SPRUCE,
			BEAM_TOP_BIRCH,
			BEAM_SIDE_BIRCH,
			BEAM_TOP_JUNGLE,
			BEAM_SIDE_JUNGLE,
		},
		BEAMS_2 = {
			BEAM_TOP_ACACIA,
			BEAM_SIDE_ACACIA,
			BEAM_TOP_DARKOAK,
			BEAM_SIDE_DARKOAK,
			BEAM_TOP_RUBBERWOOD,
			BEAM_SIDE_RUBBERWOOD,
			BEAM_TOP_WOOD,
			BEAM_SIDE_WOOD,
		},
		BEAMS_3 = {
			BEAM_TOP_GREATWOOD,
			BEAM_SIDE_GREATWOOD,
			BEAM_TOP_SILVERWOOD,
			BEAM_SIDE_SILVERWOOD,
			BEAM_TOP_SKYROOT,
			BEAM_SIDE_SKYROOT,
			BEAM_TOP_DARKWOOD,
			BEAM_SIDE_DARKWOOD,
		},
		BEAMS_A = {
			BEAM_TOP_RUBBER,
			BEAM_SIDE_RUBBER,
			BEAM_TOP_MAPLE,
			BEAM_SIDE_MAPLE,
			BEAM_TOP_WILLOW,
			BEAM_SIDE_WILLOW,
			BEAM_TOP_BLUEMAHOE,
			BEAM_SIDE_BLUEMAHOE,
		},
		BEAMS_B = {
			BEAM_TOP_HAZEL,
			BEAM_SIDE_HAZEL,
			BEAM_TOP_CINNAMON,
			BEAM_SIDE_CINNAMON,
			BEAM_TOP_COCONUT,
			BEAM_SIDE_COCONUT,
			BEAM_TOP_RAINBOWOOD,
			BEAM_SIDE_RAINBOWOOD,
		},
		BEAMS_C = {
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
		},
		BEAMS_D = {
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
			BEAM_TOP_BLUESPRUCE,
			BEAM_SIDE_BLUESPRUCE,
		},
		PLANKS = {
			PLANKS_RUBBER,
			PLANKS_MAPLE,
			PLANKS_WILLOW,
			PLANKS_BLUEMAHOE,
			PLANKS_HAZEL,
			PLANKS_CINNAMON,
			PLANKS_COCONUT,
			PLANKS_RAINBOWOOD,
			PLANKS_COMPRESSED,
			PLANKS_WOOD,
			PLANKS_TREATED,
			CRATE,
			PLANKS_DRY,
			PLANKS_ROTTEN,
			PLANKS_MOSSY,
			PLANKS_FROZEN,
		},
		PLANKS_2 = {
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
			PLANKS_BLUESPRUCE,
		},
		LEAVES_AB = {
			LEAVES_RUBBER,
			LEAVES_MAPLE,
			LEAVES_WILLOW,
			LEAVES_BLUEMAHOE,
			LEAVES_HAZEL,
			LEAVES_CINNAMON,
			LEAVES_COCONUT,
			LEAVES_RAINBOWOOD,
			LEAVES_OPAQUE_RUBBER,
			LEAVES_OPAQUE_MAPLE,
			LEAVES_OPAQUE_WILLOW,
			LEAVES_OPAQUE_BLUEMAHOE,
			LEAVES_OPAQUE_HAZEL,
			LEAVES_OPAQUE_CINNAMON,
			LEAVES_OPAQUE_COCONUT,
			LEAVES_OPAQUE_RAINBOWOOD,
		},
		LEAVES_CD = {
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
			LEAVES_OPAQUE_BLUESPRUCE,
		},
		SAPLINGS_AB = {
			SAPLING_SMALL_RUBBER,
			SAPLING_SMALL_MAPLE,
			SAPLING_SMALL_WILLOW,
			SAPLING_SMALL_BLUEMAHOE,
			SAPLING_SMALL_HAZEL,
			SAPLING_SMALL_CINNAMON,
			SAPLING_SMALL_COCONUT,
			SAPLING_SMALL_RAINBOWOOD,
			
			SAPLING_LARGE_RUBBER,
			SAPLING_LARGE_MAPLE,
			SAPLING_LARGE_WILLOW,
			SAPLING_LARGE_BLUEMAHOE,
			SAPLING_LARGE_HAZEL,
			SAPLING_LARGE_CINNAMON,
			SAPLING_LARGE_COCONUT,
			SAPLING_LARGE_RAINBOWOOD,
		},
		SAPLINGS_CD = {
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			SAPLING_SMALL_BLUESPRUCE,
			
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
			SAPLING_LARGE_BLUESPRUCE,
		},
		FLOWERS_A = {
			FLOWER_ALTERED_ANDESITE_BUCKWHEAT,
			FLOWER_CROSBY_BUCKWHEAT,
			FLOWER_ALPINE_CATCHFLY,
			FLOWER_VIOLA_CALAMINARIA,
			FLOWER_THLASPI_LERESCHIANUM,
			FLOWER_TUFTED_EVENING_PRIMROSE,
			FLOWER_NARCISSUS_SHELDONIA,
			FLOWER_ORECHID,
			FLOWER_HEXALILY,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
		},
		FLOWERS_B = {
			FLOWER_SAGEBRUSH,
			FLOWER_FOUR_WING_SALTBUSH,
			FLOWER_DESERT_TRUMPET,
			FLOWER_COPPER_PLANT,
			FLOWER_PRINCE_S_PLUME,
			FLOWER_THOMPSONS_LOCOWEED,
			FLOWER_PANDANUS_CANDELABRUM,
			FLOWER_TUNGSTUS,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
			FLOWER_ORECHID,
		},
		GLOWTUS = {
			GLOWTUS_BLACK,
			GLOWTUS_RED,
			GLOWTUS_GREEN,
			GLOWTUS_BROWN,
			GLOWTUS_BLUE,
			GLOWTUS_PURPLE,
			GLOWTUS_CYAN,
			GLOWTUS_LIGHT_GRAY,
			GLOWTUS_GRAY,
			GLOWTUS_PINK,
			GLOWTUS_LIME,
			GLOWTUS_YELLOW,
			GLOWTUS_LIGHT_BLUE,
			GLOWTUS_MAGENTA,
			GLOWTUS_ORANGE,
			GLOWTUS_WHITE,
		},
		SANDS = {
			SAND_MAGNETITE,
			SAND_BASALT_MAGNETITE,
			SAND_GRANITE_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
			SAND_MAGNETITE,
		},
		DIGGABLES = {
			MUD,
			CLAY_BROWN,
			TURF,
			CLAY_RED,
			CLAY_YELLOW,
			CLAY_BLUE,
			CLAY_WHITE,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
			CLAY_BROWN,
		},
		GRASSES_TOP = {
			GRASSBLOCK_TOP_MEDIUM,
			GRASSBLOCK_TOP_LIGHT,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_NORMAL,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
			GRASSBLOCK_TOP_DARK,
		},
		GRASSES_SIDE = {
			GRASSBLOCK_SIDE_MEDIUM,
			GRASSBLOCK_SIDE_LIGHT,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_NORMAL,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
			GRASSBLOCK_SIDE_DARK,
		},
		DIRTS = {
			new IconContainerCopied(Blocks.dirt, 0, SIDE_BOTTOM),
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
			PATH_TOP,
		},
		VANILLA_ORES_A = {
			ORE_SULFUR,
			ORE_APATITE,
			ORE_RUBY,
			ORE_AMBER,
			ORE_AMETHYST,
			ORE_GALENA,
			ORE_TETRAHEDRITE,
			ORE_CASSITERITE,
			ORE_SHELDONITE,
			ORE_PENTLANDITE,
			ORE_SCHEELITE,
			ORE_RUTILE,
			ORE_BASTNASITE,
			ORE_GRAPHITE,
			ORE_PITCHBLENDE,
			ORE_BORAX
		},
		ROCK_ORES = {
			ORE_ANTHRACITE,
			ORE_LIGNITE,
			ORE_SALT,
			ORE_ROCKSALT,
			ORE_BAUXITE,
			ORE_OIL,
			ORE_GYPSUM,
			ORE_MILKYQUARTZ,
			ORE_NETHERQUARTZ,
			ORE_ANTHRACITE,
			ORE_ANTHRACITE,
			ORE_ANTHRACITE,
			ORE_ANTHRACITE,
			ORE_ANTHRACITE,
			ORE_ANTHRACITE,
			ORE_ANTHRACITE,
		},
		CRYSTAL_ORES = {
			CRYSTAL_ORE_ARSENOPYRITE,
			CRYSTAL_ORE_CHALCOPYRITE,
			CRYSTAL_ORE_CINNABAR,
			CRYSTAL_ORE_COBALTITE,
			CRYSTAL_ORE_GALENA,
			CRYSTAL_ORE_KESTERITE,
			CRYSTAL_ORE_MOLYBDENITE,
			CRYSTAL_ORE_PYRITE,
			CRYSTAL_ORE_SPHALERITE,
			CRYSTAL_ORE_STANNITE,
			CRYSTAL_ORE_STIBNITE,
			CRYSTAL_ORE_TETRAHEDRITE,
			CRYSTAL_ORE_ARSENOPYRITE,
			CRYSTAL_ORE_ARSENOPYRITE,
			CRYSTAL_ORE_ARSENOPYRITE,
			CRYSTAL_ORE_ARSENOPYRITE,
		},
		LONG_DIST_WIRES_01 = {
			LONG_DIST_WIRE_EV,
			LONG_DIST_WIRE_EV,
			LONG_DIST_WIRE_IV,
			LONG_DIST_WIRE_LuV,
			LONG_DIST_WIRE_LuV,
			LONG_DIST_WIRE_LuV,
			LONG_DIST_WIRE_LuV,
			LONG_DIST_WIRE_LuV,
			LONG_DIST_WIRE_ZPM,
			LONG_DIST_WIRE_ZPM,
			LONG_DIST_WIRE_ZPM,
			LONG_DIST_WIRE_ZPM,
			LONG_DIST_WIRE_UV,
			LONG_DIST_WIRE_UV,
			LONG_DIST_WIRE_UV,
			LONG_DIST_WIRE_UV,
		},
		LONG_DIST_PIPES_01 = {
			LONG_DIST_PIPE_ITEM,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
			LONG_DIST_PIPE_FLUID,
		},
		
		GLASSES_CLEAR = UT.Code.fill(GLASS_CLEAR, new IIconContainer[16]),
		ASPHALTS = UT.Code.fill(ASPHALT, new IIconContainer[16]),
		CFOAMS = UT.Code.fill(CFOAM_HARDENED, new IIconContainer[16]),
		CFOAMS_FRESH = UT.Code.fill(CFOAM_FRESH, new IIconContainer[16]),
		CONCRETES = UT.Code.fill(CONCRETE, new IIconContainer[16]),
		CONCRETES_REINFORCED = UT.Code.fill(CONCRETE_REINFORCED, new IIconContainer[16]);
		
		// GTCH, 还是统一使用 switch 来实现, 用于指明管道方向
		public static BlockIcons getArrow(CS_CH.IconType aIconType, CS_CH.PipeMode aMode) {
			switch (aIconType) {
			case SIDE_UP:
				switch (aMode) {case LIMIT: return ARROW_UP; case PRIORITY: return ARROW2_UP; case DIVIDE: return ARROW3_UP; case DEFAULT: default: return VOID;}
			case SIDE_DOWN:
				switch (aMode) {case LIMIT: return ARROW_DOWN; case PRIORITY: return ARROW2_DOWN; case DIVIDE: return ARROW3_DOWN; case DEFAULT: default: return VOID;}
			case SIDE_LEFT:
				switch (aMode) {case LIMIT: return ARROW_LEFT; case PRIORITY: return ARROW2_LEFT; case DIVIDE: return ARROW3_LEFT; case DEFAULT: default: return VOID;}
			case SIDE_RIGHT:
				switch (aMode) {case LIMIT: return ARROW_RIGHT; case PRIORITY: return ARROW2_RIGHT; case DIVIDE: return ARROW3_RIGHT; case DEFAULT: default: return VOID;}
			case VOID: case FRONT: case BACK: default:
				return VOID;
			}
		}
		// GTCH, 还是统一使用 switch 来实现, 用于指明轴的材质
		public static BlockIcons getAxle(CS_CH.IconType aIconType, boolean aStop, boolean aCounterClockwise, boolean aFast) {
			switch (aIconType) {
				case SIDE_UP:
					return aStop ? AXLE_HORIZONTAL : (aCounterClockwise ? (aFast ? AXLE_RIGHT_FAST : AXLE_RIGHT) : (aFast ? AXLE_LEFT_FAST : AXLE_LEFT));
				case SIDE_DOWN:
					return aStop ? AXLE_HORIZONTAL : (aCounterClockwise ? (aFast ? AXLE_LEFT_FAST : AXLE_LEFT) : (aFast ? AXLE_RIGHT_FAST : AXLE_RIGHT));
				case SIDE_LEFT:
					return aStop ? AXLE_VERTICAL : (aCounterClockwise ? (aFast ? AXLE_UP_FAST : AXLE_UP) : (aFast ? AXLE_DOWN_FAST : AXLE_DOWN));
				case SIDE_RIGHT:
					return aStop ? AXLE_VERTICAL : (aCounterClockwise ? (aFast ? AXLE_DOWN_FAST : AXLE_DOWN) : (aFast ? AXLE_UP_FAST : AXLE_UP));
				case FRONT:
					return aStop ? AXLE : (aCounterClockwise ? (aFast ? AXLE_COUNTERCLOCKWISE_FAST : AXLE_COUNTERCLOCKWISE) : (aFast ? AXLE_CLOCKWISE_FAST : AXLE_CLOCKWISE));
				case BACK:
					return aStop ? AXLE : (aCounterClockwise ? (aFast ? AXLE_CLOCKWISE_FAST : AXLE_CLOCKWISE) : (aFast ? AXLE_COUNTERCLOCKWISE_FAST : AXLE_COUNTERCLOCKWISE));
				case VOID: default:
					return VOID;
			}
		}
		
		public static class CustomIcon implements IIconContainer, Runnable {
			protected IIcon mIcon;
			protected String mIconName;
			
			@Override public IIcon getIcon(int aRenderPass) {return mIcon;}
			
			public CustomIcon(String aIconName) {
				mIconName = aIconName.indexOf(":") == -1 ? RES_PATH_BLOCK + aIconName : aIconName;
				if (GT_API.sBlockIconload != null) GT_API.sBlockIconload.add(this);
			}
			
			@Override
			public void run() {
				mIcon = GT_API.sBlockIcons.registerIcon(mIconName);
			}
			
			@Override
			public ResourceLocation getTextureFile() {
				return TextureMap.locationBlocksTexture;
			}
			
			@Override
			public short[] getIconColor(int aRenderPass) {
				return UNCOLOURED;
			}
			
			@Override
			public int getIconPasses() {
				return 1;
			}
			
			@Override
			public void registerIcons(IIconRegister aIconRegister) {
				//
			}
			
			@Override
			public boolean isUsingColorModulation(int aRenderPass) {
				return aRenderPass == 0;
			}
		}

		@Override
		public short[] getIconColor(int aRenderPass) {
			return UNCOLOURED;
		}

		@Override
		public int getIconPasses() {
			return 1;
		}

		@Override
		public void registerIcons(IIconRegister aIconRegister) {
			//
		}

		@Override
		public boolean isUsingColorModulation(int aRenderPass) {
			return aRenderPass == 0;
		}
	}
	
	public enum ItemIcons implements IIconContainer, Runnable {
		  VOID // The Empty Texture
		, RENDERING_ERROR
		, WRENCH, MONKEYWRENCH
		, CROWBAR
		, HAND_DRILL
		, JACKHAMMER
		, WIRE_CUTTER
		, FLINT_TINDER
		, BENDING_CYLINDER, BENDING_CYLINDER_SMALL, PINCERS
		, KNIFE, BUTCHERYKNIFE, SICKLE
		, SCOOP, GRAFTER, SCISSORS
		, PLUNGER, ROLLING_PIN, CLUB, MAGNIFYING_GLASS
		, PISTOL
		, HANDLE_PISTOL, HANDLE_SWORD, HANDLE_FILE, HANDLE_CHISEL, HANDLE_SAW, HANDLE_SCREWDRIVER, HANDLE_BUZZSAW, HANDLE_ELECTRIC_SCREWDRIVER, HANDLE_ELECTRIC_DRILL, TIP_ELECTRIC_DRILL, HANDLE_ELECTRIC_MIXER, TIP_ELECTRIC_MIXER, HANDLE_ELECTRIC_TRIMMER, TIP_ELECTRIC_TRIMMER
		, POCKET_MULTITOOL_CLOSED, POCKET_MULTITOOL_FILE, POCKET_MULTITOOL_KNIFE, POCKET_MULTITOOL_SAW, POCKET_MULTITOOL_CUTTER, POCKET_MULTITOOL_SCISSORS, POCKET_MULTITOOL_SCREWDRIVER, POCKET_MULTITOOL_CHISEL
		, POWER_UNIT_LV, POWER_UNIT_MV, POWER_UNIT_HV
		, DURABILITY_BAR_0, DURABILITY_BAR_1, DURABILITY_BAR_2, DURABILITY_BAR_3, DURABILITY_BAR_4, DURABILITY_BAR_5, DURABILITY_BAR_6, DURABILITY_BAR_7, DURABILITY_BAR_8
		, ENERGY_BAR_0, ENERGY_BAR_1, ENERGY_BAR_2, ENERGY_BAR_3, ENERGY_BAR_4, ENERGY_BAR_5, ENERGY_BAR_6, ENERGY_BAR_7, ENERGY_BAR_8
		, COMPASS_N(F), COMPASS_NNE(F), COMPASS_NE(F), COMPASS_NEE(F), COMPASS_E(F), COMPASS_SEE(F), COMPASS_SE(F), COMPASS_SSE(F), COMPASS_S(F), COMPASS_SSW(F), COMPASS_SW(F), COMPASS_SWW(F), COMPASS_W(F), COMPASS_NWW(F), COMPASS_NW(F), COMPASS_NNW(F)
		;
		
		public static final IIconContainer[]
		COMPASS = {
			COMPASS_N,
			COMPASS_NNE,
			COMPASS_NE,
			COMPASS_NEE,
			COMPASS_E,
			COMPASS_SEE,
			COMPASS_SE,
			COMPASS_SSE,
			COMPASS_S,
			COMPASS_SSW,
			COMPASS_SW,
			COMPASS_SWW,
			COMPASS_W,
			COMPASS_NWW,
			COMPASS_NW,
			COMPASS_NNW
		},
		DURABILITY_BAR = {
			DURABILITY_BAR_0,
			DURABILITY_BAR_1,
			DURABILITY_BAR_2,
			DURABILITY_BAR_3,
			DURABILITY_BAR_4,
			DURABILITY_BAR_5,
			DURABILITY_BAR_6,
			DURABILITY_BAR_7,
			DURABILITY_BAR_8,
		},
		ENERGY_BAR = {
			ENERGY_BAR_0,
			ENERGY_BAR_1,
			ENERGY_BAR_2,
			ENERGY_BAR_3,
			ENERGY_BAR_4,
			ENERGY_BAR_5,
			ENERGY_BAR_6,
			ENERGY_BAR_7,
			ENERGY_BAR_8,
		};
		
		public static final ITexture[] ERROR_RENDERING = new ITexture[] {BlockTextureDefault.get(RENDERING_ERROR)};
		
		protected IIcon mIcon, mOverlay;
		protected boolean mUseOverlay;
		
		@Override public IIcon getIcon(int aRenderPass) {return aRenderPass==1&&mOverlay!=null?mOverlay:mIcon;}
		
		private ItemIcons() {
			this(T);
		}
		
		private ItemIcons(boolean aUseOverlay) {
			mUseOverlay = aUseOverlay;
			if (GT_API.sItemIconload != null) GT_API.sItemIconload.add(this);
		}
		
		@Override
		public ResourceLocation getTextureFile() {
			return TextureMap.locationItemsTexture;
		}
		
		@Override
		public void run() {
			mIcon       = GT_API.sItemIcons.registerIcon(RES_PATH_ITEM + "iconsets/" + this);
			if (mUseOverlay)
			mOverlay    = GT_API.sItemIcons.registerIcon(RES_PATH_ITEM + "iconsets/" + this + "_OVERLAY");
		}
		
		public static class CustomIcon implements IIconContainer, Runnable {
			protected IIcon mIcon, mOverlay;
			protected String mIconName;
			
			@Override public IIcon getIcon(int aRenderPass) {return aRenderPass==1?mOverlay:mIcon;}
			
			public CustomIcon(String aIconName) {
				mIconName = aIconName.indexOf(":") == -1 ? RES_PATH_ITEM + aIconName : aIconName;
				if (GT_API.sItemIconload != null) GT_API.sItemIconload.add(this);
			}
			
			@Override
			public void run() {
				mIcon       = GT_API.sItemIcons.registerIcon(mIconName);
				mOverlay    = GT_API.sItemIcons.registerIcon(mIconName + "_OVERLAY");
			}
			
			@Override
			public ResourceLocation getTextureFile() {
				return TextureMap.locationItemsTexture;
			}
			@Override
			public short[] getIconColor(int aRenderPass) {
				return UNCOLOURED;
			}
			@Override
			public int getIconPasses() {
				return 2;
			}
			@Override
			public void registerIcons(IIconRegister aIconRegister) {
				//
			}

			@Override
			public boolean isUsingColorModulation(int aRenderPass) {
				return aRenderPass == 0;
			}
		}
		
		@Override
		public short[] getIconColor(int aRenderPass) {
			return UNCOLOURED;
		}
		@Override
		public int getIconPasses() {
			return 2;
		}
		@Override
		public void registerIcons(IIconRegister aIconRegister) {
			//
		}

		@Override
		public boolean isUsingColorModulation(int aRenderPass) {
			return aRenderPass == 0;
		}
	}
}
