jQuery(document).ready(function () {
	$(".color").each(function()
	{
		
		if ($(this).text().trim() == "Red") {
        	$(this).css("color", "red");
    	}
    });
});

