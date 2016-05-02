var startCellId, stopCellId;

$(function() {	
	for (i=startHour; i<=endHour; i++) {
		insertRow(i);
	}
	
	var array = selectedCells.split(";"), i;	
	for (i=0; i<array.length; i++) {
		if (array[i].startsWith("firstCell")) {
			cellDataArray = array[i].split(",");
			var cellName = "cell_" + cellDataArray[2];
			document.getElementById(cellName).className = "highlightedFirstCell";
			document.getElementById(cellName).innerHTML = 
				'<table style="width: 100%;"><tr><td style="width: 50%; background-color: #86C472; text-align: left; border-width: 0px; color: #ffffff;">' + cellDataArray[1] 
				+ '</td><td style="text-align: right; background-color: #86C472; border-width: 0px;"><a href="' + userId + '-' + cellName + '-scheduleDelete.html">x</a></td></tr></table>';
		} else if (document.getElementById("cell_" + array[i]) != null) {
			document.getElementById("cell_" + array[i]).className = "highlighted";
		}
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
		if (document.getElementById(e.target.id).className == "highlighted") {
			window.location.href = userId + '-' + e.target.id + "-scheduleEdit.html";
			return false;
		} else {
			isMouseDown = true;
			document.getElementById(e.target.id).className = "highlighted";
			startCellId = e.target.id;
			return false;
		}
	}).mouseover(function(e) {
		if (isMouseDown) {
			document.getElementById(e.target.id).className = "highlighted";
		}
	}).bind("selectstart", function() {
		return false;
	});
	
	$("#scheduleTable td").mouseup(function(e) {
		if (isMouseDown) {
			isMouseDown = false;
			stopCellId = e.target.id;
			sendResult();
			window.location.href = userId + "-scheduleAddTile.html";
		}
	});
});

function sendResult() {
	var scheduleCell = {startCell: startCellId, stopCell: stopCellId};
	
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
	    url: userId + "-scheduleResult",
	    data: JSON.stringify(scheduleCell),
	    success: function(result) {
	    },
	    async: false
	});
}