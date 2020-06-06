
package automatedConstructionSite.chart;

import java.util.Map;
import java.util.HashMap;

import repast.simphony.statecharts.*;
import repast.simphony.statecharts.generator.GeneratedFor;

import automatedConstructionSite.*;

@GeneratedFor("_Q-dqkJ9JEeqSgMxfrOAmyg")
public class WallStatechart extends DefaultStateChart<automatedConstructionSite.Wall> {

	public static WallStatechart createStateChart(automatedConstructionSite.Wall agent, double begin) {
		WallStatechart result = createStateChart(agent);
		StateChartScheduler.INSTANCE.scheduleBeginTime(begin, result);
		return result;
	}

	public static WallStatechart createStateChart(automatedConstructionSite.Wall agent) {
		WallStatechartGenerator generator = new WallStatechartGenerator();
		return generator.build(agent);
	}

	private WallStatechart(automatedConstructionSite.Wall agent) {
		super(agent);
	}

	private static class MyStateChartBuilder extends StateChartBuilder<automatedConstructionSite.Wall> {

		public MyStateChartBuilder(automatedConstructionSite.Wall agent,
				AbstractState<automatedConstructionSite.Wall> entryState, String entryStateUuid) {
			super(agent, entryState, entryStateUuid);
			setPriority(0.0);
		}

		@Override
		public WallStatechart build() {
			WallStatechart result = new WallStatechart(getAgent());
			setStateChartProperties(result);
			return result;
		}
	}

	private static class WallStatechartGenerator {

		private Map<String, AbstractState<Wall>> stateMap = new HashMap<String, AbstractState<Wall>>();

		public WallStatechart build(Wall agent) {
			SimpleStateBuilder<Wall> ssBuilder1 = new SimpleStateBuilder<Wall>("Awarding");
			SimpleState<Wall> s1 = ssBuilder1.build();
			stateMap.put("_in1YMJ9NEeqSgMxfrOAmyg", s1);
			MyStateChartBuilder mscb = new MyStateChartBuilder(agent, s1, "_in1YMJ9NEeqSgMxfrOAmyg");

			SimpleStateBuilder<Wall> ssBuilder2 = new SimpleStateBuilder<Wall>("Assigned");
			SimpleState<Wall> s2 = ssBuilder2.build();
			stateMap.put("_lzLS0Z9NEeqSgMxfrOAmyg", s2);
			mscb.addRootState(s2, "_lzLS0Z9NEeqSgMxfrOAmyg");
			SimpleStateBuilder<Wall> ssBuilder3 = new SimpleStateBuilder<Wall>("Switch Participant");
			SimpleState<Wall> s3 = ssBuilder3.build();
			stateMap.put("_oGickJ9NEeqSgMxfrOAmyg", s3);
			mscb.addRootState(s3, "_oGickJ9NEeqSgMxfrOAmyg");
			SimpleStateBuilder<Wall> ssBuilder4 = new SimpleStateBuilder<Wall>("Executing");
			SimpleState<Wall> s4 = ssBuilder4.build();
			stateMap.put("_cz4AEZ9OEeqSgMxfrOAmyg", s4);
			mscb.addRootState(s4, "_cz4AEZ9OEeqSgMxfrOAmyg");
			FinalStateBuilder<Wall> ssBuilder5 = new FinalStateBuilder<Wall>("Final");
			FinalState<Wall> s5 = ssBuilder5.build();
			stateMap.put("_fmFB8Z9OEeqSgMxfrOAmyg", s5);
			mscb.addRootState(s5, "_fmFB8Z9OEeqSgMxfrOAmyg");
			createTransitions(mscb);
			return mscb.build();

		}

		private void createTransitions(MyStateChartBuilder mscb) {
			// creates transition Transition 8
			createTransition1(mscb);
			// creates transition Transition 11
			createTransition2(mscb);
			// creates transition Transition 12
			createTransition3(mscb);
			// creates transition Transition 13
			createTransition4(mscb);
			// creates transition Transition 15
			createTransition5(mscb);
			// creates transition Transition 17
			createTransition6(mscb);

		}

		// creates transition Transition 8, from = Awarding, to = Assigned
		private void createTransition1(MyStateChartBuilder mscb) {
			TransitionBuilder<Wall> tb = new TransitionBuilder<Wall>("Transition 8",
					stateMap.get("_in1YMJ9NEeqSgMxfrOAmyg"), stateMap.get("_lzLS0Z9NEeqSgMxfrOAmyg"));
			tb.addTrigger(new MessageTrigger<Wall>(
					new MessageConditionMessageChecker<Wall, Object>(new SC2MessageCondition1(), Object.class), 1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_6-VpAJ9NEeqSgMxfrOAmyg");
		}

		// creates transition Transition 11, from = Assigned, to = Switch Participant
		private void createTransition2(MyStateChartBuilder mscb) {
			TransitionBuilder<Wall> tb = new TransitionBuilder<Wall>("Transition 11",
					stateMap.get("_lzLS0Z9NEeqSgMxfrOAmyg"), stateMap.get("_oGickJ9NEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_LFZMIZ9OEeqSgMxfrOAmyg");
		}

		// creates transition Transition 12, from = Switch Participant, to = Assigned
		private void createTransition3(MyStateChartBuilder mscb) {
			TransitionBuilder<Wall> tb = new TransitionBuilder<Wall>("Transition 12",
					stateMap.get("_oGickJ9NEeqSgMxfrOAmyg"), stateMap.get("_lzLS0Z9NEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_LqBjMJ9OEeqSgMxfrOAmyg");
		}

		// creates transition Transition 13, from = Assigned, to = Awarding
		private void createTransition4(MyStateChartBuilder mscb) {
			TransitionBuilder<Wall> tb = new TransitionBuilder<Wall>("Transition 13",
					stateMap.get("_lzLS0Z9NEeqSgMxfrOAmyg"), stateMap.get("_in1YMJ9NEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_Um_eMJ9OEeqSgMxfrOAmyg");
		}

		// creates transition Transition 15, from = Assigned, to = Executing
		private void createTransition5(MyStateChartBuilder mscb) {
			TransitionBuilder<Wall> tb = new TransitionBuilder<Wall>("Transition 15",
					stateMap.get("_lzLS0Z9NEeqSgMxfrOAmyg"), stateMap.get("_cz4AEZ9OEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_eRWDoZ9OEeqSgMxfrOAmyg");
		}

		// creates transition Transition 17, from = Executing, to = Final
		private void createTransition6(MyStateChartBuilder mscb) {
			TransitionBuilder<Wall> tb = new TransitionBuilder<Wall>("Transition 17",
					stateMap.get("_cz4AEZ9OEeqSgMxfrOAmyg"), stateMap.get("_fmFB8Z9OEeqSgMxfrOAmyg"));
			tb.addTrigger(new AlwaysTrigger(1.0));
			tb.setPriority(0.0);
			mscb.addRegularTransition(tb.build(), "_hkWsgZ9OEeqSgMxfrOAmyg");
		}

	}
}
