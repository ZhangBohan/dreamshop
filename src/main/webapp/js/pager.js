(function ($) {
	$.pager = {
			pageList : function(pageDiv,formDiv,currPageDiv,totalDiv,sizeDiv){
				var currPage = $(currPageDiv).val();
				var total = $(totalDiv).val();
				var pageSize = $(sizeDiv).val();
				var pageCount = 0;
				if(total % pageSize != 0){
					pageCount = parseInt(total / pageSize) + 1;
				}else{
					pageCount = total / pageSize;
				}
				console.log(currPage + ":" + total  +  ":"   +  pageSize + ":" + pageCount　);
				if(total > 0){
					$(pageDiv).myPagination({
				      currPage: currPage,
				      pageCount: pageCount,
				      pageSize: pageSize,
				      cssStyle:'pagination',
				      ajax:{
				            onClick:function(page){
				            	$(currPageDiv).val(page);
				            	$(sizeDiv).val(pageSize);
				            	$(formDiv).submit();
				            	
				           }
				       }
				      });
				}else{
					var content = '<div class="alert alert-warning center"><span>没有符合条件的记录</span></div>';
	                $(pageDiv).parent().append(content);
				}
			}
	};
})(jQuery);