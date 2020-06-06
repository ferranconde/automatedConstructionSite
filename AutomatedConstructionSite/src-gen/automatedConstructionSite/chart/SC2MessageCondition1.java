package automatedConstructionSite.chart;

import repast.simphony.statecharts.*;
import repast.simphony.parameter.Parameters;
import static repast.simphony.random.RandomHelper.*;
import repast.simphony.statecharts.generator.GeneratedFor;

import static repast.simphony.essentials.RepastEssentials.*;

import automatedConstructionSite.*;

/**
 *  MessageCondition for Transition 8, from = Awarding, to = Assigned.
 */
@GeneratedFor("_Q-dqkJ9JEeqSgMxfrOAmyg")
public class SC2MessageCondition1 implements MessageCondition<Wall, Object> {
	@Override
	public boolean isTrue(Wall agent, Transition<Wall> transition, Object message, Parameters params) throws Exception {
		return ((Message) message).performative == Message.Performative.INFORM;

	}
}
