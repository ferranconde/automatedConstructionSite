package automatedConstructionSite;

import java.awt.Color;

import repast.simphony.visualizationOGL2D.DefaultStyleOGL2D;
import saf.v3d.scene.VSpatial;

public class RobotStyle extends DefaultStyleOGL2D {

	@Override
	public Color getColor(Object o) {
		if (o instanceof Robot) {
			Robot r = (Robot) o;
			return r.getColor();
		} else {
			return Color.decode("FF9999");
		}
	}
	
	@Override
	public int getBorderSize(Object o) {
		return 1;
	}
	
	@Override
	public VSpatial getVSpatial(Object agent, VSpatial spatial) {
	    if (spatial == null) {
	      spatial = shapeFactory.createCircle(5, 15);
	    }
	    return spatial;
	  }
	
}
