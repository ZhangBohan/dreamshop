$.API = {
    opts: {
        root: "/dreamshop"
    },

    get: function(url, data){
        var resultData = new Object();
        $.ajax({
            type:"POST",
            url: url,
            async: false,
            data: data,
            dataType: "json",
            success:function(result){
                if(result.success){
                    resultData =  result.data;
                }else{
                    console.log("SERVER ERROR: " + result.message);
                }
            },
            error:function(result){
                console.log("ERROR: ", result);
            }
        });
        return resultData;
    },

    getGoodsList: function() {
        var url = this.opts.root + '/api/goods/list'
        var param = {
            offset: 0,
            size: 10000
        }
        var resultData = this.get(url, param);
        return resultData.list;
    },

    getGoods: function(barCode) {
        var url = this.opts.root + '/api/goods/get'
        var param = {
            barCode: barCode
        }
        var resultData = this.get(url, param);
        return resultData;
    },

    hasModified: function() {
        var url = this.opts.root + '/api/goods/hasModified'

        var hasModified = this.get(url, {});
        return hasModified;
    },

    getGoodsListByLocalStorage: function() {
        var goodsList = [];

        var jsonStr = localStorage.goodsListStr;
        if(jsonStr) {
            goodsList = JSON.parse(jsonStr);
        }
        if(!goodsList || goodsList.length == 0) {
            goodsList = this.getGoodsList();
            localStorage.goodsListStr = JSON.stringify(goodsList);
        }
        return goodsList;
    },

    addBill: function(bill) {
        var url = this.opts.root + '/api/bill/add'
        var param = {
            data: JSON.stringify(bill)
        }
        var resultData = this.get(url, param);
        console.log("Add bill result:", resultData);
        return resultData;
    }
}