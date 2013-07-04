$(function(){
	var coll = $(".accordion-inner");

	coll.children().children().each(function(){
		var _this = $(this);

		if(_this.attr("checked")) {
			_this.parent().parent().parent().addClass("in");
			//_this.parentsUntil(".collapse").addClass("in");
		}
	});
});