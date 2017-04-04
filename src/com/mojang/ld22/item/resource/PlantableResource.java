package com.mojang.ld22.item.resource;

import com.mojang.ld22.Game;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import java.util.Arrays;
import java.util.List;

public class PlantableResource extends Resource {
	private List<Tile> sourceTiles; // list of tiles it can be planted on
	private Tile targetTile; // what the source tile turns into when planted.

	public PlantableResource(String name, int sprite, int color, Tile targetTile, Tile... sourceTiles1) {
		this(name, sprite, color, targetTile, Arrays.asList(sourceTiles1)); // calls other constructor
		/*
			"Obj... name" as a parameter can be used to specify an indefinite number of parameters, without making it a list! So useful...
		*/
	}

	public PlantableResource(String name, int sprite, int color, Tile targetTile, List<Tile> sourceTiles) {
		super(name, sprite, color);
		this.sourceTiles = sourceTiles;
		this.targetTile = targetTile;
	}
	
	/** Determines what happens when the resource is used on a certain tile */
	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (sourceTiles.contains(tile)) {
			level.setTile(xt, yt, targetTile, 0);
			return true;
		}
		// at this point this resource cannot be planted on the given tile.
		
		if (name == "Plank Wall" || name == "Wood Door") {
			//if (!sourceTiles.contains(tile)) {
				//Game.infoplank = true;
				player.game.notifications.add("Can only be placed on planks!");
			//}
		}
		/*if (name == "Wood Door") {
			if (!sourceTiles.contains(tile)) {
				//Game.infoplank = true;
				player.game.notifications.add("Can only be placed on planks!");
			}
		}*/
		if (name == "St.BrickWall" || name == "Stone Door") {
			//if (!sourceTiles.contains(tile)) {
				//Game.infosbrick = true;
				player.game.notifications.add("Can only be placed on stone brick!");
			//}
		}
		/*if (name == "Stone Door") {
			if (!sourceTiles.contains(tile)) {
				//Game.infosbrick = true;
				player.game.notifications.add("Can only be placed on stone brick!");
			}
		}*/
		return false;
	}
}
