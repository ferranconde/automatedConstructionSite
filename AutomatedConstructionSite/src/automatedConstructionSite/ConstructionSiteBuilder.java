/**
 * 
 */
package automatedConstructionSite;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;

import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.grid.GridFactory;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.continuous.SimpleCartesianAdder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.util.collections.Pair;


public class ConstructionSiteBuilder implements ContextBuilder<Object> {

	@Override
	public Context build(Context<Object> context) {
		// It has to match the project name and the context id in context.xml
		context.setId("AutomatedConstructionSite");
		
		LoadMap map = new LoadMap(Path.of("data/houses.txt"));
		// Choose CNET vs DynCNET
		boolean dynamic = true;
		
		ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder.createContinuousSpaceFactory(null);
		ContinuousSpace<Object> space = spaceFactory.createContinuousSpace(
			"space",
			context,
			new SimpleCartesianAdder<Object>(),
			new repast.simphony.space.continuous.StrictBorders(),
			map.width,
			map.height
		);
		
		GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);
		Grid<Object> grid = gridFactory.createGrid(
			"grid",
			context,
			new GridBuilderParameters<Object>(
				new repast.simphony.space.grid.StrictBorders(),
				new SimpleGridAdder<Object>(),
				true,
				map.width,
				map.height
			)
		);
		
		
		for (Pair<Integer, Integer> wpos : map.walls) {
			Wall w = new Wall(space, grid, false, dynamic);
			context.add(w);
			grid.moveTo(w, wpos.getFirst(), wpos.getSecond());
			space.moveTo(w, wpos.getFirst(), wpos.getSecond());
		}
		
		for (Pair<Integer, Pair<Integer, Integer>> rdata : map.robots) {
			Pair<Integer, Integer> rpos = rdata.getSecond();
			Robot r = new Robot(space, grid, Robot.Action.values()[rdata.getFirst()], dynamic);
			context.add(r);
			grid.moveTo(r, rpos.getFirst(), rpos.getSecond());
			space.moveTo(r, rpos.getFirst(), rpos.getSecond());
		}
		
		context.add(map.air);
		
		return context;
	}

	
	
}
