package automatedConstructionSite;

public class Message {
	
	public static enum Performative {
		ACCEPT_PROPOSAL,
		CALL_FOR_PROPOSAL,
		CANCEL,
		INFORM,
		PROPOSE,
		REJECT_PROPOSAL
	};
	
	public Agent sender;
	public Object content;
	public Performative performative;
	
	public Message(Agent sender, Object content, Performative performative) {
		this.sender = sender;
		this.content = content;
		this.performative = performative;
	}
}
