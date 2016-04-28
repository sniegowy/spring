$(function() {	
	for (i=startHour; i<=endHour; i++) {
		insertRow(i);
	}
});

function insertRow(i) {
	var table = document.getElementById('scheduleTable');
	var row = table.insertRow(table.rows.length);
	var cell0 = row.insertCell(0);
	var text = document.createTextNode(i);
	cell0.appendChild(text);
	cell0.id = "cell_" + i + "_0";
	for (j=1; j<=5; j++) {
		var cell = row.insertCell(j);
		cell.id = "cell_" + i + "_" + j;
	}
}

$(function() {
	var isMouseDown = false;
	$("#scheduleTable td").not(":first-child").mousedown(function(e) {
		isMouseDown = true;
		$(this).toggleClass("highlighted");
		sendResult(e.target.id, "start");
		return false;
	}).mouseover(function(e) {
		if (isMouseDown) {
			$(this).toggleClass("highlighted");
			sendResult(e.target.id, e.target.className == 'highlighted');
		}
	}).bind("selectstart", function() {
		return false;
	});

	$(document).mouseup(function() {
		sendResult(e.target.id, "stop");
		$("#addTimeModal").modal("show");
		isMouseDown = false;
	});
});

function sendResult(cellNameStr, isHighlightedStr) {
	var scheduleCell = {cellName: cellNameStr, isHighlighted: isHighlightedStr};
	
	$(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken);
    });
	
	$.ajax({
		type: "POST",
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
	    dataType: 'json',
	    url: "scheduleResult",
	    data: JSON.stringify(scheduleCell),
	    success: function(result) {
	    }
	});
}