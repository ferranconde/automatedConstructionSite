package automatedConstructionSite;

import java.awt.Color;

import repast.simphony.visualizationOGL2D.DefaultStyleOGL2D;
import saf.v3d.scene.VSpatial;

public class WallStyle extends DefaultStyleOGL2D {

	@Override
	public Color getColor(Object o) {
		if (o instanceof Wall) {
			Wall w = (Wall) o;
			return w.getColor();
		} else {
			return Color.decode("FF9999");
		}
	}
	
	@Override
	public VSpatial getVSpatial(Object agent, VSpatial spatial) {
	    if (spatial == null) {
	      spatial = shapeFactory.createRectangle(15, 15, true);
	    }
	    return spatial;
	  }
	
}
