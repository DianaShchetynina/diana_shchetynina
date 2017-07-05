<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/report.css">
<script type="text/javascript" src="resources/jquery-1.11.0.min.js"></script>
<script src="resources/highcharts.js"></script>
<script src="resources/exporting.js"></script>
<script type="text/javascript" src="resources/script.js"></script>
</head>
<body>
<div class='header'>
    <div class='inner'>
          <div class='reportTitle'>Automation Test Results</div>
          <div class='buildNo'><span class='buildNo'>Build No:</span><span>${buildInfo.buildNo}</span></div>
          <div class='buildDate'><span class='buildDate'>Generated on:</span><span>${buildInfo.date}</span></div>
          <div class='stats'>
                    		<span id='total'><strong>Total:</strong>
          						<span>0</span>
          					</span>
                    		<span id='successful'><strong>Successful:</strong>
          						<span>0</span>
          					</span>
                    		<span id='failed'><strong>Failed:</strong>
          						<span>0</span>
          					</span>
                    		<span id='newFailures'><strong>New:</strong>
          						<span>0</span>
          					</span>
          </div>
    </div>
    <div id='chart'>
        <div id="pie"></div>
    </div>
    <button  id="hide-btn">Show</button>
</div>
<div class='wrapper'>
    <div class='panel'>
                <button class='myButton' id="showAllBtn">ALL</button>
                <button class='myButton' id="newBtn">NEW</button>
                <button class='myButton' id="failedBtn">FAILED</button>
                <button class='myButton' id="allBtn">EXPAND</button>
                <button class='myButton' id="collapseAllBtn">COLLAPSE</button>
    </div>
<div class="story-holder">
    <#list stories as story>
        <div class='story'>
            <span class='storyName'>
                <h2>${story.path}</h2>
            </span>
                <#list story.scenarios as scenario>
                    <div class='scenario ${scenario.status}'>
                        <h3>${scenario.keyword} ${scenario.title}</h3>
                        <#list scenario.props as property>
                               <div class='knowIssue'>${property}</div>
                        </#list>
                        <#list scenario.steps as step>
                             <div class='step ${step.outcome}'>${step.text}
                                <div class='failure'>${step.failure}</div>
                             </div>
                        </#list>
                    </div>
                </#list>
        </div>
    </#list>
</div>
</body>
</html>