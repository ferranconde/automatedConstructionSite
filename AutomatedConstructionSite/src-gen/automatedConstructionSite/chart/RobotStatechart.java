
package automatedConstructionSite.chart;

import java.util.Map;
import java.util.HashMap;

import repast.simphony.statecharts.*;
import repast.simphony.statecharts.generator.GeneratedFor;

import automatedConstructionSite.*;

@GeneratedFor("__pSmIJ9WEeqSgMxfrOAmyg")
public class RobotStatechart extends DefaultStateChart<automatedConstructionSite.Robot> {

	public static RobotStatechart createStateChart(automatedConstructionSite.Robot agent, double begin) {
		RobotStatechart result = createStateChart(agent);
		StateChartScheduler.INSTANCE.scheduleBeginTime(begin, result);
		return result;
	}

	public static RobotStatechart createStateChart(automatedConstructionSite.Robot agent) {
		RobotStatechartGenerator generator = new RobotStatechartGenerator();
		return generator.build(agent);
	}

	private RobotStatechart(automatedConstructionSite.Robot agent) {
		super(agent);
	}

	private static class MyStateChartBuilder extends StateChartBuilder<automatedConstructionSite.Robot> {

		public MyStateChartBuilder(automatedConstructionSite.Robot agent,
				AbstractState<automatedConstructionSite.Robot> entryState, String entryStateUuid) {
			super(agent, entryState, entryStateUuid);
			setPriority(0.0);
		}

		@Override
		public RobotStatechart build() {
			RobotStatechart result = new RobotStatechart(getAgent());
			setStateChartProperties(result);
			return result;
		}
	}

	private static class RobotStatechartGenerator {

		private Map<String, AbstractState<Robot>> stateMap = new HashMap<String, AbstractState<Robot>>();

		public RobotStatechart build(Robot agent) {
			SimpleStateBuilder<Robot> ssBuilder1 = new SimpleStateBuilder<Robot>("Voting");
			SimpleState<Robot> s1 = ssBuilder1.build();
			stateMap.put("_CczPkZ9XEeqSgMxfrOAmyg", s1);
			MyStateChartBuilder mscb = new MyStateChartBuilder(agent, s1, "_CczPkZ9XEeqSgMxfrOAmyg");

			SimpleStateBuilder<Robot> ssBuilder2 = new SimpleStateBuilder<Robot>("Intentional");
			SimpleState<Robot> s2 = ssBuilder2.build();
			stateMap.put("_ExTo0Z9XEeqSgMxfrOAmyg", s2);
			mscb.addRootState(s2, "_ExTo0Z9XEeqSgMxfrOAmyg");
			SimpleStateBuilder<Robot> ssBuilder3 = new SimpleStateBuilder<Robot>("Switch Initiator");
			SimpleState<Robot> s3 = ssBuilder3.build();
			stateMap.put("_HY3g8Z9XEeqSgMxfrOAmyg", s3);
			mscb.addRootState(s3, "_HY3g8Z9XEeqSgMxfrOAmyg");
			SimpleStateBuilder<Robot> ssBuilder4 = new SimpleStateBuilder<Robot>("Execute");
			SimpleState<Robot> s4 = ssBuilder4.build();
			stateMap.put("_I_XksZ9XEeqSgMxfrOAmyg", s4);
			mscb.addRootState(s4, "_I_XksZ9XEeqSgMxfrOAmyg");
			FinalStateBuilder<Robot> ssBuilder5 = new FinalStateBuilder<Robot>("Final");
			FinalState<Robot> s5 = ssBuilder5.build();
			stateMap.put("_J4kdkZ9XEeqSgMxfrOAmyg", s5);
			mscb.addRootState(s5, "_J4kdkZ9XEeqSgMxfrOAmyg");
			createTransitions(mscb);
			return mscb.build();

		}

		private void createTransitions(MyStateChartBuilder mscb) {
			// creates transition Transition 5
			createTransition1(mscb);
			// creates transition Transition 7
			createTransition2(mscb);
			// creates transition Transition 8
			createTransition3(mscb);
			// creates transition Transition 9
			createTransition4(mscb);
			// creates transition Transition 10
			createTransition5(mscb);
			// creates transition Transition 11
			createTransition6(mscb);
			// creates transition Transition 12
			createTransition7(mscb);

		}

		// creates transition Transition 5, from = Execute, to = Final
		private void createTransition1(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 5",
					stateMap.get("_I_XksZ9XEeqSgMxfrOAmyg"), stateMap.get("_J4kdkZ9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_LLVtAZ9XEeqSgMxfrOAmyg");
		}

		// creates transition Transition 7, from = Voting, to = Intentional
		private void createTransition2(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 7",
					stateMap.get("_CczPkZ9XEeqSgMxfrOAmyg"), stateMap.get("_ExTo0Z9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new MessageTrigger<Robot>(
					new MessageConditionMessageChecker<Robot, Object>(new SC1MessageCondition2(), Object.class), 1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_NikqIZ9XEeqSgMxfrOAmyg");
		}

		// creates transition Transition 8, from = Intentional, to = Voting
		private void createTransition3(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 8",
					stateMap.get("_ExTo0Z9XEeqSgMxfrOAmyg"), stateMap.get("_CczPkZ9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_OQaAgZ9XEeqSgMxfrOAmyg");
		}

		// creates transition Transition 9, from = Intentional, to = Execute
		private void createTransition4(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 9",
					stateMap.get("_ExTo0Z9XEeqSgMxfrOAmyg"), stateMap.get("_I_XksZ9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_ZjtgwZ9XEeqSgMxfrOAmyg");
		}

		// creates transition Transition 10, from = Execute, to = Intentional
		private void createTransition5(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 10",
					stateMap.get("_I_XksZ9XEeqSgMxfrOAmyg"), stateMap.get("_ExTo0Z9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_aGTQcZ9XEeqSgMxfrOAmyg");
		}

		// creates transition Transition 11, from = Intentional, to = Switch Initiator
		private void createTransition6(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 11",
					stateMap.get("_ExTo0Z9XEeqSgMxfrOAmyg"), stateMap.get("_HY3g8Z9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_au46cZ9XEeqSgMxfrOAmyg");
		}

		// creates transition Transition 12, from = Switch Initiator, to = Intentional
		private void createTransition7(MyStateChartBuilder mscb) {
			TransitionBuilder<Robot> tb = new TransitionBuilder<Robot>("Transition 12",
					stateMap.get("_HY3g8Z9XEeqSgMxfrOAmyg"), stateMap.get("_ExTo0Z9XEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_bXyGcZ9XEeqSgMxfrOAmyg");
		}

	}
}
