package automatedConstructionSite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import repast.simphony.util.collections.Pair;

public class LoadMap {

	public int width;
	public int height;
	public List<Pair<Integer, Integer>> walls;
	public List<Pair<Integer, Pair<Integer, Integer>>> robots;
	public List<Pair<Integer, Integer>> air;
	
	public LoadMap(Path path) {
		this.width = 0;
		this.height = 0;
		this.walls = new ArrayList<>();
		this.robots = new ArrayList<>();
		this.air = new ArrayList<>();
		this.load(path);
	}
	
	public void load(Path path) {
		try {
			Stream<String> lines = Files.lines(path);
			Object[] lineArray = lines.toArray();
			
			String[] wh = ((String) lineArray[0]).split(",");
			this.width = Integer.parseInt(wh[0]);
			this.height = Integer.parseInt(wh[1]);
			
			for (int i = 0; i < this.height; i++) {
				String l = (String) lineArray[i + 1];
				for (int j = 0; j < this.width; j++) {
					if (l.charAt(j) == 'W') {
						this.walls.add(new Pair<Integer, Integer>(j, i));
					} else if (l.charAt(j) == '.') {
						continue;
					} else if (l.charAt(j) == '~') {
						this.air.add(new Pair<Integer, Integer>(j, i));
					} else {
						this.robots.add(new Pair<Integer, Pair<Integer, Integer>>(
								Character.getNumericValue(l.charAt(j)),
								new Pair<Integer, Integer>(j, i)
							)
						);
					}
				}
			}
			
			lines.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	
}
