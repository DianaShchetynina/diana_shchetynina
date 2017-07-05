$('document').ready(function(){


$('.story').each(function(){
  
  var all = $(this).children('.scenario').size()
  var passed = $(this).children('.scenario.passed').size()
  var failed = $(this).children('.scenario.failed').size()
 
  $('<span class="all">'+all+'</span>').insertAfter($(this).children('span'))
  $('<span class="passed">'+passed+'</span>').insertAfter($(this).children('span.all'))
  $('<span class="failed">'+failed+'</span>').insertAfter($(this).children('span.passed'))
})

$('div.scenario:has(div.failed) > h3').addClass('failed')

$('.story > span.storyName').css(
  "color","green");

$('.story:has(div.failed) > span.storyName').css(
  "color","red");

var opened = false;  
  
$('.story > span').on("click",function(){
	if(opened){
		$(this).nextAll('.scenario').fadeOut("slow");		
		opened = false;
	}else{
    	$(this).nextAll().fadeIn("slow");
    	opened = true;
	}
});



$('.scenario > h3').on("click",function(){
	$(this).nextAll('.step').fadeToggle("slow");
});

$('#showAllBtn').on("click",function(){
	$('div.story').show();
});

$('#newBtn').on("click",function(){
	$('div.story').hide();
	$('.story:has(.scenario.newFailed)').show();
	$('.story:has(.newFailed) > div.scenario.newFailed').show();
});

$('#failedBtn').on("click",function(){
	$('div.story').hide();
	$('.story:has(.scenario.failed)').show();
	$('.story:has(.failed) > div.scenario.failed').show();
});

$('#allBtn').on("click",function(){
	$('.scenario').show();
});

$('#collapseAllBtn').on("click",function(){
	$('.scenario').hide();
});

$('img#scroll').click(function(){
  $('.header').animate({height:"150px"});
});


	$('#hide-btn').click(function(e){
	
		$('#chart').fadeToggle();
		
		if($(this).text()=="Show")
		{
			$(this).text("Hide");
		} else {
			$(this).text("Show");
		}
		$(".ISProductBody").toggle();

		$('.header').toggleClass('show-toggle');
		$('.panel').toggleClass('panel-block');

	});
	
	var total = $('div.scenario').size();
	var failedSize = $('.scenario.failed').size();
	var passedSize = $('.scenario.passed').size();
	var newFailed =  $('.scenario.newFailed').size();
	
	$('span#total span').text(total);
	$('span#successful span').text(passedSize);
	$('span#failed span').text(failedSize);
	$('span#newFailures span').text(newFailed);
	
	$('#pie').highcharts({
            colors: ["red", "green"],
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text:''
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['Failed', failedSize],
                    ['Passed', passedSize]
                ]
            }]
        });
		
	$('div.scenario.failed').each(function(){
		var title = $(this).children('.step.failed').children('.failure').text();
		$(this).children('.knowIssue').attr('title',title);
	})

});

