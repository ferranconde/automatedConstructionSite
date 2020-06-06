package automatedConstructionSite.chart;

import repast.simphony.statecharts.*;
import repast.simphony.parameter.Parameters;
import static repast.simphony.random.RandomHelper.*;
import repast.simphony.statecharts.generator.GeneratedFor;

import static repast.simphony.essentials.RepastEssentials.*;

import automatedConstructionSite.*;

/**
 *  MessageCondition for Transition 7, from = Voting, to = Intentional.
 */
@GeneratedFor("__pSmIJ9WEeqSgMxfrOAmyg")
public class SC1MessageCondition2 implements MessageCondition<Robot, Object> {
	@Override
	public boolean isTrue(Robot agent, Transition<Robot> transition, Object message, Parameters params)
			throws Exception {
		return ((Message) message).performative == Message.Performative.INFORM;

	}
}
