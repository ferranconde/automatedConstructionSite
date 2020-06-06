<?xml version="1.0" encoding="UTF-8"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns="http://repast.sf.net/statecharts" xmlns:notation="http://www.eclipse.org/gmf/runtime/1.0.2/notation">
  <StateMachine xmi:id="__pSmIZ9WEeqSgMxfrOAmyg" agentType="automatedConstructionSite.Robot" package="automatedConstructionSite.chart" className="RobotStatechart" nextID="44" id="RobotStatechart" uuid="__pSmIJ9WEeqSgMxfrOAmyg">
    <states xmi:type="PseudoState" xmi:id="_ARkuIJ9XEeqSgMxfrOAmyg" id="Entry State Pointer" type="entry"/>
    <states xmi:type="State" xmi:id="_CczPkJ9XEeqSgMxfrOAmyg" id="Voting" uuid="_CczPkZ9XEeqSgMxfrOAmyg"/>
    <states xmi:type="State" xmi:id="_ExTo0J9XEeqSgMxfrOAmyg" id="Intentional" uuid="_ExTo0Z9XEeqSgMxfrOAmyg"/>
    <states xmi:type="State" xmi:id="_HY3g8J9XEeqSgMxfrOAmyg" id="Switch Initiator" uuid="_HY3g8Z9XEeqSgMxfrOAmyg"/>
    <states xmi:type="State" xmi:id="_I_XksJ9XEeqSgMxfrOAmyg" id="Execute" uuid="_I_XksZ9XEeqSgMxfrOAmyg"/>
    <states xmi:type="FinalState" xmi:id="_J4kdkJ9XEeqSgMxfrOAmyg" id="Final" uuid="_J4kdkZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_LLVtAJ9XEeqSgMxfrOAmyg" from="_I_XksJ9XEeqSgMxfrOAmyg" to="_J4kdkJ9XEeqSgMxfrOAmyg" id="Transition 5" uuid="_LLVtAZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_MnN1IJ9XEeqSgMxfrOAmyg" from="_ARkuIJ9XEeqSgMxfrOAmyg" to="_CczPkJ9XEeqSgMxfrOAmyg" id="Transition 6" uuid="_MnN1IZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_NikqIJ9XEeqSgMxfrOAmyg" from="_CczPkJ9XEeqSgMxfrOAmyg" to="_ExTo0J9XEeqSgMxfrOAmyg" triggerType="message" messageCheckerClass="Object" messageCheckerCode="((Message) message).performative == Message.Performative.INFORM;" messageCheckerCodeImports="" id="Transition 7" uuid="_NikqIZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_OQaAgJ9XEeqSgMxfrOAmyg" from="_ExTo0J9XEeqSgMxfrOAmyg" to="_CczPkJ9XEeqSgMxfrOAmyg" id="Transition 8" uuid="_OQaAgZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_ZjtgwJ9XEeqSgMxfrOAmyg" from="_ExTo0J9XEeqSgMxfrOAmyg" to="_I_XksJ9XEeqSgMxfrOAmyg" id="Transition 9" uuid="_ZjtgwZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_aGTQcJ9XEeqSgMxfrOAmyg" from="_I_XksJ9XEeqSgMxfrOAmyg" to="_ExTo0J9XEeqSgMxfrOAmyg" id="Transition 10" uuid="_aGTQcZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_au46cJ9XEeqSgMxfrOAmyg" from="_ExTo0J9XEeqSgMxfrOAmyg" to="_HY3g8J9XEeqSgMxfrOAmyg" id="Transition 11" uuid="_au46cZ9XEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_bXyGcJ9XEeqSgMxfrOAmyg" from="_HY3g8J9XEeqSgMxfrOAmyg" to="_ExTo0J9XEeqSgMxfrOAmyg" id="Transition 12" uuid="_bXyGcZ9XEeqSgMxfrOAmyg"/>
  </StateMachine>
  <notation:Diagram xmi:id="__pSmIp9WEeqSgMxfrOAmyg" type="Statechart" element="__pSmIZ9WEeqSgMxfrOAmyg" name="robotstatechart.rsc" measurementUnit="Pixel">
    <children xmi:type="notation:Shape" xmi:id="_ARnxcJ9XEeqSgMxfrOAmyg" type="2007" element="_ARkuIJ9XEeqSgMxfrOAmyg" fontName="Segoe UI">
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_ARnxcZ9XEeqSgMxfrOAmyg" x="147" y="118"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_Ccz2oJ9XEeqSgMxfrOAmyg" type="2003" element="_CczPkJ9XEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_Ccz2op9XEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_Ccz2oZ9XEeqSgMxfrOAmyg" x="84" y="192" width="145" height="61"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_ExUP4J9XEeqSgMxfrOAmyg" type="2003" element="_ExTo0J9XEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_ExUP4p9XEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_ExUP4Z9XEeqSgMxfrOAmyg" x="84" y="312" width="145" height="61"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_HY4IAJ9XEeqSgMxfrOAmyg" type="2003" element="_HY3g8J9XEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_HY4IAp9XEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_HY4IAZ9XEeqSgMxfrOAmyg" x="300" y="312" width="181" height="61"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_I_YLwJ9XEeqSgMxfrOAmyg" type="2003" element="_I_XksJ9XEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_I_YLwp9XEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_I_YLwZ9XEeqSgMxfrOAmyg" x="84" y="444" width="145" height="61"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_J4kdkp9XEeqSgMxfrOAmyg" type="2008" element="_J4kdkJ9XEeqSgMxfrOAmyg" fontName="Segoe UI">
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_J4kdk59XEeqSgMxfrOAmyg" x="149" y="576"/>
    </children>
    <styles xmi:type="notation:DiagramStyle" xmi:id="__pSmI59WEeqSgMxfrOAmyg"/>
    <edges xmi:type="notation:Edge" xmi:id="_LLVtAp9XEeqSgMxfrOAmyg" type="4001" element="_LLVtAJ9XEeqSgMxfrOAmyg" source="_I_YLwJ9XEeqSgMxfrOAmyg" target="_J4kdkp9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_LLVtA59XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_LLVtBJ9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_LLVtBZ9XEeqSgMxfrOAmyg" points="[0, 31, 0, -78]$[0, 102, 0, -7]"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_LLW7IJ9XEeqSgMxfrOAmyg" id="NORTH"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_MnN1Ip9XEeqSgMxfrOAmyg" type="4001" element="_MnN1IJ9XEeqSgMxfrOAmyg" source="_ARnxcJ9XEeqSgMxfrOAmyg" target="_Ccz2oJ9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_MnN1I59XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_MnN1JJ9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_MnN1JZ9XEeqSgMxfrOAmyg" points="[0, 0, 1, -94]$[-9, 125, -8, 31]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_MnPDQJ9XEeqSgMxfrOAmyg" id="CENTER"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_NikqIp9XEeqSgMxfrOAmyg" type="4001" element="_NikqIJ9XEeqSgMxfrOAmyg" source="_Ccz2oJ9XEeqSgMxfrOAmyg" target="_ExUP4J9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_NilRMJ9XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_NilRMZ9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_NilRMp9XEeqSgMxfrOAmyg" points="[-9, 19, 0, -90]$[-30, 109, -21, 0]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_Nil4QJ9XEeqSgMxfrOAmyg" id="(0.20689655172413793,0.6885245901639344)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_Nil4QZ9XEeqSgMxfrOAmyg" id="(0.14482758620689656,0.5081967213114754)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_OQankJ9XEeqSgMxfrOAmyg" type="4001" element="_OQaAgJ9XEeqSgMxfrOAmyg" source="_ExUP4J9XEeqSgMxfrOAmyg" target="_Ccz2oJ9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_OQankZ9XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_OQankp9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_OQank59XEeqSgMxfrOAmyg" points="[-3, -26, 0, 98]$[31, -132, 34, -8]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_OQbOoJ9XEeqSgMxfrOAmyg" id="(0.7862068965517242,0.4262295081967213)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_OQbOoZ9XEeqSgMxfrOAmyg" id="(0.7655172413793103,0.36065573770491804)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_Zjtgwp9XEeqSgMxfrOAmyg" type="4001" element="_ZjtgwJ9XEeqSgMxfrOAmyg" source="_ExUP4J9XEeqSgMxfrOAmyg" target="_I_YLwJ9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_Zjtgw59XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_ZjtgxJ9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_ZjtgxZ9XEeqSgMxfrOAmyg" points="[0, 17, 0, -104]$[-23, 122, -23, 1]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_Zjuu4J9XEeqSgMxfrOAmyg" id="(0.15862068965517243,0.7213114754098361)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_Zjuu4Z9XEeqSgMxfrOAmyg" id="(0.15862068965517243,0.5409836065573771)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_aGTQcp9XEeqSgMxfrOAmyg" type="4001" element="_aGTQcJ9XEeqSgMxfrOAmyg" source="_I_YLwJ9XEeqSgMxfrOAmyg" target="_ExUP4J9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_aGTQc59XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_aGTQdJ9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_aGTQdZ9XEeqSgMxfrOAmyg" points="[-5, -25, 0, 98]$[31, -120, 36, 3]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_aGUekJ9XEeqSgMxfrOAmyg" id="(0.7862068965517242,0.4098360655737705)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_aGUekZ9XEeqSgMxfrOAmyg" id="(0.7517241379310344,0.5573770491803278)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_au5hgJ9XEeqSgMxfrOAmyg" type="4001" element="_au46cJ9XEeqSgMxfrOAmyg" source="_ExUP4J9XEeqSgMxfrOAmyg" target="_HY4IAJ9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_au5hgZ9XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_au5hgp9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_au5hg59XEeqSgMxfrOAmyg" points="[30, -4, -152, 0]$[175, -16, -7, -12]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_au6IkJ9XEeqSgMxfrOAmyg" id="(0.7931034482758621,0.26229508196721313)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_au6IkZ9XEeqSgMxfrOAmyg" id="(0.44751381215469616,0.19672131147540983)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_bXytgJ9XEeqSgMxfrOAmyg" type="4001" element="_bXyGcJ9XEeqSgMxfrOAmyg" source="_HY4IAJ9XEeqSgMxfrOAmyg" target="_ExUP4J9XEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_bXytgZ9XEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_bXytgp9XEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_bXytg59XEeqSgMxfrOAmyg" points="[-31, 2, 119, 0]$[-132, 15, 18, 13]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_bXzUkJ9XEeqSgMxfrOAmyg" id="(0.1712707182320442,0.7540983606557377)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_bXzUkZ9XEeqSgMxfrOAmyg" id="(0.6689655172413793,0.7868852459016393)"/>
    </edges>
  </notation:Diagram>
</xmi:XMI>
