<?xml version="1.0" encoding="UTF-8"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns="http://repast.sf.net/statecharts" xmlns:notation="http://www.eclipse.org/gmf/runtime/1.0.2/notation">
  <StateMachine xmi:id="_Q-dqkZ9JEeqSgMxfrOAmyg" agentType="automatedConstructionSite.Wall" package="automatedConstructionSite.chart" className="WallStatechart" nextID="56" id="WallStatechart" uuid="_Q-dqkJ9JEeqSgMxfrOAmyg">
    <states xmi:type="PseudoState" xmi:id="_gzUtoJ9NEeqSgMxfrOAmyg" id="Entry State Pointer" type="entry"/>
    <states xmi:type="State" xmi:id="_in0xIJ9NEeqSgMxfrOAmyg" id="Awarding" uuid="_in1YMJ9NEeqSgMxfrOAmyg"/>
    <states xmi:type="State" xmi:id="_lzLS0J9NEeqSgMxfrOAmyg" id="Assigned" uuid="_lzLS0Z9NEeqSgMxfrOAmyg"/>
    <states xmi:type="State" xmi:id="_oGh1gJ9NEeqSgMxfrOAmyg" id="Switch Participant" uuid="_oGickJ9NEeqSgMxfrOAmyg"/>
    <states xmi:type="State" xmi:id="_cz4AEJ9OEeqSgMxfrOAmyg" id="Executing" uuid="_cz4AEZ9OEeqSgMxfrOAmyg"/>
    <states xmi:type="FinalState" xmi:id="_fmFB8J9OEeqSgMxfrOAmyg" id="Final" uuid="_fmFB8Z9OEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_0a5xMJ9NEeqSgMxfrOAmyg" from="_gzUtoJ9NEeqSgMxfrOAmyg" to="_in0xIJ9NEeqSgMxfrOAmyg" id="Transition 7" uuid="_0a5xMZ9NEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_6-VB8J9NEeqSgMxfrOAmyg" from="_in0xIJ9NEeqSgMxfrOAmyg" to="_lzLS0J9NEeqSgMxfrOAmyg" triggerType="message" messageCheckerClass="Object" messageCheckerCode="((Message) message).performative == Message.Performative.INFORM;" messageCheckerCodeImports="" id="Transition 8" uuid="_6-VpAJ9NEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_LFZMIJ9OEeqSgMxfrOAmyg" from="_lzLS0J9NEeqSgMxfrOAmyg" to="_oGh1gJ9NEeqSgMxfrOAmyg" messageCheckerClass="Object" id="Transition 11" uuid="_LFZMIZ9OEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_LqA8IJ9OEeqSgMxfrOAmyg" from="_oGh1gJ9NEeqSgMxfrOAmyg" to="_lzLS0J9NEeqSgMxfrOAmyg" messageCheckerClass="Object" id="Transition 12" uuid="_LqBjMJ9OEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_Um-3IJ9OEeqSgMxfrOAmyg" from="_lzLS0J9NEeqSgMxfrOAmyg" to="_in0xIJ9NEeqSgMxfrOAmyg" messageCheckerClass="Object" id="Transition 13" uuid="_Um_eMJ9OEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_eRWDoJ9OEeqSgMxfrOAmyg" from="_lzLS0J9NEeqSgMxfrOAmyg" to="_cz4AEJ9OEeqSgMxfrOAmyg" messageCheckerClass="Object" id="Transition 15" uuid="_eRWDoZ9OEeqSgMxfrOAmyg"/>
    <transitions xmi:type="Transition" xmi:id="_hkWsgJ9OEeqSgMxfrOAmyg" from="_cz4AEJ9OEeqSgMxfrOAmyg" to="_fmFB8J9OEeqSgMxfrOAmyg" messageCheckerClass="Object" id="Transition 17" uuid="_hkWsgZ9OEeqSgMxfrOAmyg"/>
  </StateMachine>
  <notation:Diagram xmi:id="_Q_UmMJ9JEeqSgMxfrOAmyg" type="Statechart" element="_Q-dqkZ9JEeqSgMxfrOAmyg" name="wallstatechart.rsc" measurementUnit="Pixel">
    <children xmi:type="notation:Shape" xmi:id="_gzXJ4J9NEeqSgMxfrOAmyg" type="2007" element="_gzUtoJ9NEeqSgMxfrOAmyg" fontName="Segoe UI">
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_gzXJ4Z9NEeqSgMxfrOAmyg" x="65" y="39"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_in1_QJ9NEeqSgMxfrOAmyg" type="2003" element="_in0xIJ9NEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_in1_Qp9NEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_in1_QZ9NEeqSgMxfrOAmyg" x="60" y="120" width="109" height="61"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_lzL54J9NEeqSgMxfrOAmyg" type="2003" element="_lzLS0J9NEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_lzMg8J9NEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_lzL54Z9NEeqSgMxfrOAmyg" x="336" y="126" width="145" height="49"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_oGjDoJ9NEeqSgMxfrOAmyg" type="2003" element="_oGh1gJ9NEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_oGjDop9NEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_oGjDoZ9NEeqSgMxfrOAmyg" x="600" y="126" width="157" height="49"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_cz4AEp9OEeqSgMxfrOAmyg" type="2003" element="_cz4AEJ9OEeqSgMxfrOAmyg" fontName="Segoe UI">
      <children xmi:type="notation:DecorationNode" xmi:id="_cz4nIJ9OEeqSgMxfrOAmyg" type="5001"/>
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_cz4AE59OEeqSgMxfrOAmyg" x="339" y="192" width="140" height="48"/>
    </children>
    <children xmi:type="notation:Shape" xmi:id="_fmFpAJ9OEeqSgMxfrOAmyg" type="2008" element="_fmFB8J9OEeqSgMxfrOAmyg" fontName="Segoe UI">
      <layoutConstraint xmi:type="notation:Bounds" xmi:id="_fmFpAZ9OEeqSgMxfrOAmyg" x="401" y="264"/>
    </children>
    <styles xmi:type="notation:DiagramStyle" xmi:id="_Q_UmMZ9JEeqSgMxfrOAmyg"/>
    <edges xmi:type="notation:Edge" xmi:id="_0a9bkJ9NEeqSgMxfrOAmyg" type="4001" element="_0a5xMJ9NEeqSgMxfrOAmyg" source="_gzXJ4J9NEeqSgMxfrOAmyg" target="_in1_QJ9NEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_0a9bkZ9NEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_0a9bkp9NEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_0a9bk59NEeqSgMxfrOAmyg" points="[0, 0, -4, -87]$[-15, 85, -19, -2]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_0bPvcJ9NEeqSgMxfrOAmyg" id="CENTER"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_0bPvcZ9NEeqSgMxfrOAmyg" id="(0.1743119266055046,0.45901639344262296)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_6-WQEJ9NEeqSgMxfrOAmyg" type="4001" element="_6-VB8J9NEeqSgMxfrOAmyg" source="_in1_QJ9NEeqSgMxfrOAmyg" target="_lzL54J9NEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_6-WQEZ9NEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_6-WQEp9NEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_6-WQE59NEeqSgMxfrOAmyg" points="[-23, -12, -23, -141]$[0, 129, 0, 0]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_6-XeMJ9NEeqSgMxfrOAmyg" id="(0.21100917431192662,0.2459016393442623)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_6-YFQJ9NEeqSgMxfrOAmyg" id="(0.15862068965517243,0.0)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_LFZzMJ9OEeqSgMxfrOAmyg" type="4001" element="_LFZMIJ9OEeqSgMxfrOAmyg" source="_lzL54J9NEeqSgMxfrOAmyg" target="_oGjDoJ9NEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_LFZzMZ9OEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_LFZzMp9OEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_LFZzM59OEeqSgMxfrOAmyg" points="[4, 0, -173, -12]$[99, 0, -78, -12]$[99, 0, -78, -12]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_LFboYJ9OEeqSgMxfrOAmyg" id="(0.9724137931034482,0.24489795918367346)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_LqCKQJ9OEeqSgMxfrOAmyg" type="4001" element="_LqA8IJ9OEeqSgMxfrOAmyg" source="_oGjDoJ9NEeqSgMxfrOAmyg" target="_lzL54J9NEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_LqCKQZ9OEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_LqCKQp9OEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_LqCKQ59OEeqSgMxfrOAmyg" points="[-1, -1, 98, 10]$[-96, -11, 3, 0]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_M5mUsJ9OEeqSgMxfrOAmyg" id="(0.0,0.7346938775510204)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_MgiUcJ9OEeqSgMxfrOAmyg" id="(0.9793103448275862,0.673469387755102)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_Um_eMZ9OEeqSgMxfrOAmyg" type="4001" element="_Um-3IJ9OEeqSgMxfrOAmyg" source="_lzL54J9NEeqSgMxfrOAmyg" target="_in1_QJ9NEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_Um_eMp9OEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_Um_eM59OEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_Um_eNJ9OEeqSgMxfrOAmyg" points="[0, -11, 1, 144]$[0, -191, 1, -36]"/>
      <sourceAnchor xmi:type="notation:IdentityAnchor" xmi:id="_UnBTYJ9OEeqSgMxfrOAmyg" id="(0.1103448275862069,0.7551020408163265)"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_UnBTYZ9OEeqSgMxfrOAmyg" id="(0.9174311926605505,0.5901639344262295)"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_eRWqsJ9OEeqSgMxfrOAmyg" type="4001" element="_eRWDoJ9OEeqSgMxfrOAmyg" source="_lzL54J9NEeqSgMxfrOAmyg" target="_cz4AEp9OEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_eRWqsZ9OEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_eRWqsp9OEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_eRWqs59OEeqSgMxfrOAmyg" points="[-6, 31, -8, -89]$[-85, 127, -87, 7]"/>
    </edges>
    <edges xmi:type="notation:Edge" xmi:id="_hkXTkJ9OEeqSgMxfrOAmyg" type="4001" element="_hkWsgJ9OEeqSgMxfrOAmyg" source="_cz4AEp9OEeqSgMxfrOAmyg" target="_fmFpAJ9OEeqSgMxfrOAmyg">
      <styles xmi:type="notation:RoutingStyle" xmi:id="_hkXTkZ9OEeqSgMxfrOAmyg"/>
      <styles xmi:type="notation:FontStyle" xmi:id="_hkXTkp9OEeqSgMxfrOAmyg" fontName="Segoe UI"/>
      <bendpoints xmi:type="notation:RelativeBendpoints" xmi:id="_hkXTk59OEeqSgMxfrOAmyg" points="[1, 30, 2, -53]$[-1, 75, 0, -8]"/>
      <targetAnchor xmi:type="notation:IdentityAnchor" xmi:id="_hkYhsJ9OEeqSgMxfrOAmyg" id="NORTH"/>
    </edges>
  </notation:Diagram>
</xmi:XMI>
