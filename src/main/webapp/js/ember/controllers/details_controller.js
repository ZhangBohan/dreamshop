Details.DetailsController = Ember.ArrayController.extend({
    actions: {
        searchResult: function() {
            var flag = false;   // 记录是成功处理
            var searchText = this.get('searchText');
            if(searchText && !searchText.trim()) {return;}
            // 查找当前是否已经录入该商品
            var billDetails = this.filterBy('id');
            var barCode = searchText;   // 首先，要把搜索条件看成是条码
            if(billDetails) {
                for(var i = 0; i < billDetails.length; i++) {
                    var billDetail = billDetails[i];
                    var detailBarCode = billDetail.get('barCode');
                    if(barCode == detailBarCode) {
                        billDetail.set('count', billDetail.get('count') + 1);
                        billDetail.save();
                        // 重新计算总金额
                        var totalSum = parseFloat(this.get('totalSum', 'number')) + billDetail.get('price');
                        totalSum = parseFloat(totalSum, 10).toFixed(2);
                        this.set('totalSum', totalSum);
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) {
                var goodsList = Details.Goods.FIXTURES.filterBy('barCode', searchText);
                if(goodsList && goodsList.length > 0) { // 有结果，直接填加到订单列表中
                    var goods = goodsList[0];   // 直接取第一个，不存在同条码的情况
                    var billDetail = this.store.createRecord('bill-detail', {
                        barCode: goods.barCode,
                        name: goods.name,
                        price: goods.price,
                        unit: goods.unit,
                        count: 1
                    });
                    // 重新计算总金额
                    var totalSum = parseFloat(this.get('totalSum', 'number')) + billDetail.get('price');
                    totalSum = parseFloat(totalSum, 10).toFixed(2);
                    this.set('totalSum', totalSum);
                    billDetail.save();
                    flag = true;
                }
            }

            this.set('searchText', '');
        } ,

        settlement: function() {
            var money = this.get('money');
            var totalSum = this.get('totalSum');
            if(totalSum == 0) {
                // here should be alert user
                $("#barCodeSearch").focus();
                return;
            }

//            this.set('money', money);
            $("#settlement-modal").modal('toggle');
        },

        createBill: function() {
            var totalSum = this.get('totalSum');
            var billDetails = this.filterBy('id');
            var details = [];
            for(var i = 0; i < billDetails.length; i++) {
                details[i] = billDetails[i]._data;
            }
            var bill = this.store.createRecord('bill', {
                total: totalSum,
                details: details
            });
            bill.save();

            $("#settlement-modal").modal('toggle');
            billDetails.invoke('deleteRecord');
            billDetails.invoke('save');
            this.set('totalSum', 0);
            $("#barCodeSearch").focus();
        }
    },

    totalSum: function() {
        var totalSum = 0;
        var billDetails = this.filterBy('id');
        if(billDetails) {
            billDetails.forEach(function(billDetail) {
                totalSum += billDetail.get('price') * billDetail.get('count');
            });
        }
        totalSum = parseFloat(totalSum, 10).toFixed(2);
        return totalSum;
    }.property('@each.id')
});