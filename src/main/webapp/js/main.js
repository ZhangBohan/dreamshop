$('.selectAll').click(function(){
    var selectAll=$(this);
    var selectItems=$(".selectOne");
    selectItems.attr('checked', this.checked);//全选/全不选
    selectItems.click(function(e){
        e.stopPropagation();//阻止冒泡,避免行点击事件中,直接选择选框无效
        selectAll.attr('checked',selectItems.size()==selectItems.filter(':checked').size()
        );//判断选中个数与实际个数是否相同,以确定全选/全不选状态
    });
});